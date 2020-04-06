package ifmo.math.structures;

import java.util.Arrays;

public class Matrix {
    private double[][] matrix;
    private int size;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
    }

    public Matrix(int size) {
        this.matrix = new double[size][size + 1];
        this.size = size;
    }

    public Matrix() {

    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void swapRows(int first, int second) {
        try {
            double[] temp = matrix[first].clone();
            matrix[first] = matrix[second];
            matrix[second] = temp;
        } catch (ArrayIndexOutOfBoundsException a) {
            System.err.println("Row number limit exceeded. Remember we start counting from 0.");
        }
    }

    public void swapColumns(int first, int second) {
        double temp;
        for (int i = 0; i < size; i++) {
            temp = matrix[i][first];
            matrix[i][first] = matrix[i][second];
            matrix[i][second] = temp;
        }
    }

    public boolean isDiagonallyDominant() {
        double[][] m = getMatrix();
        int size = getSize();
        for (int i = 0; i < size; i++) {
            double[] row = m[i];
            if (!isElementDominant(i, row)) return false;
        }
        return true;
    }

    private boolean isElementDominant(int index, double[] row) {
        double el = Math.abs(row[index]);
        if (el == 0) return false;
        double sum = 0;
        for (int i = 0; i < row.length - 1; i++) {
            sum += Math.abs(row[i]);
        }
        return (el * 2) >= sum;
    }

    public boolean achieveDiagonalDominance() {
        int[] corrRows = new int[size];
        Arrays.fill(corrRows, -1);
        for (int i = 0; i < getSize(); i++) {
            double[] row = getMatrix()[i];
            int domElNumb = findDominantElement(row);
            corrRows[domElNumb] = i;
        }

        for (int num : corrRows) {
            if (num == -1) return false;
        }

        double[][] transformedMatrix = new double[size][size + 1];
        for (int i = 0; i < matrix.length; i++) {
            transformedMatrix[i] = matrix[corrRows[i]].clone();
        }
        matrix = transformedMatrix.clone();
        return true;
    }

    private int findDominantElement(double[] row) {
        double sum = 0;
        for (int i = 0; i < row.length - 1; i++) {
            sum += row[i];
        }
        for (int i = 0; i < row.length - 1; i++) {
            if ((row[i] * 2) >= sum) return i;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Matrix {\n");
        for (double[] el : matrix) {

            for (double num : el) {
                string.append(num).append(" ");
            }
            string.append("\n");
        }
        return string + "}";
    }
}
