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

  @Test
  public void testIsPrime_validInputs_expectedOutputs() {
    Assert.assertTrue(mm.isPrime(2));
    Assert.assertTrue(mm.isPrime(3));
    Assert.assertTrue(mm.isPrime(5));
    Assert.assertTrue(mm.isPrime(7));
    Assert.assertTrue(mm.isPrime(11));
    Assert.assertTrue(mm.isPrime(13));
    Assert.assertTrue(mm.isPrime(17));
    Assert.assertTrue(mm.isPrime(19));
    Assert.assertTrue(mm.isPrime(89));
    Assert.assertTrue(mm.isPrime(Integer.MAX_VALUE - 18)); // 2,147,483,647 - 18 = 2,147,483,629
    //
    Assert.assertFalse(mm.isPrime(4));
    Assert.assertFalse(mm.isPrime(6));
    Assert.assertFalse(mm.isPrime(8));
    Assert.assertFalse(mm.isPrime(9));
    Assert.assertFalse(mm.isPrime(10));
    Assert.assertFalse(mm.isPrime(12));
    Assert.assertFalse(mm.isPrime(14));
    Assert.assertFalse(mm.isPrime(345));
    Assert.assertFalse(mm.isPrime(9832));
    Assert.assertFalse(mm.isPrime(234));
    Assert.assertFalse(mm.isPrime(Integer.MAX_VALUE)); // 2,147,483,647
    //TODO bigger than maximum integer
  }

  @Test
  public void testIsPrime_invalidInput_expectedIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Expected x >= 2");
    mm.isPrime(0);
  }

  @Test
  public void testIsPrime_OutOfBoundsInput_expectedIllegalArgumentException() {
    thrown.expect(IllegalArgumentException.class);
    mm.isPrime(Integer.MAX_VALUE + 1);
  }
}
