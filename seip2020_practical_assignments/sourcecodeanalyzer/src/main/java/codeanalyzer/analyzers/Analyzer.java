package codeanalyzer.analyzers;

import java.io.IOException;
import java.util.Map;

import codeanalyzer.exporters.*;

/**
 * An interface to implement different
 * types of analyzers.
 * @author pvarouktsis
 * 
 */
public interface Analyzer {
	public Map<String, Integer> calculateMetrics(String sourceFilepath, String sourceFileLocation) throws IOException;

}
