package codeanalyzer.readers;

/**
 * A factory class to initialize the
 * appropriate SourceFileReader object 
 * based on the sourceFileLocation.
 * @author pvarouktsis
 *  
 */
public class SourceFileReaderFactory {
  /**
   * Initializes the appropriate SourceFileReader
   * object and returns it.
   * @param sourceFilepath, the path of the input file
   * @param sourceFileLocation, web or local 
   * @return a SourceFileReader object based on the location of the
   * input file (web or url)
   */
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
