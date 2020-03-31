package gradeshistogram;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;
import java.util.Collections;
import java.util.ArrayList;

/**
 * HistogramGenerator implements an application that takes as argument the path 
 * of .txt file containing integer numbers and generates its frequency histogram.
 * 
 * @author Panagiotis Varouktsis
 * @version 1.0.0
 * @since 2020-03-28
 */

public class HistogramGenerator {

    /**
     * This method receives the path given by the user,
     * reads its numbers as strings, adds them in an arrayList type integer 
     * and finally finds the frequency of each grade in an array with the size 
     * of the maximum grade.
     * 
     * @param filePath The URL of the file.
     * @return int[] Returns the frequency of each grade.
     */
    public static int[] readGradesFromFile(String filePath) {               
        ArrayList<Integer> grades = new ArrayList<Integer>();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String num;
            while((num = br.readLine()) != null) {
                grades.add(Integer.parseInt(num));
            } 
            br.close();
        } catch (Exception e) { //if an exception occur, terminate and print exception message
            System.out.println("\n\n"
                + "ERROR! Unexpectedly terminated!\nException: "
                + e.getMessage()
                + "\n\n");
            System.exit(0);
        }

        //initialize size of int array finding the maximum grade and find each grade frequency 
        int[] frequencies = new int[Collections.max(grades) + 1];
        for(int i = 0; i < grades.size(); i++) {
            frequencies[grades.get(i)]++;
        }
        return frequencies;
    }

    /**
     * This method receives the numbers and generates the grades' frequency
     * histogram chart using JFree.
     * 
     * @param gradesArray Numbers of the file.
     */
    public static void generateChart(int[] gradesArray) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries("frequencies");
        
        for (int i = 0; i < gradesArray.length; i++) {
            data.add(i, gradesArray[i]);
        }
        dataset.addSeries(data);

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
        ChartFrame frame = new ChartFrame("Grades' Histogram", chart);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * The main method takes the argument(filepath) from the user and makes
     * use of readGradesFromFile and generateChart, to 
     * produce the final histogram chart.
     * 
     * @param args Takes the path of .txt file that the user wants to produce its
     * histogram.
     */
    public static void main(String[] args) {
        String filePath = args[0];
        int[] frequencies = readGradesFromFile(filePath);
        generateChart(frequencies);
    }

}
