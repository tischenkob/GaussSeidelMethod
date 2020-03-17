import ifmo.interact.Interviewer;
import ifmo.math.factories.MatrixFactory;
import ifmo.math.slae.GaussSeidelMethod;
import ifmo.math.structures.GSMatrix;
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

        while (dataIn == null) {
            try {
                filePath = i9r.askString("Enter file path or leave blank for console input: ");
                dataIn = (filePath.isBlank())
                        ? scanner
                        : new Scanner(new File(filePath));
            } catch (FileNotFoundException ex) {
                System.out.println("No such file in this location.");
            }
        }
        GSMatrix matrix = MatrixFactory.createGSMatrix(dataIn);
        System.out.print("Precision: ");
        double epsilon = scanner.nextDouble();

        if (matrix.isDiagonallyDominant()) {
            GaussSeidelMethod gsMethod = new GaussSeidelMethod(epsilon);

            System.out.println(new Vector(gsMethod.solve(matrix)));
        }
    }
}
