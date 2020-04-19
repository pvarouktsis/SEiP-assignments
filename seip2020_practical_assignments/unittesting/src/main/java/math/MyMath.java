package math;

/**
 * MyMath provides a simple recursive method that
 * finds the factorial of a number in the interval [0, 12].
 * @author  Panagiotis Varouktsis
 * @version 1.0
 * @since   2020-04-19
 */
public class MyMath {

  /**
   * Performs recursive calls, decreasing each
   * time the input by 1, until 0, where it returns 1.
   * Finally returns, recursively, the product of them.
   * @param x the input
   * @return the factorial of the x
   * @exception IllegalArgumentException when x < 0
   * @exception IllegalArgumentException when x > 12
   */
  public int factorial(int x) {
    if (x < 0) {
      throw new IllegalArgumentException("Expected x >= 0");
    } else if (x > 12) {
      throw new IllegalArgumentException("Expected x <= 12");
    } else {
      if (x == 0) {
        return 1;
      } else {
        return x * factorial(x-1);
      }
    }
  }

}
