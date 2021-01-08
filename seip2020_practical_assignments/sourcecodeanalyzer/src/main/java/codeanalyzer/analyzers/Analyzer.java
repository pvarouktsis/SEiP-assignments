package codeanalyzer.analyzers;

import java.io.IOException;
import java.util.Map;

import codeanalyzer.exporters.*;

/**
 * An abstract class for different types
 * of analyzers.
 * @author pvarouktsis
 * 
 */
public abstract class Analyzer {
	protected String sourceFilepath;
	protected String sourceFileLocation;
	protected String outputFilepath;
	protected String outputFileType;

	/**
	 * Initializes the necessary instances for each type
	 * of Analyzer.
	 * @param sourceFilepath, the path of the input file
	 * @param sourceFileLocation, web or local
	 * @param outputFilepath, the path of the output file
	 * @param outputFileType, the format of the output file
	 */
	public Analyzer(String sourceFilepath, String sourceFileLocation, String outputFilepath, String outputFileType) {
		this.sourceFilepath = sourceFilepath;
		this.sourceFileLocation = sourceFileLocation;
		this.outputFilepath = outputFilepath;
		this.outputFileType = outputFileType;
	}

	/**
	 * Calculates the source code metrics (loc, noc, nom).
	 * @return a Map that contains the name and the value of
	 * each metric analyzed
	 * @throws IOException
	 */
	public abstract Map<String, Integer> calculateMetrics() throws IOException;

	/**
	 * Exports source code metrics based on the outputFilepath
	 * and outputFileType.
	 * @param metrics, the metrics (loc, nom, noc) to export
	 */
	public void exportMetrics(Map<String, Integer> metrics) {
		ExporterFactory ef = new ExporterFactory();
		Exporter ex = ef.initializeExporter(outputFilepath, outputFileType);
		ex.write(metrics);
	}

}