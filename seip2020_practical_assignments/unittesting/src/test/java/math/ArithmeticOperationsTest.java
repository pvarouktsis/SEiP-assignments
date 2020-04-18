package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
  ArithmeticOperations arops = new ArithmeticOperations();

  @Test
  public void testDivide() {
    Assert.assertEquals(2.0, arops.divide(10.0, 5.0), 0.0001);
  }
  
  @Test (expected = ArithmeticException.class)
  public void testDivideExceptiion() {
    arops.divide(10.0, 0.0);
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testMultiplyForNegativeInputs() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("x & y should be >= 0");
    arops.multiply(-1, 5);
  }

  @Test
  public void testMultiplyForIntegerMaxValueOutput() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The product does not fit in an Integer variable");
    arops.multiply(Integer.MAX_VALUE/5, 10);
  }
}
