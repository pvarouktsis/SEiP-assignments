package gradeshistogram;

import java.io.*;
import org.jfree.chart.*;
import org.jfree.data.statistics.*;
import org.jfree.chart.plot.*;
import java.util.ArrayList;

public class HistogramGenerator {

    public static double[] readGradesFromFile(String filePath) {               
        ArrayList<Integer> grades = new ArrayList<Integer>();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String num;
            while((num = br.readLine()) != null) {
                grades.add(Integer.parseInt(num));
            } 
            br.close();
        } catch (Exception e) {
            System.out.println("There is no such file.");
        }
        //from ArrayList<Integer> to double[]
        final double[] gradesArray = new double[grades.size()];
        for(int i = 0; i < grades.size(); i++) {
            gradesArray[i] = grades.get(i);
        }
        return gradesArray;
    }

    public static void generateChart(double[] gradesArray) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries("grades", gradesArray, 35);

        boolean legend = false;
        boolean tooltips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Students' Grades Histogram",   //title
            "Grades",                       //x_axis
            "Frequency",                    //y_axis
            dataset, 
            PlotOrientation.VERTICAL, 
            legend, 
            tooltips, 
            urls
        );
        ChartFrame frame = new ChartFrame("Histogram", chart);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        String filePath = args[0];
        double[] grades = readGradesFromFile(filePath);
        //double[] grades = {3, 4, 5, 7, 0, 9, 6, 2, 0, 0, 2, 8, 0, 0, 4};
        generateChart(grades);
    }

}
