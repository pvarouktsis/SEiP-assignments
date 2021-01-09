package codeanalyzer.analyzers;

import org.junit.Test;

public class AnalyzerFactoryTest {
  private AnalyzerFactory af = new AnalyzerFactory();
  private String TEST_WRONG_ANALYZER_TYPE = "wrong-analyzer-type";

  @Test (expected = IllegalArgumentException.class)
  public void testInitializeAnalyzer_WrongType() {
    af.initializeAnalyzer(TEST_WRONG_ANALYZER_TYPE);
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

