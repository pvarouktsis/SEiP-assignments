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
 * @author Panagiotis Varouktsis
 * @version 1.0.0
 * @since 2020-03-28
 */

public class HistogramGenerator {

    /**
     * Receives the filepath, given by the user, reads its content as
     * strings, one number per line, and parse them as integers into 
     * an arraylist to finally return them. If any exception occur, the 
     * program terminates with appropriate message.
     * @param filePath the URL(path) of the file
     * @return an arraylist containing all the integers from the file
     */
    public static ArrayList<Integer> readNumbersFromFile(String filePath) {               
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String num;
            while((num = br.readLine()) != null) {
                numbers.add(Integer.parseInt(num));
            } 
            br.close();
        } catch (Exception e) { //if an exception occur, terminate and print exception message
            System.out.println("\nERROR! Unexpectedly terminated!\nException: " + e.getMessage()+ "\n");
            System.exit(0);
        }
        return numbers;
    }

    /**
    * Processes an arraylist of integers and calculates
    * their frequencies in an integer array with size, that 
    * of their maximum integer.
    * @param numbers the arraylist containing the input numbers
    * @return an integer array with their frequencies
    */
    public static int[] calculateFrequencies(ArrayList<Integer> numbers) {
        int[] frequencies = new int[Collections.max(numbers) + 1];
        for(int i = 0; i < numbers.size(); i++) {
            frequencies[numbers.get(i)]++;
        }
        return frequencies;
    }

    /**
     * Receives the frequencies and generates the frequency
     * histogram chart using JFree.
     * @param frequencies the integer array with the frequencies
     */
    public static void generateChart(int[] frequencies) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries("frequencies");
        
        for (int i = 0; i < frequencies.length; i++) {
            data.add(i, frequencies[i]);
        }
        dataset.addSeries(data);

        boolean legend = false;
        boolean tooltips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Histogram",             //title
            "Integers",              //x_axis
            "Frequency",             //y_axis
            dataset, 
            PlotOrientation.VERTICAL, 
            legend, 
            tooltips, 
            urls
        );
        ChartFrame frame = new ChartFrame("numbers' Histogram", chart);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Main receives the argument(filepath) from the user and makes
     * use of readNumbersFromFile, calculateFrequencies and generateChart to 
     * produce the final frequency histogram chart.
     * 
     * @param args the path of .txt file that the user wants to generate its 
     * histogram
     */
    public static void main(String[] args) {
        String filePath = args[0];
        ArrayList<Integer> numbers = readNumbersFromFile(filePath);
        int[] frequencies = calculateFrequencies(numbers);
        generateChart(frequencies);
    }

}
