package codeanalyzer;

public class SourceFileReaderFactory {
  public SourceFileReader initializeSourceFileReader(String sourceFilepath, String sourceFileLocation) {
    SourceFileReader sfr = null;
    if(sourceFileLocation.equals("local")) {
      sfr = new LocalFileReader(sourceFilepath);
    } else if(sourceFileLocation.equals("web")) {
      sfr = new WebFileReader(sourceFilepath);
    } else {
      throw new IllegalArgumentException("Unknown type: " + sourceFileLocation);
    }
    return sfr;
  }

}
