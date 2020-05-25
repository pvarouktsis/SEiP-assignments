package codeanalyzer;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * This class deliberately contains code smells and violations of design principles. 
 * @author agkortzis
 *
 */
public class ExporterFactory {
  String type;

  public ExporterFactory(String type) {
    this.type = type;
  }
  
  public Exporter initializeExporter() {
    Exporter ex = null;
    if(type.equals("csv")) {
      ex = new CSVExporter();
    } else if (type.equals("json")) {
      ex = new JSONExporter();
    } else {
      throw new IllegalArgumentException("Uknown type: " + type);
    }
    return ex;
  }
}