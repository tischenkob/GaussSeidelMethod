package ifmo.math.equations.nonlinear;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMethod {
    private static final int MAX_ITERATIONS = 100000;
    private final List<Double> approximationHistory = new ArrayList<>();
    private double eps;

    abstract protected double calc(double x0);

    public double solve(double a, double b) {
        double x0 = (a - b) / 2;
        double err = Double.MAX_VALUE;
        double x = x0;
        double iterations = 0;
        while (err > eps && iterations++ < MAX_ITERATIONS) {
            x = calc(x0);
            approximationHistory.add(x);
            err = Math.abs(x - x0);
            x0 = x;
        }
        return x;
    }

    public List<Double> getApproximationHistory() {
        return approximationHistory;
    }
}