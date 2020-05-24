package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored locally or exist on the web.
 * This class deliberately contains code smells and violations of design principles. 
 * @author agkortzis
 *
 */
public class SourceFileReader {
	
	private String type;
	
	public SourceFileReader(String type) {
		this.type = type;
	}
	

	public List<String> readFileIntoList(String filepath) throws IOException {
		SourceFileListReader flr = new SourceFileListReader();
		List<String> file = null;
		if (type.contentEquals("local")) {
			file = flr.readLocalFile(filepath);
		} else if (type.contentEquals("web")) {
			file = flr.readWebFile(filepath);
		}

		return file;
	}
	

	public String readFileIntoString(String filepath) throws IOException {
		SourceFileStringReader fsr = new SourceFileStringReader();
		String file = null;
		if (type.contentEquals("local")) {
			file = fsr.readLocalFile(filepath);
		} else if (type.contentEquals("web")) {
			file = fsr.readLocalFile(filepath);
		}
		
		return file;
	}

}
