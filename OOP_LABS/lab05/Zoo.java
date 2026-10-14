// Ex 5.2 (Basic)
class Animal { String sound() { return "..."; } }
class Cat extends Animal { @Override String sound() { return "Meow"; } }
class Cow extends Animal { @Override String sound() { return "Moo"; } }
class Duck extends Animal { @Override String sound() { return "Quack"; } }

public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = { new Cat(), new Cow(), new Duck() };
        for (Animal a : animals) System.out.println(a.getClass().getSimpleName() + " says " + a.sound());
    }
}
