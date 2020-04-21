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
    int[] expectedValidSample = {3, 5, 7, 2, 2, 2, 7, 5};
    filepath = new File("src/test/resources/valid_sample.txt").getAbsolutePath();

    FileIO fio = mock(FileIO.class);
    when(fio.readFile(filepath)).thenReturn(new int[]
      {3, 4, 5, 7, 0, 9, 6, 2, 0, 0, -2, 8, 0, 0, 4, 10, -4, 2, 2, 4, 7, 10, 5, 8, 9, 1, 4, -6, 10, 0});
    
    MyMath mm = mock(MyMath.class);
    when(mm.isPrime(3)).thenReturn(true);
    when(mm.isPrime(4)).thenReturn(false);
    when(mm.isPrime(5)).thenReturn(true);
    when(mm.isPrime(7)).thenReturn(true);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(9)).thenReturn(false);
    when(mm.isPrime(6)).thenReturn(false);
    when(mm.isPrime(2)).thenReturn(true);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(-2)).thenReturn(false);
    when(mm.isPrime(8)).thenReturn(false);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(4)).thenReturn(false);
    when(mm.isPrime(10)).thenReturn(false);
    when(mm.isPrime(-4)).thenReturn(false);
    when(mm.isPrime(2)).thenReturn(true);
    when(mm.isPrime(2)).thenReturn(true);
    when(mm.isPrime(4)).thenReturn(false);  
    when(mm.isPrime(7)).thenReturn(true);  
    when(mm.isPrime(10)).thenReturn(false);  
    when(mm.isPrime(5)).thenReturn(true);  
    when(mm.isPrime(8)).thenReturn(false);  
    when(mm.isPrime(9)).thenReturn(false);  
    when(mm.isPrime(1)).thenReturn(false);  
    when(mm.isPrime(4)).thenReturn(false);  
    when(mm.isPrime(-6)).thenReturn(false);  
    when(mm.isPrime(10)).thenReturn(false);
    when(mm.isPrime(9)).thenReturn(false);    

    Assert.assertArrayEquals(expectedValidSample, arrayOps.findPrimesInFile(fio, filepath, mm));
  }

  @Test
  public void testFindPrimesInFile_invalidTestingCases_expectedOutputs() throws IllegalArgumentException {
    int[] expectedInvalidSample = {3, 5, 2, 2, 11, 7, 13, 13};
    filepath = new File("src/test/resources/invalid_sample.txt").getAbsolutePath();

    FileIO fio = mock(FileIO.class);
    when(fio.readFile(filepath)).thenReturn(new int[]
    {3, 4, 5, 0, 9, 6, -2, 0, 0, 8, 0, 4, 4, 2, 2, 999999999, 4, -5, 0, 15, 11, 1, 6, 7, -3, 13, 13, 4});
    
    MyMath mm = mock(MyMath.class);
    when(mm.isPrime(3)).thenReturn(true);
    when(mm.isPrime(4)).thenReturn(false);
    when(mm.isPrime(5)).thenReturn(true);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(9)).thenReturn(false);
    when(mm.isPrime(6)).thenReturn(false);
    when(mm.isPrime(-2)).thenReturn(false);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(8)).thenReturn(false);
    when(mm.isPrime(0)).thenReturn(false);
    when(mm.isPrime(4)).thenReturn(false);
    when(mm.isPrime(4)).thenReturn(false);
    when(mm.isPrime(2)).thenReturn(true);
    when(mm.isPrime(2)).thenReturn(true);
    when(mm.isPrime(999999999)).thenReturn(false);
    when(mm.isPrime(4)).thenReturn(false);
    when(mm.isPrime(-5)).thenReturn(false);  
    when(mm.isPrime(0)).thenReturn(false);  
    when(mm.isPrime(15)).thenReturn(false);  
    when(mm.isPrime(11)).thenReturn(true);  
    when(mm.isPrime(1)).thenReturn(false);  
    when(mm.isPrime(6)).thenReturn(false);  
    when(mm.isPrime(7)).thenReturn(true);  
    when(mm.isPrime(-3)).thenReturn(false);  
    when(mm.isPrime(13)).thenReturn(true);  
    when(mm.isPrime(13)).thenReturn(true);  
    when(mm.isPrime(4)).thenReturn(false);  

    Assert.assertArrayEquals(expectedInvalidSample, arrayOps.findPrimesInFile(fio, filepath, mm));
  }

}
