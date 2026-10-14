import java.util.Arrays;

// Ex 5.1 (Basic)
public class Printer {
    void print(int x)      { System.out.println("int: " + x); }
    void print(double x)   { System.out.println("double: " + x); }
    void print(String x)   { System.out.println("String: " + x); }
    void print(int[] x)    { System.out.println("int[]: " + Arrays.toString(x)); }

    public static void main(String[] args) {
        Printer p = new Printer();
        p.print(7);
        p.print(3.14);
        p.print("hello");
        p.print(new int[]{1, 2, 3});
        p.print('A');          // char widens to int, so print(int) is chosen: prints 65
    }
}
