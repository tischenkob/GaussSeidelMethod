package ifmo.math.structures;

public class GSMatrix extends Matrix{

    public GSMatrix(int size) {
        super(size);
    }

    public boolean isDiagonallyDominant(){
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (getMatrix()[i][i] < getMatrix()[i][j]) return false;
            }
        }
        return true;
    }

    public void makeDiagonallyDominant(){

    }

}
