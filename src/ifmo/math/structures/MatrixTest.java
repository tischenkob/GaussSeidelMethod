package ifmo.math.structures;

import org.junit.Test;

import java.util.Arrays;

public class MatrixTest {

    @Test
    public void swapRows() {
        Matrix m = new Matrix(3);
        m.setMatrix(new double[][]
                {
                        {1, 2, 3},
                        {2, 3, 4},
                        {4, 5, 6}
                }
        );
        m.swapRows(0, 2);

        assert(Arrays.equals(m.getMatrix()[0], new double[]{4, 5, 6}));
        assert(Arrays.equals(m.getMatrix()[2], new double[]{1, 2, 3}));
    }

    @Test
    public void swapColumns() {
        Matrix m = new Matrix(3);
        m.setMatrix(new double[][]
                {
                        {1, 2, 3},
                        {2, 3, 4},
                        {4, 5, 6}
                }
        );
        m.swapColumns(0, 2);

        assert(m.getMatrix()[0][0] == 3);
        assert(m.getMatrix()[1][0] == 4);
        assert(m.getMatrix()[2][0] == 6);

        assert(m.getMatrix()[0][2] == 1);
        assert(m.getMatrix()[1][2] == 2);
        assert(m.getMatrix()[2][2] == 4);

    }
}