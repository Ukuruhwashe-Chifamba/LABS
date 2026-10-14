// Ex 6.2 (Basic): unrelated classes sharing a capability through an interface
interface Flyable { void fly(); }
class Bird implements Flyable { public void fly() { System.out.println("Bird flaps its wings"); } }
class Aeroplane implements Flyable { public void fly() { System.out.println("Aeroplane uses jet engines"); } }
public class FlyDemo {
    public static void main(String[] args) {
        Flyable[] things = { new Bird(), new Aeroplane() };
        for (Flyable f : things) f.fly();
    }
}
