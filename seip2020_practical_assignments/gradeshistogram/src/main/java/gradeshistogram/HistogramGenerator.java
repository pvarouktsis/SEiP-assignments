package gradeshistogram;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class HistogramGenerator {

    public HistogramGenerator() {}

    public ArrayList<Integer> readGradesFromFile(String url) {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        
        /**
        ClassLoader cl = getClass().getClassLoader();
        URL rsc = cl.getResource(url);
        File file = new File(rsc.getFile());
        */
        File file = new File("./grades.txt");
        System.out.println("File Found: " + file.exists());

        /**
        BufferedReader br = new BufferedReader(new FileReader(file));
        String num;
        while((num = br.readLine()) != null) {
            grades.add(Integer.parseInt(num));
        } 
 
        //TODO read grades from file
        
        //from ArrayList<Integer> to double[]
        
        double[] gradesArray = new double[grades.size()];
        for(int i = 0; i < grades.size(); i++) {
            gradesArray[i] = grades.get(i);
        }
        return gradesArray;
        */
        return grades;

    }

}
