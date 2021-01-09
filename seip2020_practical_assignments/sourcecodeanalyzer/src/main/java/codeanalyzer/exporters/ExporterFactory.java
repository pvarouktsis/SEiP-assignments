package codeanalyzer.exporters;

/**
 * A factory class to initialize an Export object
 * based on the outputFileType.
 * @author agkortzis
 * @author pvarouktsis
 * 
 */
public class ExporterFactory {
  /**
   * Initializes the appropriate Export object
   * based on the outputFileType and returns it.
   * @param outputFileType, regex or strcomp
   * @return exporter, the appropriate type of exporter
   */
  public Exporter initializeExporter(String outputFileType) {
    Exporter exporter;
    if(outputFileType.equals("csv")) {
      exporter = new CSVExporter();
    } else if (outputFileType.equals("json")) {
      exporter = new JSONExporter();
    } else {
      throw new IllegalArgumentException("Uknown type: " + outputFileType);
    }
    return exporter;
  }

}
