import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        HistogramGenerator hg = new HistogramGenerator();
        
        grades = hg.gradesFromFileToArray();    
        
        System.out.println(grades);

    }

}

