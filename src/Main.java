import ifmo.interact.Interviewer;
import ifmo.math.readers.MatrixReader;
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
        boolean makeSilent = false;
        while (dataIn == null) {
            try {
                filePath = i9r.askString("Enter file path or leave blank for console input: ");
                if (filePath.isBlank()) dataIn = scanner;
                else {
                    dataIn = new Scanner(new File(filePath));
                    makeSilent = true;
                }
            } catch (FileNotFoundException ex) {
                System.out.println("No such file in this location.");
            }
        }
        MatrixReader reader = new MatrixReader(makeSilent);
        GSMatrix matrix = MatrixReader.createGSMatrix(dataIn);
        System.out.print("Precision: ");
        double epsilon = scanner.nextDouble();

        if (matrix.isDiagonallyDominant()) {
            GaussSeidelMethod gsMethod = new GaussSeidelMethod(epsilon);

            System.out.println(new Vector(gsMethod.solve(matrix)));
        }
    }
}
