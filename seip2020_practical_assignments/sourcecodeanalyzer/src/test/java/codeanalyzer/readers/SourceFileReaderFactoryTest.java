package codeanalyzer.readers;

import org.junit.Test;

public class SourceFileReaderFactoryTest {
  private SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
  private String TEST_FILE = "whatever-path";
  private String TEST_WRONG_FILETYPE = "wrong-file-type";

  @Test (expected = IllegalArgumentException.class)
  public void testInitializeSourceFileReader_WrongType() {
    sfrf.initializeSourceFileReader(TEST_WRONG_FILETYPE);
  }
  
  @Test
  public void testInitializeSourceFileReader_LocalType() {
    // TODO
  }

  @Test 
  public void testInitializeSourceFileReader_WebType() {
    // TODO
  }

}