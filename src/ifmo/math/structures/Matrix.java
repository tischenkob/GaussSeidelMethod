package ifmo.math.structures;

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

    @Override
    public String toString() {
        String string = "Matrix {\n";
        for (double[] el : matrix) {

            for (double num : el) {
                string += num + " ";
            }
            string += "\n";
        }
        return string + "}";
    }
}
