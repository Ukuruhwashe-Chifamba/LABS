// Ex 6.3 (Intermediate)
abstract class Account {
    protected double balance;
    void deposit(double amt) {                         // concrete: identical for every account
        if (amt <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amt;
    }
    abstract double monthlyFee();                      // each account type charges differently
    void applyMonthEnd() { balance -= monthlyFee(); }  // template: shared steps, varying part
}
class SavingsAccount extends Account {
    double monthlyFee() { return balance > 1000 ? 0 : 2.50; }   // fee waived on high balances
}
class CurrentAccount extends Account {
    double monthlyFee() { return 10.00; }
}
public class AccountDemo {
    public static void main(String[] args) {
        Account[] accts = { new SavingsAccount(), new CurrentAccount() };
        for (Account a : accts) {
            a.deposit(500);
            a.applyMonthEnd();
            System.out.printf("%s balance after fees: %.2f%n", a.getClass().getSimpleName(), a.balance);
        }
    }
}
