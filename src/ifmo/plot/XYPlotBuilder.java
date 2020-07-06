package ifmo.plot;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.internal.chartpart.Chart;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class XYPlotBuilder {
//    public static XYSeries getXAxisPointsSeries(List<Double> xDataList) {
//        double[] xData = xDataList.stream().mapToDouble(Double::doubleValue).toArray();
//        double[] yData = new double[xData.length];
//        Arrays.fill(yData, 0);
//        return new XYSeries("Sample Chart", "X", "Y", "y(x)", xData, yData);
//    }

    public static XYSeries getFunctionSeries(String chartTitle, Function<Double, Double> function, double inPoint, double outPoint, double step) {
        int steps = (int) (1 + (outPoint - inPoint) / step);
        double[] xData = new double[steps];
        double[] yData = new double[steps];
        int i = 0;
        for (double x = inPoint; x <= outPoint; x += step) {
            xData[i] = x;
            yData[i++] = function.apply(x);
        }
        final XYSeries xySeries = new XYSeries(chartTitle, xData, yData, null, XYSeries.DataType.Number);

        return xySeries;
    }

    public static Map<Double, Double> getFunctionPlotPoints(Function<Double, Double> function, double inPoint, double outPoint, double step) {
        Map<Double, Double> map = new LinkedHashMap<>();
        int steps = (int) (1 + (outPoint - inPoint) / step);
        double[] xData = new double[steps];
        double[] yData = new double[steps];
        int i = 0;
        for (double x = inPoint; x <= outPoint; x += step) {
            xData[i] = x;
            yData[i++] = function.apply(x);
            map.put(x, function.apply(x));
        }
        return map;
    }

    public static void drawCharts(Chart... charts) {
        new SwingWrapper(Arrays.asList(charts)).displayChart();
    }
}
