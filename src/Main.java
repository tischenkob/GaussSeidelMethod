import ifmo.app.App;
import ifmo.app.GSMApp;
import ifmo.app.TMApp;
import ifmo.interact.Interviewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Interviewer interviewer = new Interviewer(new Scanner(System.in));
        List<App> apps = new ArrayList<>();
        apps.add(new GSMApp());
        apps.add(new TMApp());
        int i = interviewer.askInteger("Choose assignment:\n0) Gauss-Seidel Method\n1) Trapezoid Method\n> ");
        apps.get(i).start();
    }
}
