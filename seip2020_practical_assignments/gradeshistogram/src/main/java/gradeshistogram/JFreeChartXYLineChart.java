package gradeshistogram;

import org.jfree.chart.*;
import org.jfree.data.statistics.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.util.ArrayList;

public class JFreeChartXYLineChart {

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
        //String fileName = args[0];
        HistogramGenerator hg = new HistogramGenerator();
        //double[] grades = hg.readGradesFromFile(fileName);
        double[] grades = {3, 4, 5, 7, 0, 9, 6, 2, 0, 0, 2, 8, 0, 0, 4};
        generateChart(grades);
    }
}
