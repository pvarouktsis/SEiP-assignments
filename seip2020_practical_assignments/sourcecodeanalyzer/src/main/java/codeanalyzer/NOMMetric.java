package codeanalyzer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NOMMetric implements Metric {
  public int calculateWithRegex(String sourceCodeString) {
    Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
	  Matcher methodSignatures = pattern.matcher(sourceCodeString);
    int nom = 0;
    while (methodSignatures.find()) {
      nom++;
    }
    return nom;
  }

  public int calculateWithStrcomp(List<String> sourceCodeList) {
    int nom = 0;
    for (String line : sourceCodeList) {
      line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
      if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
          || line.contains("void") || line.contains("int") || line.contains("String"))
        && line.contains("(") && line.contains(")") && line.contains("{") )
        nom++;
    }
    return nom; 
  }

}
