package gradeshistogram;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class HistogramGenerator {

    public HistogramGenerator() {}

    public double[] readGradesFromFile(String fileName) throws FileNotFoundException, IOException {               
        ClassLoader cl = getClass().getClassLoader();
        URL rsc = cl.getResource(fileName);
        File file = new File(rsc.getFile());
        //System.out.println("File Found: " + file.getName());
        
        ArrayList<Integer> grades = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String num;
        while((num = br.readLine()) != null) {
            grades.add(Integer.parseInt(num));
        } 
         
        //from ArrayList<Integer> to double[]
        double[] gradesArray = new double[grades.size()];
        for(int i = 0; i < grades.size(); i++) {
            gradesArray[i] = grades.get(i);
        }
        return gradesArray;

    }

}
