package codeanalyzer.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given local file
 * and stores them either in a String or a List.
 * @author pvarouktsis
 * 
 */
public class LocalFileReader implements SourceFileReader {
  /**
   * Reads a local file and returns its content 
   * in a single String.
   * @param sourceFilepath, the path of the input file
   * @return a String that contains the contents of the file
   * @throws IOException
   */
  public String readFileIntoString(String sourceFilepath) throws IOException {
    StringBuilder sb = new StringBuilder();
    File file = new File(sourceFilepath);
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line = null;
    while ((line = reader.readLine()) != null) {
      sb.append(line + "\n");
    }
    reader.close();
    return sb.toString();
  }

  /**
   * Reads a local file and returns its content
   * in a List.
   * @param sourceFilepath, the path of the input file
   * @return a List that contains the contents of the file 
   * @throws IOException
   */
  public List<String> readFileIntoList(String sourceFilepath) throws IOException {
    List<String> lines = new ArrayList<>();
    File file = new File(sourceFilepath);
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line = null;
    while ((line = reader.readLine()) != null) {
      lines.add(line);
    }
    reader.close();
    return lines;
  }

}
