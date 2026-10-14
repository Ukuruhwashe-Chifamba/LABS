// Ex 3.4 (Intermediate)
// final class        -> no subclass can add mutable state or override methods and break immutability
// private final fields -> assigned once in the constructor, never reassigned
// no setters         -> nothing can change state after construction
// validate in constructor -> an ImmutablePerson can never exist in an invalid state
// (Strings are immutable, so returning name directly is safe. A mutable field such as a
//  Date or List would need a defensive copy both in the constructor and in the getter.)
public final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.name = name; this.age = age;
    }
    public String getName() { return name; }
    public int getAge()     { return age; }

    // "Changing" an immutable object means making a new one
    public ImmutablePerson withAge(int newAge) { return new ImmutablePerson(name, newAge); }

    public String toString() { return name + " (" + age + ")"; }

    public static void main(String[] args) {
        ImmutablePerson p = new ImmutablePerson("Chipo", 30);
        ImmutablePerson older = p.withAge(31);
        System.out.println(p + " -> " + older);
    }
}
