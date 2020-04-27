package math;

import io.FileIO;
import math.MyMath;
import math.ArrayOperations;
import java.io.File;

import org.junit.Test;
import org.junit.Assert;
import static org.mockito.Mockito.*;

public class ArrayOperationsTest {
  ArrayOperations arrayOps = new ArrayOperations();
  String filepath;

  @Test
  public void testFindPrimesInFile_validTestingCases_expectedOutputs() {
    int[] expectedValidSample = {2, 3, 5, 7, 11, 13};
    filepath = new File("src/test/resources/valid_sample.txt").getAbsolutePath();

    FileIO fio = mock(FileIO.class);
    when(fio.readFile(filepath)).thenReturn(new int[]
      {-999999999, -2, -1, 0, 1, 2, 3, 4, 5, 7, 9, 11, 13, 999999999});
    
    MyMath mm = mock(MyMath.class);
    when(mm.isPrime(2)).thenReturn(true);
    when(mm.isPrime(3)).thenReturn(true);
    when(mm.isPrime(4)).thenReturn(false);  
    when(mm.isPrime(5)).thenReturn(true);  
    when(mm.isPrime(7)).thenReturn(true);  
    when(mm.isPrime(8)).thenReturn(false);  
    when(mm.isPrime(9)).thenReturn(false);
    when(mm.isPrime(11)).thenReturn(true);
    when(mm.isPrime(13)).thenReturn(true);  
    when(mm.isPrime(999999999)).thenReturn(false);

    Assert.assertArrayEquals(expectedValidSample, arrayOps.findPrimesInFile(fio, filepath, mm));
  }

  @Test
  public void testFindPrimesInFile_invalidTestingCases_zeroOutputs() { 
    int[] expectedValidSample = {}; // zero outputs
    filepath = new File("src/test/resources/invalid_sample.txt").getAbsolutePath();

    FileIO fio = mock(FileIO.class);
    when(fio.readFile(filepath)).thenReturn(new int[]
      {-999999999, -2, 0, 1});
    
    MyMath mm = mock(MyMath.class);
    when(mm.isPrime(-999999999)).thenThrow(new IllegalArgumentException());
    when(mm.isPrime(-2)).thenThrow(new IllegalArgumentException());
    when(mm.isPrime(0)).thenThrow(new IllegalArgumentException());
    when(mm.isPrime(1)).thenThrow(new IllegalArgumentException());

    Assert.assertArrayEquals(expectedValidSample, arrayOps.findPrimesInFile(fio, filepath, mm));
  }
  
}
