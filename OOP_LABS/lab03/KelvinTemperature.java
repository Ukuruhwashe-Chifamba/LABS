// Ex 3.5 (Challenge)
public class KelvinTemperature {
    private double kelvin;      // internal representation; callers never see it

    public KelvinTemperature(double celsius) { setCelsius(celsius); }

    public double getCelsius()    { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9 / 5 + 32; }

    public void setCelsius(double c) {
        double k = c + 273.15;
        if (k < 0) throw new IllegalArgumentException("Below absolute zero: " + c + " C");
        this.kelvin = k;
    }

    // If we later stored Celsius or Fahrenheit internally instead, only the bodies of these
    // four methods would change. Their signatures stay the same, so no calling code breaks.

    public static void main(String[] args) {
        KelvinTemperature t = new KelvinTemperature(25);
        System.out.printf("%.1f C, %.1f F%n", t.getCelsius(), t.getFahrenheit());
        try { t.setCelsius(-300); } catch (IllegalArgumentException e) { System.out.println("Rejected: " + e.getMessage()); }
    }
}
