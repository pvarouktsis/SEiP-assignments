package codeanalyzer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NOCMetric implements Metric {

  public int calculateWithRegex(String sourceCodeString) {
    Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
    Matcher classSignatures = pattern.matcher(sourceCodeString);
    int noc = 0;
    while (classSignatures.find()) {
      noc++;
    }
    return noc;
  }

  public int calculateWithStrcomp(List<String> sourceCodeList) {
    int noc = 0;
    for (String line : sourceCodeList) {
      line = line.strip(); //remove leading and trailing white spaces
      if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
        noc++;
      }
    }
    return noc;
  }
}
