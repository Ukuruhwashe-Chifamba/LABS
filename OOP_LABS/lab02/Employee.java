// Ex 2.3 (Intermediate)
public class Employee {
    private static int nextId = 1000;
    private final int employeeId;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name; this.department = department; this.salary = salary;
    }
    public Employee(String name, double salary) { this(name, "Unassigned", salary); }
    public Employee(String name) { this(name, 0.0); }

    // Copy constructor: same data, but a NEW id (two employees must never share an id)
    public Employee(Employee other) { this(other.name, other.department, other.salary); }

    public String toString() {
        return employeeId + " " + name + " [" + department + "] " + salary;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Kudzai", "IT", 2000);
        Employee e2 = new Employee("Nyasha", 1800);
        Employee e3 = new Employee("Tatenda");
        Employee e4 = new Employee(e1);
        for (Employee e : new Employee[]{e1, e2, e3, e4}) System.out.println(e);
    }
}
