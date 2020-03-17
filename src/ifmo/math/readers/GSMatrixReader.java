package ifmo.math.readers;

import ifmo.math.exceptions.NotDiagonallyDominantException;
import ifmo.math.structures.GSMatrix;
import ifmo.math.structures.Matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GSMatrixReader extends MatrixReader {
    private double epsilon;

    public GSMatrixReader(Scanner in) {
        super(in);
    }

    public GSMatrixReader(Scanner in, boolean makeSilent) {
        super(in, makeSilent);
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public double readEpsilon(Scanner in) {
        double eps = -1;
        while (eps == -1) {
            System.out.print("Precision: ");
            try {
                eps = in.nextDouble();
                if (eps <= 0) throw new IllegalArgumentException();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input type. Please enter a correct value.");
                in = new Scanner(System.in);
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect value. Please enter a correct value.");
                eps = -1;
                in = new Scanner(System.in);
            }
        }
        if (isNotSilent) System.out.println(eps);
        return eps;
    }

    public GSMatrix createGSMatrix() throws NotDiagonallyDominantException {
        return new GSMatrix(createMatrix());
    }

    public GSMatrix createGSMatrix(Scanner in) throws NotDiagonallyDominantException {
        int size = readSize(in);
        return createGSMatrix(size, in);
    }

    public GSMatrix createGSMatrix(int size, Scanner in) throws NotDiagonallyDominantException {
        return new GSMatrix(new Matrix(readMatrix(size, in)));
    }
}
