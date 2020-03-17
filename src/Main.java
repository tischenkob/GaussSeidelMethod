import ifmo.interact.Interviewer;
import ifmo.math.exceptions.NotDiagonallyDominantException;
import ifmo.math.readers.GSMatrixReader;
import ifmo.math.slae.GaussSeidelMethod;
import ifmo.math.structures.GSMatrix;
import ifmo.math.structures.Matrix;
import ifmo.math.structures.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath;
        Scanner scanner = new Scanner(System.in);
        Interviewer i9r = new Interviewer(scanner);
        Scanner dataIn = null;

        System.out.println("Welcome! This application's sole purpose is to solve Systems of Linear Algebraic Equations (SLAE).");
        boolean makeSilent = false;
        while (dataIn == null) {
            try {
                filePath = i9r.askString("Enter file path or leave blank for console input: ");
                if (filePath.isBlank()) {
                    dataIn = scanner;
                    makeSilent = true;
                } else {
                    dataIn = new Scanner(new File(filePath));
                }
            } catch (FileNotFoundException ex) {
                System.out.println("No such file in this location.");
            }
        }
        GSMatrixReader reader = new GSMatrixReader(dataIn, makeSilent);

        GSMatrix matrix = null;
        while (matrix == null) {
            try {
                Matrix auxMatrix = reader.createMatrix();
                auxMatrix = new GSMatrix(auxMatrix);
                matrix = (GSMatrix) auxMatrix;

                double epsilon = reader.readEpsilon(dataIn);
                GaussSeidelMethod gsMethod = new GaussSeidelMethod(epsilon);

                System.out.println(new Vector(gsMethod.solve(matrix)));
                System.out.println("Solved in " + gsMethod.getIterationsCount() + " iterations.");
            } catch (NotDiagonallyDominantException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again.");
                reader.setIn(new Scanner(System.in));
            }
        }

    }
}
