package sing.java.pi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class LeibnizFormula {


  private final BigDecimal FOUR = BigDecimal.valueOf(4);
  private MathContext calcMathContext = MathContext.UNLIMITED;
  private MathContext valueMathContext = MathContext.UNLIMITED;

  private long loops = 0;
  private long divisor = 0;

  public long getLoops() {
    return loops;
  }

  public long getDivisor() {
    return divisor;
  }

  private BigDecimal currentResult = BigDecimal.ZERO;

  public BigDecimal getCurrentResult() {
    return this.currentResult.round(valueMathContext);
  }

  public BigDecimal generate(int digits) {
    calcMathContext = new MathContext(digits + 20, RoundingMode.HALF_UP);
    valueMathContext = new MathContext(digits + 1, RoundingMode.HALF_UP);

    currentResult = BigDecimal.ZERO;
    BigDecimal currentValue = BigDecimal.ONE;
    boolean add = true;
    divisor = -1;
    loops = 0;

    while (!getValue(currentValue).equals(getValue(currentResult))) {
      loops++;
      divisor += 2;
      currentValue = currentResult;

      BigDecimal n = FOUR;
      BigDecimal i1 = BigDecimal.valueOf(divisor);

      currentResult = add ? currentResult.add(n.divide(i1, calcMathContext))
          : currentResult.subtract(n.divide(i1, calcMathContext));
      add = !add;
    }

    return currentResult.round(valueMathContext);
  }

  private String getValue(BigDecimal v) {
    return v.round(valueMathContext).toPlainString();
  }
}
