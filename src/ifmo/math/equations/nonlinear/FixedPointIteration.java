package ifmo.math.equations.nonlinear;

import java.util.function.Function;

class FixedPointIteration extends AbstractMethod {
    private final Function<Double, Double> function;

    FixedPointIteration(Function<Double, Double> function) {
        this.function = function;
    }

    @Override
    protected double calc(double x) {
        return function.apply(x);
    }
}