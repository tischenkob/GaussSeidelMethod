package ifmo.interact;

public interface CanInterview {
    boolean prompt(String question);

    boolean prompt(String question, String positive, String negative);

    boolean prompt(String question, String[] positive, String[] negative);

    String askString(String question);

    int askInteger(String question);

    double askDouble(String question);
}
