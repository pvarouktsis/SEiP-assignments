package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
  ArithmeticOperations arops = new ArithmeticOperations();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testDivide_validTestingCases_expectedOutputs() {
    //
    Assert.assertEquals(2.0, arops.divide(10.0, 5.0), 0.0001);
    Assert.assertEquals(0.0, arops.divide(0.0, 5.0), 0.0001);
    Assert.assertEquals(3.3333, arops.divide(10.0, 3.0), 0.0001);
    //
    Assert.assertEquals(-2.0, arops.divide(10.0, -5.0), 0.0001);
    Assert.assertEquals(0.0, arops.divide(0.0, -5.0), 0.0001);
    Assert.assertEquals(-3.3333, arops.divide(10.0, -3.0), 0.0001);
    //
    Assert.assertEquals(-2.0, arops.divide(-10.0, 5.0), 0.0001);
    Assert.assertEquals(0.0, arops.divide(-0.0, 5.0), 0.0001);
    Assert.assertEquals(-3.3333, arops.divide(-10.0, 3.0), 0.0001);
    //
    Assert.assertEquals(2.0, arops.divide(-10.0, -5.0), 0.0001);
    Assert.assertEquals(0.0, arops.divide(-0.0, -5.0), 0.0001);
    Assert.assertEquals(3.3333, arops.divide(-10.0, -3.0), 0.0001);
  }
  
  @Test (expected = ArithmeticException.class)
  public void testDivide_divideByZero_expectedArithmeticException() {
    arops.divide(10.0, 0.0);
  }

  @Test
  public void testMultiply_validTestingCases_expectedOutputs() {
    Assert.assertEquals(1, arops.multiply(1, 1));
    Assert.assertEquals(98, arops.multiply(1, 98));
    Assert.assertEquals(1376515, arops.multiply(587, 2345));
    Assert.assertEquals(0, arops.multiply(0, 91));
    Assert.assertEquals(0, arops.multiply(85, 0));
    Assert.assertEquals(0, arops.multiply(0, 0));
  }

  @Test
  public void testMultiply_negativeFirstInput_expectedIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("x & y should be >= 0");
    arops.multiply(-1, 5);
  }

  @Test
  public void testMultiply_negativeSecondInput_expectedIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("x & y should be >= 0");
    arops.multiply(1, -5);
  }

  @Test
  public void testMultiply_negativeBothInputs_expectedIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("x & y should be >= 0");
    arops.multiply(-1, -5);
  }

  @Test
  public void testMultiply_outOfBoundsOutput_expectedIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The product does not fit in an Integer variable");
    arops.multiply(Integer.MAX_VALUE/5, 10);
  }
}
