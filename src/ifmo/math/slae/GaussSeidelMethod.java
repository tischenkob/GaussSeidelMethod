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
        double[] x = new double[matrix.getSize()];
        Arrays.fill(x, 0);
        double[][] coefs = matrix.getMatrix();

        boolean notSolved = true;
        while (notSolved) {
            double[] newX = iterate(coefs, x);
            notSolved = !elementsAreEpsilonDifferent(epsilon, x, newX);
            x = newX;
        }

        return x;
    }

    public double[] iterate(double[][] coefs, double[] oldValues) {
        double[] newValues = oldValues.clone();
        for (int i = 0; i < oldValues.length; i++) {
            double[] row = coefs[i];
            double sum = row[coefs.length - 1];
            for (int j = 0; j < i; j++)
                sum -= row[j] * newValues[j];

            for (int j = i + 1; j < oldValues.length; j++)
                sum -= row[j] * oldValues[j];


            newValues[i] = sum / coefs[i][i];
        }
        return newValues;
    }

    public boolean elementsAreEpsilonDifferent(double eps, double[] arr1, double[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (abs(arr1[i] - arr2[i]) >= (eps + 0.000000000001)) return false;
        }
        return true;
    }
}
