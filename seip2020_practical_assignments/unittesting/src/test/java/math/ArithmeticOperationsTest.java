package math;

import org.junit.Test;
import org.junit.Assert;

public class ArithmeticOperationsTest {
  ArithmeticOperations ops = new ArithmeticOperations();

  @Test
  public void testDivide() {
    Assert.assertEquals(2.0, ops.divide(10.0, 5.0), 0.0001);
  }
  
  @Test (expected = ArithmeticException.class)
  public void testDivideExceptiion() {
    ops.divide(10.0, 0.0);
  } 
}