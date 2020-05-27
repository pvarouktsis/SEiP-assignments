package codeanalyzer;

// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
import java.util.Map;

public class JSONExporter implements Exporter {
  protected String outputFilepath;

  public JSONExporter(String outputFilepath) {
    this.outputFilepath = outputFilepath;
  }

  public void write(Map<String, Integer> metrics) {
    // TODO
    // Functionality not implemented yet
  }

}
