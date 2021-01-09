package codeanalyzer.analyzers;

import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.readers.*;
import codeanalyzer.metrics.*;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc = number of classes as
 * a StringComparisonAnalyzer. This means that reads the given file 
 * as a List.
 * @author agkortzis
 * @author pvarouktsis
 * 
 */
public class StringComparisonAnalyzer implements Analyzer {
	/**
	 * Calculates the source code metrics (loc, noc, nom).
	 * @param sourceFilepath, the path of the input file
     * @param sourceFileLocation, web or local
	 * @return a Map that contains the name and the value of
	 * each metric analyzed
	 * @throws IOException
	 */
	@Override
	public Map<String, Integer> calculateMetrics(String sourceFilepath, String sourceFileLocation) throws IOException {
		SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
		SourceFileReader sfr = sfrf.initializeSourceFileReader(sourceFileLocation);
		Metric locm = new LOCMetric();
		Metric nocm = new NOCMetric();
		Metric nomm = new NOMMetric();
		int loc, noc, nom;
		loc = noc = nom = -1;
		Map<String, Integer> metrics = new HashMap<String, Integer>();

		List<String> sourceCodeList = sfr.readFileIntoList(sourceFilepath);
		loc = locm.calculateWithStrcomp(sourceCodeList);
		noc = nocm.calculateWithStrcomp(sourceCodeList);
		nom = nomm.calculateWithStrcomp(sourceCodeList);	

		metrics.put("LOC", loc);
		metrics.put("NOC", noc);
		metrics.put("NOM", nom);
		return metrics;
	}

}
