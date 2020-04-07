package ifmo.math.integral;


import ifmo.misc.Answer;

import java.util.function.Function;

public abstract class IntegralMethod {
    protected double precision;
    protected Function<Double, Double> function;

    public IntegralMethod(double precision, Function<Double, Double> function) {
        this.precision = precision;
        this.function = function;
    }

    public double getPrecision() {
        return precision;
    }

    public Function<Double, Double> getFunction() {
        return function;
    }

    abstract Answer solve(double a, double b);
}
