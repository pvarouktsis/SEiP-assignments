package codeanalyzer;

import java.util.Map;


public class MetricsExporter {
  private ExporterFactory exporterFactory;
  private Exporter exporter;
  private String outputFilepath;
  //private String outputFileType;
  private Map<String, Integer> metrics;

  public MetricsExporter(String outputFilepath, String outputFileType, Map<String, Integer> metrics) {
    exporterFactory = new ExporterFactory(outputFileType);
    exporter = exporterFactory.initializeExporter();
    this.outputFilepath = outputFilepath;
    //this.outputFileType = outputFileType;
    this.metrics = metrics;
  }
  
  public void exportMetrics() {
		exporter.write(metrics, outputFilepath);
	}
  
}
