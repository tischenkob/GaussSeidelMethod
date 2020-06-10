import ifmo.app.App;
import ifmo.app.GSMApp;
import ifmo.app.SNAEApp;
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
        apps.add(new SNAEApp());
        System.out.println("Choose assignment:");
        int j = 0;
        for (var app : apps) {
            System.out.println(j++ + ") " + app.toString());
        }
        int i = interviewer.askInteger("> ");
        apps.get(i).start();
    }
}
