package codeanalyzer;

//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Map;

/**
 * Exports a JSON file at the specified outputFilepath 
 * that contains the metrics.
 * @author pvarouktsis
 * 
 */
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
