// Ex 3.1 + 3.2 (Basic)
public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) { setName(name); setMarks(marks); }  // validate in constructor too

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        this.name = name.trim();
    }
    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks must be 0-100, got " + marks);
        this.marks = marks;
    }

    // Derived from marks every time; never stored, so it can never disagree with marks
    public String getGrade() {
        if (marks >= 75) return "A";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        return "F";
    }

    public static void main(String[] args) {
        Student s = new Student("Rudo", 82);
        System.out.println(s.getName() + " " + s.getMarks() + " " + s.getGrade());
        s.setMarks(55);
        System.out.println(s.getName() + " " + s.getMarks() + " " + s.getGrade());
        try { s.setMarks(120); } catch (IllegalArgumentException e) { System.out.println("Rejected: " + e.getMessage()); }
        System.out.println("Marks still " + s.getMarks());
    }
}
