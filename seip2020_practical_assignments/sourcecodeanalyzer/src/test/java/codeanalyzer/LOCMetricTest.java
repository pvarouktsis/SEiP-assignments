package codeanalyzer;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class LOCMetricTest {
  private LOCMetric locm = new LOCMetric();
  private LocalFileReader lfr = new LocalFileReader("src/test/resources/TestClass.java"); 

  @Test
	public void testCalculateRegex() throws IOException {
    String testSourceCodeString = lfr.readFileIntoString();
		assertEquals(21, locm.calculateWithRegex(testSourceCodeString));
  }
  
  @Test
	public void testCalculateStrcomp() throws IOException {
    List<String> testSourceCodeList = lfr.readFileIntoList();
		assertEquals(7, locm.calculateWithStrcomp(testSourceCodeList));
	}
  
}