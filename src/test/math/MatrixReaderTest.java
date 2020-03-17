package test.math;

import ifmo.math.readers.MatrixReader;
import ifmo.math.structures.Matrix;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixReaderTest {

    @Test
    public void createMatrix() {
        //TODO write test

        try (Scanner sc = new Scanner(new File("src/resources/input.txt"))) {
            Matrix m = MatrixReader.createMatrix(sc);
            System.out.println(m);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}