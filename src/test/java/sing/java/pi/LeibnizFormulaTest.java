package sing.java.pi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class LeibnizFormulaTest {
  private LeibnizFormula obj = new LeibnizFormula();

  @ParameterizedTest
  @CsvSource(textBlock = """
       0,3,5,3
       1,119,237,3.1
       2,295,589,3.14
       3,10794,21587,3.142
       4,23446,46891,3.1416
       5,426183,852365,3.14159
       6,6510850,13021699,3.141593
       7,278567576,557135151,3.1415927
      """)
  public void testGenerate(int digits, long loops, long divisor, String expected) {
    obj.generate(digits);
    assertEquals(expected, obj.getCurrentResult().toPlainString());
    assertEquals(loops, obj.getLoops());
    assertEquals(divisor, obj.getDivisor());
  }
}

