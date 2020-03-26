import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class HistogramGenerator {

    public HistogramGenerator() {}

    public ArrayList<Integer> gradesFromFileToArray() throws Exception {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        
        /** 
        String fileName = "grades.txt";
        ClassLoader cl = getClass().getClassLoader();
        URL resource = cl.getResource(fileName);
        File file = new File(resource.getFile());
        System.out.println("File Found: " + file.exists());
        **/

        File file = new File(this.getClass().getClassLoader().getResource("grades.txt").getFile());
        System.out.println("4 File Found: " + file.exists());


        /**
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String num;
        while((num = br.readLine()) != null) {
            grades.add(Integer.parseInt(num));
        }
        **/        
        return grades;
    }









}
