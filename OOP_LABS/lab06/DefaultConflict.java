// Ex 6.5 (Challenge)
interface Greeter  { default void hello() { System.out.println("Hello from Greeter"); } }
interface Welcomer { default void hello() { System.out.println("Hello from Welcomer"); } }

// Rule: if a class inherits two default methods with the same signature, the compiler refuses
// to guess. The class MUST override hello() itself. Inside it, InterfaceName.super.hello()
// chooses which inherited version to call (or both). A method in the class itself, or in a
// superclass, always wins over interface defaults.
class Host implements Greeter, Welcomer {
    @Override public void hello() {
        Greeter.super.hello();
        Welcomer.super.hello();
        System.out.println("Hello from Host");
    }
}
public class DefaultConflict {
    public static void main(String[] args) { new Host().hello(); }
}
