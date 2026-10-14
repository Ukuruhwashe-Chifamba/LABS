// Ex 4.1 + 4.2 (Basic)
class Person {
    private final String name;
    private final int age;
    Person(String name, int age) { this.name = name; this.age = age; }
    String getName() { return name; }
    void display() { System.out.println("Name: " + name + ", Age: " + age); }   // written ONCE
}

class Student extends Person {
    private final String course;
    Student(String name, int age, String course) { super(name, age); this.course = course; }
    String getCourse() { return course; }
}

class Teacher extends Person {
    private final String subject;
    Teacher(String name, int age, String subject) { super(name, age); this.subject = subject; }
    String getSubject() { return subject; }
}

public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("Anesu", 40);
        Student s = new Student("Rudo", 20, "Computer Science");
        Teacher t = new Teacher("Mr Moyo", 45, "Java");
        p.display();
        s.display();     // inherited, not rewritten in Student
        t.display();     // the same Person.display() code is shared by both subclasses
        System.out.println(s.getName() + " studies " + s.getCourse());
        System.out.println(t.getName() + " teaches " + t.getSubject());
    }
}
