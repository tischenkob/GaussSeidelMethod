package ifmo.misc;

import java.util.function.Function;

public class FunctionGroup {
    private Function<Double, Double> function;
    private Function<Double, Double> derivativeOne;
    private Function<Double, Double> derivativeTwo;
    private Function<Double, Double> phi;

    public FunctionGroup(Function<Double, Double> function, Function<Double, Double> derivativeOne,
            Function<Double, Double> derivativeTwo, Function<Double, Double> phi) {
        this.function = function;
        this.derivativeOne = derivativeOne;
        this.derivativeTwo = derivativeTwo;
        this.phi = phi;
    }

    public Function<Double, Double> getFunction() {
        return function;
    }

    public Function<Double, Double> getDerivativeOne() {
        return derivativeOne;
    }

    public Function<Double, Double> getDerivativeTwo() {
        return derivativeTwo;
    }

    public Function<Double, Double> getPhi() {
        return phi;
    }
}