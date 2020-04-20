package math;

import io.FileIO;
import java.util.List;
import java.util.ArrayList;

public class ArrayOperations {

  public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
    int[] numbers = fileIo.readFile(filepath);
    List<Integer> primeNumbers = new ArrayList<>();
    for (int number:numbers) 
      if (myMath.isPrime(number)) 
        primeNumbers.add(number);

    return primeNumbers.stream().mapToInt(x -> x).toArray();
  }

}