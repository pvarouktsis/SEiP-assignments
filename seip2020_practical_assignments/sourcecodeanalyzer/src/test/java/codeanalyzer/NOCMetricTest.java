package codeanalyzer;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class NOCMetricTest {
  private NOCMetric nocm = new NOCMetric();
  private LocalFileReader lfr = new LocalFileReader("src/test/resources/TestClass.java"); 

  @Test
	public void testCalculateRegex() throws IOException {
    String testSourceCodeString = lfr.readFileIntoString();
		assertEquals(3, nocm.calculateWithRegex(testSourceCodeString));
  }
  
  @Test
	public void testCalculateStrcomp() throws IOException {
    List<String> testSourceCodeList = lfr.readFileIntoList();
		assertEquals(3, nocm.calculateWithStrcomp(testSourceCodeList));
  }
  
}