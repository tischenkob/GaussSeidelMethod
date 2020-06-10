package ifmo.plot;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.function.Function;

public class XYPlotBuilder {

    public static XYChart getFunctionChart(Function<Double, Double> function, double inPoint, double outPoint, double step) {
        int steps = (int) (1 + (outPoint - inPoint) / step);
        double[] xData = new double[steps];
        double[] yData = new double[steps];
        int i = 0;
        for (double x = inPoint; x <= outPoint; x += step) {
            xData[i] = x;
            yData[i++] = function.apply(x);
        }
        return QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
    }

    public static void main(String[] args) {
        // Create Chart
        Function<Double, Double> f = x -> Math.sin(x) - 1;
        XYChart chart = getFunctionChart(f, 0, 5, 0.3);

        // Show it
        new SwingWrapper(chart).displayChart();
    }
}
