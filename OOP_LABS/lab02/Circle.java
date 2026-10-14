// Ex 2.1 + 2.2 (Basic)
public class Circle {
    private static int count = 0;      // one copy shared by every Circle
    private final double radius;

    public Circle(double radius) { this.radius = radius; count++; }
    public Circle() { this(1.0); }     // chaining: counter increments exactly once, in the main constructor

    public double getRadius() { return radius; }
    public static int getCount() { return count; }

    public static void main(String[] args) {
        Circle a = new Circle(2.5);
        Circle b = new Circle();
        System.out.println(a.getRadius() + " " + b.getRadius());
        System.out.println("Circles created: " + Circle.getCount());
    }
}
