package codeanalyzer;

//import static org.junit.Assert.*;
import org.junit.Test;

public class SourceFileReaderFactoryTest {
  private SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
  //private SourceFileReader actualsfr = null;
  //private SourceFileReader expectedsfr = null;
  private String TEST_FILE = "whatever-path";
  //private String TEST_RIGHT_FILETYPE = "local";
  private String TEST_WRONG_FILETYPE = "wrong-file-type";

  // Similar to testReadFileIntoStringNull and testReadFileIntoListNull
  @Test (expected = IllegalArgumentException.class)
  public void testInitializeSourceFileReader_WrongType() {
    sfrf.initializeSourceFileReader(TEST_FILE, TEST_WRONG_FILETYPE);
  }
  
  @Test
  public void testInitializeSourceFileReader_LocalType() {
    // TODO
    /*
    expectedsfr = new LocalFileReader(TEST_FILE);
    actualsfr = sfrf.initializeSourceFileReader(TEST_FILE, TEST_RIGHT_FILETYPE);
    assertEquals(expectedsfr.equals(actualsfr));
    */
  }

}
