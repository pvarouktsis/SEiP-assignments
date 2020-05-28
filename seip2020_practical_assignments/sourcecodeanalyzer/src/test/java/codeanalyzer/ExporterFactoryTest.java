package codeanalyzer;

import org.junit.Test;

public class ExporterFactoryTest {
  private ExporterFactory ef = new ExporterFactory();
  private String TEST_FILE = "whatever-file";
  private String TEST_FILETYPE = "whatever-type";

  // Similar to testWriteFileWithUnknownFileType
  @Test (expected = IllegalArgumentException.class)
  public void testInitializeExporter_WrongType() {
    ef.initializeExporter(TEST_FILE, TEST_FILETYPE);
  }

  @Test
  public void testInitializeExporter_LocalType() {
    // TODO
  }
}