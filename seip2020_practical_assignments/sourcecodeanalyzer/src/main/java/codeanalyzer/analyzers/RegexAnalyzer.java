package codeanalyzer.analyzers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.readers.*;
import codeanalyzer.metrics.*;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc = number of classes as
 * a RegexAnalyzer. This means that reads the given file 
 * as a String.
 * @author agkortzis
 * @author pvarouktsis
 * 
 */
public class RegexAnalyzer extends Analyzer {

	/**
	 * Initializes the necessary parent instances of the RegexAnalyzer.
	 */
	public RegexAnalyzer(String sourceFilepath, String sourceFileLocation, String outputFilepath, String outputFileType) {
		super(sourceFilepath, sourceFileLocation, outputFilepath, outputFileType);
	}

	/**
	 * Calculates the source code metrics (loc, noc, nom).
	 * @return a Map that contains the name and the value of
	 * each metric analyzed
	 * @throws IOException
	 */
	@Override
	public Map<String, Integer> calculateMetrics() throws IOException {
		SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
		SourceFileReader sfr = sfrf.initializeSourceFileReader(sourceFilepath, sourceFileLocation);
		Metric locm = new LOCMetric();
		Metric nocm = new NOCMetric();
		Metric nomm = new NOMMetric();
		int loc, noc, nom;
		loc = noc = nom = -1;
		Map<String, Integer> metrics = new HashMap<String, Integer>();

		String sourceCodeString = sfr.readFileIntoString();
		loc = locm.calculateWithRegex(sourceCodeString);
		noc = nocm.calculateWithRegex(sourceCodeString);
		nom = nomm.calculateWithRegex(sourceCodeString);

		metrics.put("LOC", loc);
		metrics.put("NOC", noc);
		metrics.put("NOM", nom);
		return metrics;
	}

}