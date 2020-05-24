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
public class SourceCodeAnalyzer {
	
	private SourceFileReader fileReader;
	
	public SourceCodeAnalyzer(String fileReaderType) {
		this.fileReader = new SourceFileReader(fileReaderType);
	}

	public Map<String, Integer> calculateMetrics(String filepath, String analyzerType) throws IOException{
		Metric locm = new LOCMetric();
		Metric nocm = new NOCMetric();
		Metric nomm = new NOMMetric();
		int loc, noc, nom;
		loc = noc = nom = -1;
		Map<String, Integer> metrics = new HashMap<>();

		if(analyzerType.equals("regex")) {
			String sourceCodeString = fileReader.readFileIntoString(filepath);
			loc = locm.calculateWithRegex(sourceCodeString);
			noc = nocm.calculateWithRegex(sourceCodeString);
			nom = nomm.calculateWithRegex(sourceCodeString);
		} else if(analyzerType.equals("strcomp")) {
			List<String> sourceCodeString = fileReader.readFileIntoList(filepath);
			loc = locm.calculateWithStrcomp(sourceCodeString);
			noc = nocm.calculateWithStrcomp(sourceCodeString);
			nom = nomm.calculateWithStrcomp(sourceCodeString);	
		}

		metrics.put("LOC", loc);
		metrics.put("NOC", noc);
		metrics.put("NOM", nom);
		return metrics;
	}
}
