package codeanalyzer;

import java.io.IOException;

import codeanalyzer.analyzers.*;

/**
 * A facade class for the source code analysis.
 * It calculates and exports the metrics.
 */
public class AnalyzerFacade {
	/**
	 * Calls calculateMetrics and exportMetrics to
	 * analyze the source code and export the results.
	 * @throws IOException
	 */
	public void execute(String sourceFilepath, String sourceFileLocation, String sourceCodeAnalyzerType, String outputFilepath, String outputFileType) throws IOException {
		AnalyzerFactory af = new AnalyzerFactory();
		Analyzer analyzer = af.initializeAnalyzer(sourceFilepath, sourceFileLocation, sourceCodeAnalyzerType, outputFilepath, outputFileType);
		analyzer.exportMetrics(analyzer.calculateMetrics()); // calculate and export metrics
	}

}
