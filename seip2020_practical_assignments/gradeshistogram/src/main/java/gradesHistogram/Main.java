package gradesHistogram;

import java.util.ArrayList;

public class Main {
    public static void main( String[] args ) {
        ArrayList<Integer> grades = new ArrayList<Integer>();
        HistogramGenerator hg = new HistogramGenerator();
        grades = hg.readGradesFromFile();
    }
}
