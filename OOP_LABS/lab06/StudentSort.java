import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

// Ex 6.4 (Intermediate)
class Student implements Comparable<Student> {
    final String name; final int marks;
    Student(String name, int marks) { this.name = name; this.marks = marks; }
    @Override public int compareTo(Student o) { return name.compareTo(o.name); }   // natural order: by name
    public String toString() { return name + " (" + marks + ")"; }
}
public class StudentSort {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(new Student("Tendai", 70), new Student("Anesu", 85), new Student("Chipo", 60)));
        Collections.sort(list);                                        // uses compareTo
        System.out.println("By name:  " + list);
        Comparator<Student> byMarks = Comparator.comparingInt((Student s) -> s.marks).reversed();
        list.sort(byMarks);                                            // external ordering: marks descending
        System.out.println("By marks: " + list);
    }
}
