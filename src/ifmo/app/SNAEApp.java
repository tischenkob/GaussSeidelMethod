package ifmo.app;

import ifmo.interact.Interviewer;
import ifmo.math.equations.nonlinear.AbstractMethod;
import ifmo.math.equations.nonlinear.FixedPointIteration;
import ifmo.math.equations.nonlinear.NewtonMethod;
import ifmo.misc.BiFunctionGroup;
import ifmo.misc.FunctionGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

public class SNAEApp implements App {
    static FunctionGroup func1 = new FunctionGroup(
            x -> Math.exp(2 * x) + 3 * x - 4,
            x -> 2 * Math.exp(2 * x) + 3,
            x -> 4 * Math.exp(2 * x),
            x -> Math.log(4 - 3 * x) / 2
    );

    static List<BiFunctionGroup> funcSys1 = new ArrayList<>(List.of(
            new BiFunctionGroup(
                    (x1, x2) -> x1 + x2,
                    null, null,
                    null
            ),
            new BiFunctionGroup(
                    (x1, x2) -> x1 - x2,
                    null,
                    null,
                    null)
    ));
    public static void main(final String[] args) {
        AbstractMethod method = new FixedPointIteration(func1.getPhi());
        double x = method.solve(0.475);
        System.out.println(x);
        method = new NewtonMethod(func1.getFunction(), func1.getDerivativeOne());
        x = method.solve(0.475);
        System.out.println(x);
    }
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
