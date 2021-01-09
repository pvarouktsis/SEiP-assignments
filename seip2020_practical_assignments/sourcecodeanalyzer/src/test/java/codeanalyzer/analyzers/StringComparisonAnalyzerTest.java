package codeanalyzer.analyzers;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringComparisonAnalyzerTest {
  private static String inputFile = "src/test/resources/TestClass.java";
  private static String inputFileLocation = "local";
  private static String outputFile = "outputs";
  private static String outputFileType = "csv";
  private Analyzer analyzer = new StringComparisonAnalyzer();

  @Test
  public void testCalculateMetrics() throws IOException {
    Map<String, Integer> expectedMetrics = new HashMap<String, Integer>();
    Map<String, Integer> actualMetrics = new HashMap<String, Integer>();
    
    expectedMetrics.put("LOC", 7);
    expectedMetrics.put("NOM", 3);
    expectedMetrics.put("NOC", 3);
    actualMetrics = analyzer.calculateMetrics(inputFile, inputFileLocation);
    
    assertEquals(actualMetrics, expectedMetrics);
  }

  // @Test
  // public void testExportMetrics() {
  //   File file = new File(outputFile + ".csv");
  //   Map<String, Integer> metrics = new HashMap<String, Integer>();
  //   metrics.put("LOC", 7);
  //   metrics.put("NOM", 3);
  //   metrics.put("NOC", 3);
    
  //   analyzer.exportMetrics(metrics);
  //   assertTrue(file.exists());

  //   file.delete();
  // }

}