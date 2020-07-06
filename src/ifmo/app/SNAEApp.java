package ifmo.app;

import ifmo.interact.Interviewer;
import ifmo.math.equations.nonlinear.AbstractMethod;
import ifmo.math.equations.nonlinear.FixedPointIteration;
import ifmo.math.equations.nonlinear.NewtonMethod;
import ifmo.misc.BiFunctionGroup;
import ifmo.misc.FunctionGroup;
import ifmo.plot.XYPlotBuilder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;

import java.util.*;

public class SNAEApp implements App {
    static FunctionGroup func1 = new FunctionGroup(
            x -> Math.exp(2 * x) + 3 * x - 4,
            x -> 2 * Math.exp(2 * x) + 3,
            x -> 4 * Math.exp(2 * x),
            x -> Math.log(4 - 3 * x) / 2
    );
    static FunctionGroup func2 = new FunctionGroup(
            x -> Math.sqrt(2 * x - 1) + x - 5,
            x -> -1 / Math.sqrt(2 * x - 1),
            null,
            x -> -Math.sqrt(2 * x - 1) + 5
    );
    static List<BiFunctionGroup> funcSys1 = new ArrayList<>(List.of(
            new BiFunctionGroup(
                    (x1, x2) -> 0.1 * Math.pow(x1, 2) + x1 + 0.2 * Math.pow(x2, 2) - 0.3,
                    null,
                    null,
                    (x1, x2) -> 0.3 - 0.1 * Math.pow(x1, 2) - 0.2 * Math.pow(x2, 2)
            ),
            new BiFunctionGroup(
                    (x1, x2) -> 0.2 * Math.pow(x1, 2) + x2 - 0.1 * x1 * x2 - 0.7,
                    null,
                    null,
                    (x1, x2) -> 0.7 - 0.2 * Math.pow(x1, 2) + 0.1 * x1 * x2
            )
    ));

    private static List<Double> getListOfZeroes(List<Double> approximationValues) {
        var ar = new Double[approximationValues.size()];
        Arrays.fill(ar, (double) 0);
        return Arrays.asList(ar);
    }

    @Override
    public void start() {
        Interviewer interviewer = new Interviewer(new Scanner(System.in));
        int funcNumber = interviewer.askInteger(
                """
                        Pick:
                        Solve a non-linear equation: 
                        0) e^(2x) + 3x - 4
                        1) sqrt(2x - 1) + x - 5
                        Solve a system of non-linear equations:
                        2) {
                            
                        > 
                        """);

        FunctionGroup func = switch (funcNumber) {
            case 0 -> func1;
            case 1 -> func2;
            default -> throw new NoSuchElementException();
        };

        double initialApproximation = interviewer.askDouble("Choose initial point (x0): ");


        XYChart chart = new XYChart(500, 400);

        chart.setTitle("VichMat Yahooooo");
        chart.setXAxisTitle("X");
        chart.setYAxisTitle("Y");

        XYSeries funcSeries = XYPlotBuilder.getFunctionSeries("function", func.getFunction(), 0, 1, 0.1);
        XYSeries graph = chart.addSeries(funcSeries.getName(), funcSeries.getXData(), funcSeries.getYData());

        AbstractMethod fixedPointMethod = new FixedPointIteration(func.getPhi());

        double fixedPointX = fixedPointMethod.solve(initialApproximation);
        System.out.println(fixedPointX);

        List<Double> fixedPointApproximationHistory = fixedPointMethod.getApproximationHistory();
        List<Double> listOfZeroesForFixedPointPlot = Collections.nCopies(fixedPointApproximationHistory.size(), 0.0);
        XYSeries fixedPointAnswer = chart.addSeries("fixed point", fixedPointApproximationHistory, listOfZeroesForFixedPointPlot);

        AbstractMethod newtonMethod = new NewtonMethod(func.getFunction(), func.getDerivativeOne());

        double newtonX = newtonMethod.solve(initialApproximation);
        System.out.println(newtonX);

        List<Double> newtonApproximationHistory = newtonMethod.getApproximationHistory();
        List<Double> listOfZeroesForNewtonPlot = Collections.nCopies(newtonApproximationHistory.size(), 0.0);
        XYSeries newtonAnswer = chart.addSeries("newton", newtonApproximationHistory, listOfZeroesForNewtonPlot);

        XYPlotBuilder.drawCharts(chart);
    }

    @Override
    public String toString() {
        return "SNAE";
    }
}
