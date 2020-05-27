package codeanalyzer;

import java.util.Map;

/**
 * An interface to implement different 
 * type of exporters.
 * @author pvarouktsis
 * 
 */
public interface Exporter {
  public void write(Map<String, Integer> metrics);

}
