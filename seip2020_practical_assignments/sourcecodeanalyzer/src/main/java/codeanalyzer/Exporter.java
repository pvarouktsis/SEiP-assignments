package codeanalyzer;

import java.util.Map;

public interface Exporter {
  public void write(Map<String, Integer> metrics);

}
