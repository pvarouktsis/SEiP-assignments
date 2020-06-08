package codeanalyzer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calculates the number of classes (NOC) in
 * the given source code file using two methods,
 * regex and strcomp.
 * @author pvaroutksis
 * 
 */
public class NOCMetric implements Metric {
  /**
   * Calculates number of classes using regular expressions.
   * @param sourceCodeString, the input file as a String
   * @return noc, number of classes
   */
  public int calculateWithRegex(String sourceCodeString) {
    Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
    Matcher classSignatures = pattern.matcher(sourceCodeString);
    int noc = 0;
    while (classSignatures.find()) {
      noc++;
    }
    return noc;
  }

  /**
   * Calculates number of classes using string comparison.
   * @param sourceCodeList, the input file as a List
   * @return noc, number of classes
   */
  public int calculateWithStrcomp(List<String> sourceCodeList) {
    int noc = 0;
    for (String line : sourceCodeList) {
      line = line.strip(); // remove leading and trailing white spaces
      if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
        noc++;
      }
    }
    return noc;
  }

}
