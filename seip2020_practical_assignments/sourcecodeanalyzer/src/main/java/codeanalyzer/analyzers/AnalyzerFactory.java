package codeanalyzer.analyzers;

/**
 * A factory class to initialize an Analyzer
 * based on the sourceCodeAnalyzerType.
 * @author agkortzis
 * @author pvarouktsis
 * 
 */
public class AnalyzerFactory {
  /**
   * Initializes the appropriate Analyzer object
   * based on the sourceCodeAnalyzerType and returns it.
   * @param sourceFilepath, the path of the input file
   * @param sourceFileLocation, web or local
   * @param sourceCodeAnalyzerType, regex or strcomp
   * @param outputFilepath, the path of the output file
   * @param outputFileType, the format of the output file
   * @return analyzer, the appropriate type of analyzer
   */
  public Analyzer initializeAnalyzer(String sourceFilepath, String sourceFileLocation, String sourceCodeAnalyzerType, String outputFilepath, String outputFileType) {
    Analyzer analyzer;
    if(sourceCodeAnalyzerType.equals("regex")) {
      analyzer = new StringComparisonAnalyzer(sourceFilepath, sourceFileLocation, outputFilepath, outputFileType);
    } else if (sourceCodeAnalyzerType.equals("strcomp")) {
      analyzer = new RegexAnalyzer(sourceFilepath, sourceFileLocation, outputFilepath, outputFileType);
    } else {
      throw new IllegalArgumentException("Uknown type: " + sourceCodeAnalyzerType);
    }
    return analyzer;
  }

}