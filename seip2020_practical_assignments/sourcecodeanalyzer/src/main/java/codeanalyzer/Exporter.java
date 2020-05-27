package codeanalyzer;

import java.util.Map;

interface Exporter {
  void write(Map<String, Integer> metrics);

}
