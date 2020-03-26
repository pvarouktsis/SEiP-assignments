package gradesHistogram;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class HistogramGenerator {

    public HistogramGenerator() {}

    public ArrayList<Integer> readGradesFromFile(String fileName) {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        ClassLoader cl = getClass().getClassLoader();
        URL resource = cl.getResource(fileName);
        File file = new File(resource.getFile());
        
        System.out.println("File Found: " + file.exists());

        return grades;



    }

}
