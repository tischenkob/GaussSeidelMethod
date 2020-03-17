package ifmo.math.exceptions;

public class NotDiagonallyDominantException extends Exception {
    @Override
    public String getMessage() {
        return "The matrix you were trying to use is not diagonally dominant.";
    }
}
