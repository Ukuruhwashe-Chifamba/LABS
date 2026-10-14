// Ex 7.3 (Intermediate)
class InvalidAgeException extends Exception {          // checked: extends Exception, not RuntimeException
    private final int age;
    public InvalidAgeException(int age) {
        super("Age must be between 0 and 120, got " + age);
        this.age = age;
    }
    public int getAge() { return age; }
}
public class AgeCheck {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) throw new InvalidAgeException(age);
    }
    public static void main(String[] args) {
        int[] tests = {25, -3, 121, 0, 120};
        for (int t : tests) {
            try {
                validateAge(t);
                System.out.println(t + " is valid");
            } catch (InvalidAgeException e) {
                System.out.println("Rejected: " + e.getMessage());
            }
        }
    }
}
