package codeanalyzer.metrics;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import codeanalyzer.readers.LocalFileReader;

public class NOCMetricTest {
  private String sourceFilepath = "src/test/resources/TestClass.java";
  private NOCMetric nocm = new NOCMetric();
  private LocalFileReader lfr = new LocalFileReader(); 

  @Test
	public void testCalculateRegex() throws IOException {
    String testSourceCodeString = lfr.readFileIntoString(sourceFilepath);
		assertEquals(3, nocm.calculateWithRegex(testSourceCodeString));
  }
  
  @Test
	public void testCalculateStrcomp() throws IOException {
    List<String> testSourceCodeList = lfr.readFileIntoList(sourceFilepath);
		assertEquals(3, nocm.calculateWithStrcomp(testSourceCodeList));
  }
  
}