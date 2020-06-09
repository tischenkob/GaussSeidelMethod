package ifmo.math.integral;

import ifmo.misc.Answer;

import java.util.function.Function;

public class TrapezoidMethod extends IntegralMethod {

    public TrapezoidMethod(double precision, Function<Double, Double> function) {
        super(precision, function);
    }


    @Override
    public Answer<Double> solve(double a, double b) throws InterruptedException {
        int partitionAmount = 1;
        double error = Double.MAX_VALUE;
        Answer<Double> answer = calc(a, b, partitionAmount);
        int multiplier = 1;
        boolean shouldIterate = true;
        while (shouldIterate) {
            partitionAmount = (int) (partitionAmount * Math.pow(2, multiplier++));
            Answer<Double> newAnswer = calc(a, b, partitionAmount);
            error = (1.0 / 3.0) * (newAnswer.getSolution() - answer.getSolution()); // Runge
            answer = newAnswer;
            shouldIterate = Math.abs(error) > Math.abs(precision);
        }
        answer.setError(Math.abs(error));
        answer.setPartitionAmount(partitionAmount);
        return answer;
    }

    private Answer<Double> calc(double a, double b, double partitionAmount) throws InterruptedException {
        Answer<Double> answer = new Answer<>();
        double step = (b - a) / partitionAmount;
        double sum = function.apply(a) / 2;
        for (double x = a + step; x <= b - step; x += step) {
            Double value = function.apply(x);
            if (value.isInfinite() || value.isNaN()) throw new InterruptedException();
            sum += value;
        }
        sum += function.apply(b) / 2;
        answer.setSolution(sum * step);
        return answer;
    }
}







