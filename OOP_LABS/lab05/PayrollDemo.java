// Ex 5.3 (Intermediate): the payroll loop never mentions Intern, Manager, etc.
public class PayrollDemo {
    static double totalPayroll(Employee[] staff) {
        double total = 0;
        for (Employee e : staff) total += e.calculatePay();   // dynamic dispatch picks the right version
        return total;
    }
    public static void main(String[] args) {
        Employee[] staff = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Intern("Blessing", 1200)        // capped at 800 by Intern's own rule
        };
        for (Employee e : staff) System.out.printf("%-9s %.2f%n", e.getName(), e.calculatePay());
        System.out.printf("Total payroll: %.2f%n", totalPayroll(staff));
    }
}
