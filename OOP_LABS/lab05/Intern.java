// New subclass: nothing else in the program has to change
public class Intern extends Employee {
    private static final double STIPEND_CAP = 800;
    public Intern(String name, double baseSalary) { super(name, baseSalary); }
    @Override public double calculatePay() { return Math.min(baseSalary, STIPEND_CAP); }
}
