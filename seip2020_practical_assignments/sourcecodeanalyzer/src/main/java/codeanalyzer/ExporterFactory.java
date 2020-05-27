package codeanalyzer;

/**
 * A factory class to initialize an Export object
 * based on the outputFileType.
 * 
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * This class deliberately contains code smells and violations of design principles. 
 * @author agkortzis
 * @author pvarouktsis
 * 
 */
public class ExporterFactory {
  /**
   * Initializes the appropriate Export object
   * based on the outputFileType.
   * @param outputFilepath, the path of the output file
   * @param outputFileType, regex or strcomp
   */
  public Exporter initializeExporter(String outputFilepath, String outputFileType) {
    Exporter exporter;
    if(outputFileType.equals("csv")) {
      exporter = new CSVExporter(outputFilepath);
    } else if (outputFileType.equals("json")) {
      exporter = new JSONExporter(outputFilepath);
    } else {
      throw new IllegalArgumentException("Uknown type: " + outputFileType);
    }
    return exporter;
  }

}
