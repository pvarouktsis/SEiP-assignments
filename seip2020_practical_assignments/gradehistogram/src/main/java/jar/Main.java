//import org.jfree.chart.*;
import java.util.ArrayList;

public class Main {
    
    /***
    public void generateChart(ArrayList<Integer> grades) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries data = new XYSeries("random values");
        
        for (int i = 0; i < grades.length; i++) {
            data.add(i, grades.get(i));
        }
        
        dataset.addSeries(data);
        boolean legend = false;
        boolean tooltips = false;
        boolean urls = false;
        
        JFreeChart chart = ChartFactory.createXYLineChart("Chart title", 
            "x_axis_title", "y_axis_title", dataset, PlotOrientation.VERTICAL, legend, tooltips, urls);
        
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        frame.setVisible(true);
    } 
    ***/

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> grades = new ArrayList<Integer>();

        HistogramGenerator hg = new HistogramGenerator(); 
        grades = hg.gradesFromFileToArray();            
        System.out.println(grades);
        
        //System.out.println("Hello, World!");

        //XYLineChart chart = new XYLineChart();
        //chart.generateChart(grades);

        
    }

}

