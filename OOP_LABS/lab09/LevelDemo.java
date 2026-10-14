// Ex 9.1 (Basic)
enum Level { LOW, MEDIUM, HIGH }
public class LevelDemo {
    static String advice(Level l) {
        return switch (l) {                     // switch expression: compiler checks all constants are covered
            case LOW    -> "Relax, no action needed";
            case MEDIUM -> "Keep an eye on it";
            case HIGH   -> "Act now";
        };
    }
    public static void main(String[] args) {
        for (Level l : Level.values()) System.out.println(l + ": " + advice(l));
    }
}
