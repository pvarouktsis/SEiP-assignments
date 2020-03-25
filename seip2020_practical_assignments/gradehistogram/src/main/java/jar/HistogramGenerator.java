import java.io.*;
import java.util.ArrayList;

public class HistogramGenerator {

    public HistogramGenerator() {}

    public ArrayList<Integer> gradesFromFileToArray() throws Exception {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        String path = "./grades.txt";
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String num;
        while((num = br.readLine()) != null) {
            grades.add(Integer.parseInt(num));
        } 
        return grades;
    }









}
