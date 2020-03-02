package ifmo.math.structures;

public class Vector {
    double[] x;

    public Vector(double[] x) {
        this.x = x;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[");
        for (int i = 0; i < x.length - 1; i++) {
            string.append(x[i]).append(", ");
        }
        string.append(x[x.length - 1]).append("]");
        return string.toString();
    }
}
