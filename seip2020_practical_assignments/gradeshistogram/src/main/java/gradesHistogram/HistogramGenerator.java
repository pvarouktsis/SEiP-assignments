package gradesHistogram;

import java.io.*;
import java.util.ArrayList;

public class HistogramGenerator {

    public HistogramGenerator() {}

    public ArrayList<Integer> readGradesFromFile() {
        ArrayList<Integer> grades = new ArrayList<Integer>();

        File file = new File("src/main/resources/grades.txt");
        System.out.println("File Found: " + file.exists());

        return grades;



    }

}
