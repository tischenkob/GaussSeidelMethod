package ifmo.math.equations.nonlinear;

import java.util.function.Function;

class NewtonMethod extends AbstractMethod {
    private final Function<Double, Double> function;
    private final Function<Double, Double> derivative;

    public NewtonMethod(Function<Double, Double> function, Function<Double, Double> derivative) {
        this.function = function;
        this.derivative = derivative;
    }

    @Override
    protected double calc(double x) {
        return x - function.apply(x) / derivative.apply(x);
    }
}