package ifmo.math.equations.nonlinear;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMethod {
    private static final int MAX_ITERATIONS = 100000;
    private final List<Double> approximationHistory = new ArrayList<>();
    private final double EPS = 0.0000001;

    abstract protected double calc(double x0);

    public double solve(double x0) {
        double err = Double.MAX_VALUE;
        double x = x0;
        double iterations = 0;
        while (err > EPS && iterations++ < MAX_ITERATIONS) {
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