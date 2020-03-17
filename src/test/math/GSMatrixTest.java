package test.math;

import ifmo.math.structures.GSMatrix;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GSMatrixTest {

    @Test
    public void isDiagonallyDominant() {
        GSMatrix m = new GSMatrix(3);
        m.setMatrix(
                new double[][]{
                        {1, 2, 3},
                        {1, 3, 2},
                        {3, 2, 1}
                });
        assertFalse(m.isDiagonallyDominant());

        m.setMatrix(
                new double[][]{
                        {-2, 2, 1},
                        {1, 3, 2},
                        {1, -2, 0}
                });
        assertFalse(m.isDiagonallyDominant());

        m.setMatrix(
                new double[][]{
                        {3, -2, 1},
                        {1, -3, 2},
                        {-1, 2, 4}
                });

        assertTrue(m.isDiagonallyDominant());

        m.setMatrix(new double[][]{
                {6, 1, 3, 18},
                {2, 5, -1, -18},
                {-4, 3, 8, 28}
        });

        assertTrue(m.isDiagonallyDominant());
    }

    @Test
    public void makeDiagonallyDominant() {

    }

    @Test
    public void divideByMainDiagonal() {
        double[][] auxM = {
                {3, 2, -5, -1},
                {2, -1, 3, 13},
                {1, 2, -1, 9}
        };
        GSMatrix m = new GSMatrix(auxM);

        m.divideByMainDiagonal();

        System.out.println(m);
    }
}