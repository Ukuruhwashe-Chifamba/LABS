// Ex 1.3 (Intermediate)
public class LargestRectangle {
    public static void main(String[] args) {
        Rectangle[] rs = {
            new Rectangle(2, 3), new Rectangle(5, 4), new Rectangle(1, 10),
            new Rectangle(6, 6), new Rectangle(3, 3)
        };
        Rectangle best = rs[0];
        for (Rectangle r : rs) if (r.area() > best.area()) best = r;
        System.out.println("Largest: " + best + " area = " + best.area());
    }
}
