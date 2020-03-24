package ifmo.math.slae;

import ifmo.math.structures.GSMatrix;
import ifmo.math.structures.Vector;

import java.util.Arrays;

import static java.lang.Math.abs;

public class GaussSeidelMethod {
    private double epsilon;

    public int getIterationsCount() {
        return iterationsCount;
    }

    private int iterationsCount = 0;

    public GaussSeidelMethod(double epsilon) {
        this.epsilon = epsilon;
    }

    public double[] solve(GSMatrix matrix) {
        double[] x = new double[matrix.getSize()];
        Arrays.fill(x, 0);
        double[][] coefs = matrix.getMatrix();
        boolean notSolved = true;
        iterationsCount = 0;
        while (notSolved) {
            double[] newX = iterate(coefs, x);
            iterationsCount++;
            notSolved = !areEpsilonDifferent(epsilon, x, newX);
            if (!notSolved) {
                double[] error = new double[x.length];
                for (int i = 0; i < x.length; i++) {
                    error[i] = abs(x[i] - newX[i]);
                }
                System.out.print("Error: ");
                System.out.println(new Vector(error));
            }
            x = newX;
        }
        return x;
    }

    public double[] iterate(double[][] coefs, double[] oldValues) {
        double[] newValues = oldValues.clone();
        for (int i = 0; i < oldValues.length; i++) {
            double[] row = coefs[i];
            double sum = row[row.length - 1];
            for (int j = 0; j < i; j++)
                sum -= row[j] * newValues[j];
            for (int j = i + 1; j < oldValues.length; j++)
                sum -= row[j] * oldValues[j];
            newValues[i] = sum / coefs[i][i];
        }
        return newValues;
    }

    public boolean areEpsilonDifferent(double eps, double[] arr1, double[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (abs(arr1[i] - arr2[i]) >= (eps)) return false;
        }
        return true;
    }
}
