package ifmo.math.readers;

import ifmo.math.structures.GSMatrix;
import ifmo.math.structures.Matrix;

import java.util.Scanner;

public class MatrixReader {
    private boolean isSilent = false;

    public MatrixReader() {
    }

    public MatrixReader(boolean makeSilent) {
        isSilent = makeSilent;
    }

    public boolean isSilent() {
        return isSilent;
    }

    public void setSilent(boolean silent) {
        isSilent = silent;
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

    private double[][] readMatrix(Scanner in) {
        int size = readSize(in);
        return readMatrix(size, in);
    }

    private int readSize(Scanner in) {
        System.out.print("Size: ");
        int size = in.nextInt();
        System.out.println(size);
        return size;
    }

    private double[][] readMatrix(int size, Scanner in) {
        double[][] matrix = new double[size][size + 1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                matrix[i][j] = in.nextDouble();
            }
        }
        return matrix;
    }

    public GSMatrix createGSMatrix(int size, Scanner in) {
        return new GSMatrix(new Matrix(readMatrix(size, in)));
    }

    public GSMatrix createGSMatrix(Scanner in) {
        int size = readSize(in);
        return createGSMatrix(size, in);
    }
}
