package io;

import java.io.File;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class FileIOTest {
  FileIO fio = new FileIO();
  String filepath;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testReadFile_validTestingCase_expectedOutputs() {
    int[] expectedValidSample = {3, 4, 5, 7, 0, 9, 6, 2, 0, 0, -2, 8, 0, 0, 4, 10, -4, 2, 2, 4};
    filepath = new File("src/test/resources/valid_sample.txt").getAbsolutePath();
    Assert.assertArrayEquals(expectedValidSample, fio.readFile(filepath));
  }

  @Test
  public void testReadFileContainsInvalidEntries() {
    int[] expectedInvalidSample = {3, 4, 5, 0, 9, 6, -2, 0, 0, 8, 0, 4, 4, 2, 2, 999999999, 4, -5, 0};
    filepath = new File("src/test/resources/invalid_sample.txt").getAbsolutePath();
    Assert.assertArrayEquals(expectedInvalidSample, fio.readFile(filepath));
  }

  @Test
  public void testReadFile_notExistingInputFile_expectedIllegalArgumentException() {
    filepath = new File("src/test/resources/not_existing_sample.txt").getAbsolutePath();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Input file does not exist");
    fio.readFile(filepath);
  }

  @Test
  public void testReadFile_emptyInputFile_expectedIllegalArgumentException() {
    filepath = new File("src/test/resources/empty_sample.txt").getAbsolutePath();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Given file is empty");
    fio.readFile(filepath);
  }

}
