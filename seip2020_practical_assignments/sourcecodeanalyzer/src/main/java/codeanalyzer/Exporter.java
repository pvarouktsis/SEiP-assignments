package codeanalyzer;

import java.util.Map;

interface Exporter {
  public void write(Map<String, Integer> metrics, String filepath);

}
