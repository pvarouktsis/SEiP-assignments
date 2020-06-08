package codeanalyzer;

import org.junit.Test;

public class ExporterFactoryTest {
  private ExporterFactory ef = new ExporterFactory();
  private final String TEST_FILE = "whatever-file";
  private final String TEST_FILETYPE = "whatever-type";

  // Similar to testWriteFileWithUnknownFileType
  @Test (expected = IllegalArgumentException.class)
  public void testInitializeExporter_WrongType() {
    ef.initializeExporter(TEST_FILE, TEST_FILETYPE);
  }

  @Test
  public void testInitializeExporter_CSVType() {
    // TODO
  }

  @Test
  public void testInitializeExporter_JSONType() {
    // TODO
  }

}