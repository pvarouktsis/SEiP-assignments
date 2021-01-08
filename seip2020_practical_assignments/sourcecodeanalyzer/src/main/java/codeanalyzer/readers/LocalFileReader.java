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
  private String sourceFilepath;

  /**
   * Initializes the instance variable sourceFilepath.
   * @param sourceFilepath, the path of the input file
   */
  public LocalFileReader(String sourceFilepath) {
    this.sourceFilepath = sourceFilepath;
  }

  /**
   * Reads a local file and returns its content 
   * in a single String.
   * @return a String that contains the contents of the file
   * @throws IOException
   */
  public String readFileIntoString() throws IOException {
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
   * @return a List that contains the contents of the file 
   * @throws IOException
   */
  public List<String> readFileIntoList() throws IOException {
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
