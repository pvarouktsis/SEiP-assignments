package gradesHistogram;

import org.jfree.chart.*;
import org.jfree.data.statistics.*;
import org.jfree.data.xy.*;
import org.jfree.chart.plot.*;
import java.util.ArrayList;

public class JFreeChartXYLineChart {

    public static void generateChart(ArrayList<Integer> grades) {
        //from ArrayList<Integer> to double[]
        double[] gradesArray = new double[grades.size()];
        for(int i = 0; i < grades.size(); i++) {
            gradesArray[i] = grades.get(i);
        }

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

    public static void main(String[] args ) {
        String fileName = args[0];
        ArrayList<Integer> grades = new ArrayList<Integer>();
        
        HistogramGenerator hg = new HistogramGenerator();
        grades = hg.readGradesFromFile(fileName);

        /**
        grades.add(3);
        grades.add(4);
        grades.add(5);
        grades.add(7);
        grades.add(0);
        grades.add(9);
        grades.add(6);
        grades.add(2);
        grades.add(0);
        grades.add(0);
        grades.add(2);
        grades.add(8);
        grades.add(0);
        grades.add(0);
        grades.add(4);
        generateChart(grades);
        **/
    }
}
