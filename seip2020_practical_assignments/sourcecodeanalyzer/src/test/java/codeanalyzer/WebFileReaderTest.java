package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebFileReaderTest {
  private WebFileReader wfr = null;
	private static List<String> expectedList;
	private static String expectedString;
  private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
  private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";

  @BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}

  @Test
	public void testReadFileIntoListWeb() throws IOException {
    //read a file stored in the web into a List    
		wfr = new WebFileReader(TEST_CLASS_WEB);
		List<String> actualList = wfr.readFileIntoList();
		
		String[] expected = expectedList.stream().toArray(String[]::new);
		String[] actual = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testReadFileIntoStringWeb() throws IOException {
		//read a file stored in the web into a String
    wfr = new WebFileReader(TEST_CLASS_WEB);
    String actualString = wfr.readFileIntoString();
    
    String expected = expectedString;
    String actual = actualString;
				
		assertEquals(expected, actual);
	}
  
}