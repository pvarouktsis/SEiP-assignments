package codeanalyzer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.verify; 

public class JSONExporterTest {
	private String outputFilepath = "whatever-path";
	private JSONExporter jsone = new JSONExporter(outputFilepath);

  @Test
	public void testWriteJson() {
    JSONExporter spye = spy(jsone);

    // create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		
		// this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(spye).write(metrics);
		spye.write(metrics);
    
    // just verify that the method was executed/called
		verify(spye).write(metrics);
	}
  
}