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
                        {3, 2, 1},
                        {1, 3, 2},
                        {3, 2, 1}
                });
        assertFalse(m.isDiagonallyDominant());

        m.setMatrix(
                new double[][]{
                        {3, 2, 3},
                        {1, 3, 2},
                        {3, 2, 3}
                });

        assertTrue(m.isDiagonallyDominant());
    }

    @Test
    public void makeDiagonallyDominant() {

    }
}