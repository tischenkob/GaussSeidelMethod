package ifmo.math.structures;

public class GSMatrix extends Matrix {

    public GSMatrix(int i) {
        super(i);
    }

    public GSMatrix(double[][] matrix) {
        super(matrix);
    }

    public GSMatrix(Matrix matrix) {
        this.setMatrix(matrix.getMatrix());
        this.setSize(matrix.getSize());
    }

    public boolean isDiagonallyDominant() {
        double[][] m = getMatrix();
        int size = getSize();
        for (int i = 0; i < size; i++) {
            double sum = 0;
            double absEl = Math.abs(m[i][i]);
            for (int j = 0; j < size; j++) {
                if (j != i) sum += Math.abs(m[i][j]);
                if (absEl < sum) return false;
            }
        }
        return true;
    }

    public void makeDiagonallyDominant() {
        /* TODO if enough time */
    }

    public double[][] divideByMainDiagonal() {
        double[][] coefs = this.getMatrix().clone();
        for (int i = 0; i < this.getSize(); i++) {
            double ai = coefs[i][i];
            for (int j = 0; j < this.getSize() + 1; j++) {
                coefs[i][j] /= ai;
            }
        }
        return coefs;
    }
}
