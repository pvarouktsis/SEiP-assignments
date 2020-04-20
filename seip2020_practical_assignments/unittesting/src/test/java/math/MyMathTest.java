package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MyMathTest {
  MyMath mm = new MyMath();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testFactorial_negativeInput_expectedIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Expected x >= 0");
    mm.factorial(-5);
  }

  @Test
  public void testFactorial_outOfBoundsInput_expectedIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Expected x <= 12");
    mm.factorial(13);
  }
}
