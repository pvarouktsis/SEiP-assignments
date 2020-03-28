package gradeshistogram;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import java.util.ArrayList;

/**
 * HistogramGenerator implements an application that takes as input,
 * from Java CLI Arguments, a path of .txt file containing numbers and
 * generates its Frequency Histogram.
 * 
 * @author Panagiotis Varouktsis
 * @version 1.0.0
 * @since 2020-03-28
 */

public class HistogramGenerator {

    /**
     * This method receives the argument given by the user from main method,
     * which is the path of a specific file, reads its numbers as Strings, adds
     * them in an ArrayList with type Double and then converts it into a 
     * Double array.
     * 
     * @param filePath The URL of the file.
     * @return double[] Returns the numbers that are going to be processed
     * and presented in the histogram.
     */
    public static double[] readGradesFromFile(String filePath) {               
        ArrayList<Double> grades = new ArrayList<Double>();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String num;
            while((num = br.readLine()) != null) {
                grades.add(Double.parseDouble(num));
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

    /**
     * This is the method that receives the numbers and generates the frequency
     * histogram chart.
     * 
     * @param gradesArray Numbers of the file.
     */
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

    /**
     * This is the main method which takes the file's path from the user and makes
     * use of the other two methods, readGradesFromFile and generateChart, to 
     * finally produce the chart.
     * 
     * @param args Takes the path of .txt file the user wants to produce its
     * histogram.
     */
    public static void main(String[] args) {
        String filePath = args[0];
        double[] grades = readGradesFromFile(filePath);
        generateChart(grades);
    }

}
