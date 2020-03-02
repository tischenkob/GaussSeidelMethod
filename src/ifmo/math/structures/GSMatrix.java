package ifmo.math.structures;

public class GSMatrix extends Matrix {

    public GSMatrix(int i) {
        super(i);
    }

    public boolean isDiagonallyDominant() {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (getMatrix()[i][i] < getMatrix()[i][j]) return false;
            }
        }
        return true;
    }

    public void makeDiagonallyDominant() {

    }

    public double[][] divideByMainDiagonal() {
        double[][] coefs = this.getMatrix().clone();
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize() + 1; j++) {
                coefs[i][j] /= coefs[i][i];
            }
        }
        return coefs;
    }
}
