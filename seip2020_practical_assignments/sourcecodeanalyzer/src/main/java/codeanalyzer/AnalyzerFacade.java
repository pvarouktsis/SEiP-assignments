package codeanalyzer;

import java.io.IOException;

import codeanalyzer.analyzers.*;

public class AnalyzerFacade {
	private String sourceFilepath;
	private String sourceFileLocation;
	private String sourceCodeAnalyzerType;
	private String outputFilepath;
	private String outputFileType;

  /**
   * Initializes the fields of the AnalyzerFacade.
   * @param sourceFilepath, the path of the input file
   * @param sourceFileLocation, web or local
   * @param sourceCodeAnalyzerType, regex or strcomp
   * @param outputFilepath, the path of the output file
   * @param outputFileType, the format of the output file
   */
	public AnalyzerFacade(String sourceFilepath, String sourceFileLocation, String sourceCodeAnalyzerType, String outputFilepath, String outputFileType) {
		this.sourceFilepath = sourceFilepath;
		this.sourceFileLocation = sourceFileLocation;
		this.sourceCodeAnalyzerType = sourceCodeAnalyzerType;
		this.outputFilepath = outputFilepath;
		this.outputFileType = outputFileType;
	}
	
	/**
	 * Calls calculateMetrics and exportMetrics to
	 * analyze the source code and export the results.
	 * @throws IOException
	 */
	public void execute() throws IOException {
		AnalyzerFactory af = new AnalyzerFactory();
		Analyzer analyzer = af.initializeAnalyzer(sourceFilepath, sourceFileLocation, sourceCodeAnalyzerType, outputFilepath, outputFileType);
		analyzer.exportMetrics(analyzer.calculateMetrics()); // calculate and export metrics
	}

}