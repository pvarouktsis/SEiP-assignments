package codeanalyzer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LOCMetric implements Metric {

  public int calculateWithRegex(String sourceCodeString) {
    Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
    Matcher nonCodeLinesMatcher = pattern.matcher(sourceCodeString);
    int nonCodeLinesCounter = 0;
    while (nonCodeLinesMatcher.find()) {
      nonCodeLinesCounter++;
    }
    int sourceFileLength = sourceCodeString.split("\n").length;
    int loc = sourceFileLength - nonCodeLinesCounter;
    return loc;
  }

  public int calculateWithStrcomp(List<String> sourceCodeList) {
    int nonCodeLinesCounter = 0;
    for (String line : sourceCodeList) {
      line = line.stripLeading().stripTrailing(); // clear all leading and trailing white spaces
      if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}")
          || line.equals(""))
        nonCodeLinesCounter++;
    }
    int loc = sourceCodeList.size() - nonCodeLinesCounter;
    return loc;
  }

}