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
   * @param sourceCodeAnalyzerType, regex or strcomp
   * @return analyzer, the appropriate type of analyzer
   */
  public Analyzer initializeAnalyzer(String sourceCodeAnalyzerType) {
    Analyzer analyzer;
    if(sourceCodeAnalyzerType.equals("regex")) {
      analyzer = new StringComparisonAnalyzer();
    } else if (sourceCodeAnalyzerType.equals("strcomp")) {
      analyzer = new RegexAnalyzer();
    } else {
      throw new IllegalArgumentException("Uknown type: " + sourceCodeAnalyzerType);
    }
    return analyzer;
  }

}
