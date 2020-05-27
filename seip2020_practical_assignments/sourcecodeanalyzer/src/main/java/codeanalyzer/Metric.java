package codeanalyzer;

import java.util.List;

public interface Metric {
  public int calculateWithRegex(String sourceCodeString);
  public int calculateWithStrcomp(List<String> sourceCodeList);

}
