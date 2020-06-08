package codeanalyzer;

import java.util.Map;

/**
 * An interface to implement different 
 * types of exporters.
 * @author pvarouktsis
 * 
 */
public interface Exporter {
  public void write(Map<String, Integer> metrics);

}
