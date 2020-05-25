package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.*;

public class DemoClient {
	public static void main(String[] args) throws IOException {
		String sourceFilepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilepath = "output_metrics";
		String outputFileType = "csv";
		
		if(args.length == 5) {
			sourceFilepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilepath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

		// main code
		Map<String, Integer> metrics = new HashMap<String, Integer>();
		SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer(sourceFilepath, sourceFileLocation, sourceCodeAnalyzerType);
		MetricsExporter exporter = new MetricsExporter(outputFilepath, outputFileType, metrics);
		metrics = analyzer.calculateMetrics();
		exporter.exportMetrics();
	}

}
