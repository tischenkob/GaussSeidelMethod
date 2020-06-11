package test.math;

import ifmo.math.equations.nonlinear.AbstractMethod;
import ifmo.math.equations.nonlinear.FixedPointIteration;
import ifmo.plot.XYPlotBuilder;
import org.junit.Test;
import org.knowm.xchart.XYChart;

import java.util.function.Function;

public class FixedPointTest {
    public static void main(String[] args) {

    }

    @Test
    public void equationSolvingTest() {
        Function<Double, Double> func = x -> Math.pow(x, 3) + Math.pow(x, 2) - x * 0.25;
        Function<Double, Double> phi = x -> 4 * (Math.pow(x, 3) + Math.pow(x, 2));
        AbstractMethod method = new FixedPointIteration(phi);
        XYChart chart = XYPlotBuilder.getFunctionChart(func, 0, 10, 1);
        XYPlotBuilder.drawCharts(chart);
    }
}
