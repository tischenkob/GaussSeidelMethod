package ifmo.misc;

import java.util.function.BiFunction;

public class BiFunctionGroup {
    private BiFunction<Double, Double, Double> function;
    private BiFunction<Double, Double, Double> derivativeOne;
    private BiFunction<Double, Double, Double> derivativeTwo;
    private BiFunction<Double, Double, Double> phi;

    public BiFunctionGroup(
            BiFunction<Double, Double, Double> function,
            BiFunction<Double, Double, Double> derivativeOne,
            BiFunction<Double, Double, Double> derivativeTwo, 
            BiFunction<Double, Double, Double> phi
    ) {
        this.function = function;
        this.derivativeTwo = derivativeTwo;
        this.phi = phi;
        this.derivativeOne = derivativeOne;
    }

    public BiFunction<Double, Double, Double> getFunction() {
        return function;
    }

    public BiFunction<Double, Double, Double> getDerivativeOne() {
        return derivativeOne;
    }

    public BiFunction<Double, Double, Double> getDerivativeTwo() {
        return derivativeTwo;
    }

    public BiFunction<Double, Double, Double> getPhi() {
        return phi;
    }

}