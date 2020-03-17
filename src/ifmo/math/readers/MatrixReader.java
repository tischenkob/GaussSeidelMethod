package ifmo.math.readers;

import ifmo.math.structures.Matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixReader {
    protected boolean isNotSilent = false;
    private Scanner in;

    public MatrixReader(Scanner in) {
        this.in = in;
    }

    public MatrixReader(Scanner in, boolean makeSilent) {
        this.in = in;
        this.isNotSilent = !makeSilent;
    }

    public boolean isNotSilent() {
        return isNotSilent;
    }

    public void setNotSilent(boolean notSilent) {
        isNotSilent = notSilent;
    }

    protected int readSize(Scanner in) {
        int size = -1;
        while (size == -1) {
            System.out.print("Size: ");
            try {
                size = in.nextInt();
                if (size < 1) throw new IllegalArgumentException();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input type. Please enter a correct value.");
                in = new Scanner(System.in);
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect value. Please enter a correct value.");
                in = new Scanner(System.in);
                size = -1;
            }
        }
        if (isNotSilent) System.out.println(size);
        return size;
    }

    protected double[][] readMatrix(Scanner in) {
        int size = readSize(in);
        return readMatrix(size, in);
    }

    protected double[][] readMatrix(int size, Scanner in) {
        double[][] matrix = null;
        double[][] auxMatrix = new double[size][size + 1];
        while (matrix == null) {
            System.out.println("Matrix: ");
            try {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size + 1; j++) {
                        auxMatrix[i][j] = in.nextDouble();
                        if (isNotSilent) System.out.print(auxMatrix[i][j] + " ");
                    }
                    if (isNotSilent) System.out.println();
                }
                matrix = auxMatrix;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input type. Please enter a correct value.");
                in = new Scanner(System.in);
            }
        }
        return matrix;
    }

    public Matrix createMatrix() {
        return new Matrix(readMatrix(in));
    }

    public Matrix createMatrix(Scanner in) {
        int size = readSize(in);
        return createMatrix(size, in);
    }

    public Matrix createMatrix(int size, Scanner in) {
        Matrix matrix = new Matrix(size);
        double[][] _matrix = readMatrix(size, in);
        matrix.setMatrix(_matrix);
        return matrix;
    }

    public void setIn(Scanner scanner) {
        this.in = scanner;
    }
}
