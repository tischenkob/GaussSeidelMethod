package ifmo.plot;

import ifmo.math.equations.nonlinear.AbstractMethod;
import ifmo.math.equations.nonlinear.FixedPointIteration;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.internal.chartpart.Chart;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class XYPlotBuilder {
    public static XYChart getXAxisPointsChart(List<Double> xDataList) {
        double[] xData = xDataList.stream().mapToDouble(Double::doubleValue).toArray();
        double[] yData = new double[xData.length];
        Arrays.fill(yData, 0);
        return QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
    }

    public static XYChart getFunctionChart(Function<Double, Double> function, double inPoint, double outPoint, double step) {
        int steps = (int) (1 + (outPoint - inPoint) / step);
        double[] xData = new double[steps];
        double[] yData = new double[steps];
        int i = 0;
        for (double x = inPoint; x <= outPoint; x += step) {
            xData[i] = x;
            yData[i++] = function.apply(x);
        }
        return QuickChart.getChart("Function Chart", "X", "Y", "y(x)", xData, yData);
    }

    public static void drawCharts(Chart... charts) {
        new SwingWrapper(Arrays.asList(charts)).displayChart();
    }

    public static void main(String[] args) {
        // Create Chart
        Function<Double, Double> f = x -> Math.sin(x) - 1;
        XYChart chart0 = getFunctionChart(f, 0, 5, 0.3);
        Function<Double, Double> func = x -> Math.pow(x, 3) + Math.pow(x, 2) - x * 0.25;
        Function<Double, Double> phi = x -> 4 * (Math.pow(x, 3) + Math.pow(x, 2));
        AbstractMethod method = new FixedPointIteration(phi);
        XYChart chart = XYPlotBuilder.getFunctionChart(func, 0, 10, 1);
        double x = method.solve(0, 10);
        List<Double> roots = method.getApproximationHistory();
        XYChart rootsChart = XYPlotBuilder.getXAxisPointsChart(roots);
        XYPlotBuilder.drawCharts(chart, rootsChart);
        System.out.println();

    }
}
