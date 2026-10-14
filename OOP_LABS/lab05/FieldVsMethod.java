// Ex 5.4 (Intermediate)
class Parent {
    String label = "Parent field";
    String who() { return "Parent method"; }
    static String tag() { return "Parent static"; }
}
class Child extends Parent {
    String label = "Child field";            // HIDES the parent field; does not override it
    @Override String who() { return "Child method"; }
    static String tag() { return "Child static"; }   // hides, does not override
}
public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child();              // declared type Parent, real object Child
        System.out.println(p.who());         // Child method   (decided at run time by the object)
        System.out.println(p.label);         // Parent field   (decided at compile time by the variable type)
        System.out.println(Parent.tag());    // Parent static
        // Explanation: only instance methods use dynamic dispatch. Field access and static
        // method calls are resolved by the compiler from the DECLARED type (Parent).
        System.out.println(((Child) p).label);   // Child field, after casting the declared type to Child
    }
}
