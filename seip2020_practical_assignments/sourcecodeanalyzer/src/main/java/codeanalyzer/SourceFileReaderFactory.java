package codeanalyzer;

public class SourceFileReaderFactory {
  
  private String type;

  public SourceFileReaderFactory(String type) {
    this.type = type;
  }

  public SourceFileReader initializeSourceFileReader() {
    SourceFileReader sfr = null;
    if(type.equals("local")) {
      sfr = new LocalFileReader();
    } else if(type.equals("web")) {
      sfr = new WebFileReader();
    }
    return sfr;
  }
}