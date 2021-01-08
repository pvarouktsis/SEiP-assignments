package codeanalyzer.analyzers;

import org.junit.Test;

public class AnalyzerFactoryTest {
  private AnalyzerFactory af = new AnalyzerFactory();
  private String TEST_WRONG_INPUT_FILE_TYPE = "wrong-input-file-type";
  private String TEST_WRONG_INPUT_FILE_LOCATION = "wrong-input-file-location";
  private String TEST_WRONG_ANALYZER_TYPE = "wrong-analyzer-type";
  private String TEST_WRONG_OUTPUT_FILE = "wrong-output-file";
  private String TEST_WRONG_OUTPUT_FILE_TYPE = "wrong-output-file-type";

  @Test (expected = IllegalArgumentException.class)
  public void testInitializeAnalyzer_WrongType() {
    af.initializeAnalyzer(TEST_WRONG_INPUT_FILE_TYPE, TEST_WRONG_INPUT_FILE_LOCATION, TEST_WRONG_ANALYZER_TYPE, TEST_WRONG_OUTPUT_FILE, TEST_WRONG_OUTPUT_FILE_TYPE);
  }
  
  @Test
  public void testInitializeAnalyzer_RegexType() {
    // TODO
  }

  @Test 
  public void testInitializeAnalyzer_StringComparisonType() {
    // TODO
  }

}

