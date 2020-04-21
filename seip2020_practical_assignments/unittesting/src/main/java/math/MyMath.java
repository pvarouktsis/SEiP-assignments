package math;

import java.util.ArrayList;

/**
 * MyMath provides simple mathematical methods that
 * are used for practicing Unit Test Techniques.
 * @author  Panagiotis Varouktsis
 * @version 1.0
 * @since   2020-04-19
 */
public class MyMath {

  /**
   * Factorial method finds the factorial of a 
   * number in the interval [0, 12].
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
  
  /**
   * Performs some simple mathematical operations to check if an input 
   * number (x) is a natural prime number. First of all, checks if x is
   * greater than 2, otherwise it is not a natural prime number and throws 
   * a new IllegalArgumentException. Then, if x is greater than 2 and 
   * x modulo 2 equals 0, returns false. Else, initializes a variable, 
   * possibleFactor, given the value of 3 and while the square of the
   * possibleFactor is less than x, checks the x modulo possibleFactor
   * if equals 0. If yes, returns false, otherwise, increases the 
   * possibleFactor by 2 and checks again, till the condition will be turned
   * false. 
   * @param x the input number
   * @return true if x is a prime number, false otherwise
   * @exception IllegalArgumentException when x < 2
   */
  public boolean isPrime(int x) {
    if (x < 2) {
      throw new IllegalArgumentException("Expected x >= 2");
    }

    boolean isPrime = true;
    if ((x > 2) && (x % 2 == 0)) {
      isPrime = false;
      return isPrime;
    }
    int possibleFactor = 3;
    while ((possibleFactor * possibleFactor) <= x) {
      if (x % possibleFactor == 0) {
        isPrime = false;
        return isPrime;
      }
      possibleFactor += 2;
    }
    return isPrime;
  }

}
