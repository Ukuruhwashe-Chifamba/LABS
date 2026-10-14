import java.util.InputMismatchException;
import java.util.Scanner;

// Ex 7.1 (Basic)
public class SafeDivide {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("First integer: ");
            int a = in.nextInt();
            System.out.print("Second integer: ");
            int b = in.nextInt();
            System.out.println(a + " / " + b + " = " + (a / b));      // ArithmeticException if b == 0
        } catch (InputMismatchException e) {
            System.out.println("That was not a whole number.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            in.close();
        }
    }
}
