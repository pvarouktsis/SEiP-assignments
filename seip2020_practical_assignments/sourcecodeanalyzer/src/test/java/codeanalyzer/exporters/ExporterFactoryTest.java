package codeanalyzer.exporters;

import org.junit.Test;

public class ExporterFactoryTest {
  private ExporterFactory ef = new ExporterFactory();
  private final String TEST_WRONG_FILETYPE = "whatever-type";

  @Test (expected = IllegalArgumentException.class)
  public void testInitializeExporter_WrongType() {
    ef.initializeExporter(TEST_WRONG_FILETYPE);
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