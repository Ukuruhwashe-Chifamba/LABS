// Ex 9.2 (Basic)
record Student(String name, int age) { }
public class RecordDemo {
    public static void main(String[] args) {
        Student a = new Student("Tariro", 20);
        Student b = new Student("Tariro", 20);
        System.out.println(a);                          // toString generated: Student[name=Tariro, age=20]
        System.out.println("equal? " + a.equals(b));    // equals compares components: true
        System.out.println("same object? " + (a == b)); // false
        System.out.println("name = " + a.name());       // component accessor, no 'get' prefix
    }
}
