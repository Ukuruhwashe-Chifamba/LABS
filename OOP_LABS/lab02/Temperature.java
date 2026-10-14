// Ex 2.5 (Challenge)
public class Temperature {
    private final double celsius;
    private Temperature(double celsius) { this.celsius = celsius; }

    public static Temperature fromCelsius(double c)    { return new Temperature(c); }
    public static Temperature fromFahrenheit(double f) { return new Temperature((f - 32) * 5 / 9); }

    public double getCelsius()    { return celsius; }
    public double getFahrenheit() { return celsius * 9 / 5 + 32; }

    // Why static factories can be clearer: both conversions take ONE double, so
    // constructors Temperature(double) and Temperature(double) would have identical
    // signatures and could not even be overloaded. A factory has a descriptive name
    // that says what the number means; constructors cannot be named.

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(100);
        Temperature t2 = Temperature.fromFahrenheit(98.6);
        System.out.printf("%.1f C = %.1f F%n", t1.getCelsius(), t1.getFahrenheit());
        System.out.printf("%.1f C = %.1f F%n", t2.getCelsius(), t2.getFahrenheit());
    }
}
