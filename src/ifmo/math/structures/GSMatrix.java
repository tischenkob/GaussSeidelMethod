package ifmo.math.structures;

import ifmo.math.exceptions.NotDiagonallyDominantException;

public class GSMatrix extends Matrix {

    public GSMatrix(int i) {
        super(i);
    }

    public GSMatrix(double[][] matrix) {
        super(matrix);
    }

    public GSMatrix(Matrix matrix) throws NotDiagonallyDominantException {
        if (!matrix.isDiagonallyDominant()) throw new NotDiagonallyDominantException();
        this.setMatrix(matrix.getMatrix());
        this.setSize(matrix.getSize());
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
