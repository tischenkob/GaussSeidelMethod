package ifmo.app;

import ifmo.interact.Interviewer;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

public class SNAEApp implements App {
    @Override
    public void start() {
        Interviewer interviewer = new Interviewer(new Scanner(System.in));
        int funcNumber = interviewer.askInteger(
                """
                        Pick a function: 
                        0) x^3 + x^2 - x / 4
                        1) sqrt(2x - 1) + x + 5
                        > 
                        """);
        Function<Double, Double> func = switch (funcNumber) {
            case 0 -> x -> Math.pow(x, 3) + Math.pow(x, 2) - x * 0.25;
            case 1 -> x -> Math.sqrt(2 * x - 1) + x + 5;
            default -> throw new NoSuchElementException();
        };
        double precision = interviewer.askDouble("Precision: ");
        double a = interviewer.askDouble("Choose [a: ");
        double b = interviewer.askDouble("Choose b]: ");
        //AbstractMethod fixedPointMethod = new FixedPointIteration();
        //AbstractMethod newtonMethod = new NewtonMethod();
    }

    @Override
    public String toString() {
        return "SNAE";
    }
}
