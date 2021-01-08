package codeanalyzer.metrics;

import java.util.List;

/**
 * An interface to implement different
 * kind of Metrics.
 * @author pvarouktsis
 * 
 */
public interface Metric {
  public int calculateWithRegex(String sourceCodeString);
  public int calculateWithStrcomp(List<String> sourceCodeList);

}
