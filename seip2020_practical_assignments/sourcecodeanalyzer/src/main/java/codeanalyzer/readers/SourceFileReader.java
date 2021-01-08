package codeanalyzer.readers;

import java.io.IOException;
import java.util.List;

/**
 * An interface to implement different type of
 * SourceFileReader.
 * @author agkortzis
 * @author pvarouktsis
 */
public interface SourceFileReader {
	public String readFileIntoString() throws IOException;
	public List<String> readFileIntoList() throws IOException;

}
