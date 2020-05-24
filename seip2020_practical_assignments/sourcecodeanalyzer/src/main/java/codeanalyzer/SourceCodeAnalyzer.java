package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
	public int calculateLOC(String filepath, String analyzerType) throws IOException {
		Metric locm = new LOCMetric();
		int loc = -1;
		if(analyzerType.equals("regex")) {
			String sourceCodeString = fileReader.readFileIntoString(filepath);
			loc = locm.calculateWithRegex(sourceCodeString);
		} else if (analyzerType.equals("strcomp")) {
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			loc = locm.calculateWithStrcomp(sourceCodeList);
		}
		
		return loc;
	}
	
	public int calculateNOM(String filepath, String analyzerType) throws IOException {
		Metric nomm = new NOMMetric();
		int nom = -1;
		if(analyzerType.equals("regex")) {
			String sourceCodeString = fileReader.readFileIntoString(filepath);
			nom = nomm.calculateWithRegex(sourceCodeString);
		} else if (analyzerType.equals("strcomp")) {
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			nom = nomm.calculateWithStrcomp(sourceCodeList);
		}

		return nom;
	}
	
	public int calculateNOC(String filepath, String analyzerType) throws IOException {
		Metric nocm = new NOCMetric();
		int noc = -1;
		if(analyzerType.equals("regex")) {
			String sourceCodeString = fileReader.readFileIntoString(filepath);
			noc = nocm.calculateWithRegex(sourceCodeString);
		} else if (analyzerType.equals("strcomp")) {
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			noc = nocm.calculateWithStrcomp(sourceCodeList);
		}
		
		return noc;
	}
}
