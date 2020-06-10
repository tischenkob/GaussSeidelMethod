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
                        0) sin(x)
                        1) 2x + 5
                        2) x^3 + x^2 - x / 4
                        3) x^5 - x^3
                        4) cos(x) * 2 + x / 2
                        5) 1 / x
                        6) sqrt(2x - 1)
                        > 
                        """);
        Function<Double, Double> func = switch (funcNumber) {
            case 0 -> x -> Math.sin((Double) x);
            case 1 -> x -> 2 * x + 5;
            case 2 -> x -> Math.pow(x, 3) + Math.pow(x, 2) - x * 0.25;
            case 3 -> x -> Math.pow(x, 5) - Math.pow(x, 3);
            case 4 -> x -> Math.cos(x) * 2 + x / 2;
            case 5 -> x -> 1 / x;
            case 6 -> x -> Math.sqrt(2 * x - 1);
            case 7 -> x -> Math.sin(1 / x);
            default -> throw new NoSuchElementException();
        };
        double precision = interviewer.askDouble("Precision: ");
        double a = interviewer.askDouble("Choose [a: ");
        double b = interviewer.askDouble("Choose b]: ");
    }

    @Override
    public String toString() {
        return "SNAE";
    }
}
