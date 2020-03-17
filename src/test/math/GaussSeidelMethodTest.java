package test.math;

import ifmo.math.slae.GaussSeidelMethod;
import ifmo.math.structures.GSMatrix;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GaussSeidelMethodTest {

    @Test
    public void solve() {
        double epsilon = 0.0000000000000001;
        GaussSeidelMethod method = new GaussSeidelMethod(epsilon);
        double[][] auxM = {
                {6, 1, 3, 18},
                {2, 5, -1, -18},
                {-4, 3, 8, 28}
        };
        double[] res = method.solve(new GSMatrix(auxM));
        System.out.println(Arrays.toString(res));
        double[] ans = {1, -3, 5};
        boolean test1 = Math.abs(res[0] - ans[0]) < epsilon;
        boolean test2 = Math.abs(res[1] - ans[1]) < epsilon;
        boolean test3 = Math.abs(res[2] - ans[2]) < epsilon;
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
    }

    @Test
    public void iterate() {
        double epsilon = 0.0000000001;
        GaussSeidelMethod m = new GaussSeidelMethod(epsilon);
        double[][] coefs = {{2, 1, 4}, {0, -1, -2}};
        double[] val = {0, 0};
        double[] res = m.iterate(coefs, val);
        double[] ans = m.solve(new GSMatrix(coefs));
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(ans));
    }

    @Test
    public void elementsAreEpsilonDifferent() {
        double epsilon = 0.001;
        GaussSeidelMethod m = new GaussSeidelMethod(epsilon);
        double[] X1 = {1, 2, 3};
        double[] X2 = {1.001, 2.0005, 3.0};
        double[] X3 = {1, 2, 3, 4};
        double[] X4 = {1.002, 2, 3};
        boolean test1 = m.elementsAreEpsilonDifferent(epsilon, X1, X2);
        boolean test2 = m.elementsAreEpsilonDifferent(epsilon, X1, X3);
        boolean test3 = m.elementsAreEpsilonDifferent(epsilon, X1, X4);
        boolean test4 = m.elementsAreEpsilonDifferent(epsilon, X2, X4);
        assertTrue(test1);
        assertFalse(test2);
        assertFalse(test3);
        assertTrue(test4);


    }
}