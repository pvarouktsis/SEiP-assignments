package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes. 
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison).
 * @author agkortzis
 *
 */
public class Analyzer {
	protected String sourceFilepath;
	protected String sourceFileLocation;
	protected String sourceCodeAnalyzerType;
	protected String outputFilepath;
	protected String outputFileType;

	public Analyzer(String sourceFilepath, String sourceFileLocation, String sourceCodeAnalyzerType, String outputFilepath, String outputFileType) {
		this.sourceFilepath = sourceFilepath;
		this.sourceFileLocation = sourceFileLocation;
		this.sourceCodeAnalyzerType = sourceCodeAnalyzerType;
		this.outputFilepath = outputFilepath;
		this.outputFileType = outputFileType;
	}

	public Map<String, Integer> calculateMetrics() throws IOException {
		SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
		SourceFileReader sfr = sfrf.initializeSourceFileReader(sourceFilepath, sourceFileLocation);
		Metric locm = new LOCMetric();
		Metric nocm = new NOCMetric();
		Metric nomm = new NOMMetric();
		int loc, noc, nom;
		loc = noc = nom = -1;
		Map<String, Integer> metrics = new HashMap<String, Integer>();

		if(sourceCodeAnalyzerType.equals("regex")) {
			String sourceCodeString = sfr.readFileIntoString();
			loc = locm.calculateWithRegex(sourceCodeString);
			noc = nocm.calculateWithRegex(sourceCodeString);
			nom = nomm.calculateWithRegex(sourceCodeString);
		} else if(sourceCodeAnalyzerType.equals("strcomp")) {
			List<String> sourceCodeString = sfr.readFileIntoList();
			loc = locm.calculateWithStrcomp(sourceCodeString);
			noc = nocm.calculateWithStrcomp(sourceCodeString);
			nom = nomm.calculateWithStrcomp(sourceCodeString);	
		}

		metrics.put("LOC", loc);
		metrics.put("NOC", noc);
		metrics.put("NOM", nom);
		return metrics;
	}

	public void exportMetrics(Map<String, Integer> metrics) {
		ExporterFactory ef = new ExporterFactory();
		Exporter ex = ef.initializeExporter(outputFilepath, outputFileType);
		ex.write(metrics);
	}
	
	public void execute() throws IOException {
		exportMetrics(calculateMetrics()); // calculate and export metrics
	}

}
