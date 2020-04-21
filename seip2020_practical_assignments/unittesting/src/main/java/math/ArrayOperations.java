package math;

import io.FileIO;
import math.MyMath;
import java.util.List;
import java.util.ArrayList;

/**
 * ArrayOperations implements a simple method,
 * using already existing code, to find all 
 * prime natural numbers in a file.
 * @author Panagiotis Varouktsis
 * @version 1.0
 * @since 2020-04-21
 */
public class ArrayOperations {

  /**
   * Processes a file and finds all 
   * primes natural numbers of it. 
   * @param fileIo the object to call readFile method
   * @param filepath the filepath of the .txt file
   * @param myMath the object to call isPrime method
   * @return an array with all the prime natural numbers
   */
  public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
    int[] numbers = fileIo.readFile(filepath);
    List<Integer> primeNumbers = new ArrayList<>();
    for (int number:numbers) {
      try {
        if (myMath.isPrime(number)) 
          primeNumbers.add(number);
      } catch (IllegalArgumentException e) {
        /* Ignore & Continue */
        continue;
      }
    }
    return primeNumbers.stream().mapToInt(x -> x).toArray();
  }

}