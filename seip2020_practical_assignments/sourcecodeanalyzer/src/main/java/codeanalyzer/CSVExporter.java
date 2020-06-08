package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Exports a CSV file at the specified outputFilepath 
 * to write the results of the metrics.
 * @author pvarouktsis
 * 
 */
public class CSVExporter implements Exporter {
	private String outputFilepath;

	/**
	 * Initializes the outputFilepath.
	 * @param outputFilepath, the path of the output file
	 */
	public CSVExporter(String outputFilepath) {
		this.outputFilepath = outputFilepath;
	}

	/**
	 * Creates the specified CSV file and writes
	 * the results of the metrics, appending each time a comma
	 * to change column. The first row 
	 * contains the names of the metrics and the second
	 * the values of them.
	 * @param metrics, the metrics (loc, nom, noc)
	 */
  public void write(Map<String, Integer> metrics) {
    File outputFile = new File(outputFilepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue() + ",");
		}
		
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
    }
  }

}