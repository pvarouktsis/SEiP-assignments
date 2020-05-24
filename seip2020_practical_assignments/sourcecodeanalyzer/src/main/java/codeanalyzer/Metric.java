package codeanalyzer;

import java.util.List;

interface Metric {
  
  public int calculateWithRegex(String sourceCodeString);
  public int calculateWithStrcomp(List<String> sourceCodeList);
}
