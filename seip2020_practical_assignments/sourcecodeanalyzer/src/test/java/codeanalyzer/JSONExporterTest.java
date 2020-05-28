package codeanalyzer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class JSONExporterTest {
  String outputFilepath = "whatever-path";

  @Test
	public void testWriteJson() {
    JSONExporter jsone = new JSONExporter(outputFilepath);
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