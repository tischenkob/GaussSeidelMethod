package ifmo.math.factories;

import ifmo.math.structures.Matrix;

import java.util.Scanner;

public class MatrixFactory {
    public static Matrix createMatrix(Scanner in){
        System.out.print("Size: ");
        int size = in.nextInt();
        System.out.println();
        return createMatrix(size, in);
    }
    public static Matrix createMatrix(int size, Scanner in){
        Matrix matrix = new Matrix(size);
        double[][] _matrix = readMatrix(size, in);
        matrix.setMatrix(_matrix);
        return matrix;
    }

    private static double[][] readMatrix(int size, Scanner in) {
        double [][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = in.nextDouble();
            }
        }
        return matrix;
    }

}
