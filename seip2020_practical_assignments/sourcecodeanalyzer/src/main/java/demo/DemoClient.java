package demo;

import java.io.IOException;

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

		SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer(
			sourceFilepath, 
			sourceFileLocation, 
			sourceCodeAnalyzerType, 
			outputFilepath, 
			outputFileType
		);
		analyzer.execute();
	}

}
