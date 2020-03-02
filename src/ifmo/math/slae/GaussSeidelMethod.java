package ifmo.math.slae;

import ifmo.math.structures.GSMatrix;

import java.util.Arrays;

import static java.lang.Math.abs;

public class GaussSeidelMethod {
    private double epsilon;
    private int lastIterations = 0;

    public GaussSeidelMethod(double epsilon) {
        this.epsilon = epsilon;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(float epsilon) {
        this.epsilon = epsilon;
    }

    public double[] solve(GSMatrix matrix) {
        double[] old_x = new double[matrix.getSize()];
        Arrays.fill(old_x, 0);
        double[] new_x = old_x.clone();
        double[][] coefs = matrix.divideByMainDiagonal();
        iterate(coefs, old_x, new_x);

        while (!elementsAreEpsilonDifferent(epsilon, old_x, new_x)) {
            iterate(coefs, old_x, new_x);
        }

        return new_x;
    }

    public void iterate(double[][] coefs, double[] oldArr, double[] newArr) {
        oldArr = newArr.clone();

        for (int i = 0; i < oldArr.length; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) sum += coefs[i][j] * oldArr[i];
            for (int j = i + 1; j < oldArr.length - 1; j++) sum += coefs[i][j] * oldArr[i];
            sum -= coefs[i][coefs.length - 1];
            newArr[i] = sum;
        }
    }

    public boolean elementsAreEpsilonDifferent(double eps, double[] arr1, double[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (abs(arr1[i] - arr2[i]) >= eps) return false;
        }
        return true;
    }
}
