// Ex 4.4 (Intermediate)
//
// This version does NOT compile (shown as a comment so the file builds):
//
//   class Animal { Animal(String name) { ... } }
//   class Dog extends Animal { }
//   -> error: constructor Animal in class Animal cannot be applied to given types
//
// Why: if a subclass constructor does not start with super(...) or this(...), the compiler
// inserts super() automatically. Animal has no no-argument constructor (writing Animal(String)
// removed the default one), so the inserted call cannot be satisfied. The same error occurs
// when Dog has no constructor at all, because the compiler supplies a default Dog() that calls super().
//
// Fix: call the existing superclass constructor explicitly.
class Animal {
    protected final String name;
    Animal(String name) { this.name = name; }
}
class Dog extends Animal {
    Dog(String name) { super(name); }           // the fix
    void bark() { System.out.println(name + " says Woof"); }
}
public class DogFix {
    public static void main(String[] args) { new Dog("Rex").bark(); }
}
