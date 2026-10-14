import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Ex 3.3 (Intermediate)
public class BankAccountHistory {
    private final String accountNumber;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccountHistory(String accountNumber, double opening) {
        this.accountNumber = accountNumber;
        this.balance = opening;
        history.add("OPEN " + opening);
    }
    public void deposit(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amt; history.add("DEPOSIT " + amt);
    }
    public boolean withdraw(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amt > balance) { history.add("FAILED WITHDRAW " + amt); return false; }
        balance -= amt; history.add("WITHDRAW " + amt); return true;
    }
    public double getBalance() { return balance; }

    // Unmodifiable COPY: later changes to the account don't alter a list the caller already holds,
    // and the caller cannot modify our history.
    public List<String> getHistory() { return Collections.unmodifiableList(new ArrayList<>(history)); }

    public static void main(String[] args) {
        BankAccountHistory a = new BankAccountHistory("ACC-1", 100);
        a.deposit(50); a.withdraw(30); a.withdraw(1000);
        List<String> h = a.getHistory();
        h.forEach(System.out::println);
        try { h.add("HACK"); } catch (UnsupportedOperationException e) { System.out.println("History is read-only"); }
        a.deposit(5);
        System.out.println("Snapshot size " + h.size() + ", live size " + a.getHistory().size());
    }
}
