// Ex 7.4 (Intermediate)
class InsufficientFundsException extends Exception {
    private final double shortfall;
    public InsufficientFundsException(double shortfall) {
        super(String.format("Insufficient funds: short by %.2f", shortfall));
        this.shortfall = shortfall;
    }
    public double getShortfall() { return shortfall; }
}
class BankAccount {
    private double balance;
    BankAccount(double opening) { this.balance = opening; }
    double getBalance() { return balance; }
    void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) throw new InsufficientFundsException(amount - balance);   // state unchanged
        balance -= amount;
    }
}
// Trade-offs. Returning boolean (Lab 3): simple, but callers can ignore the result and carry on
// as if the money was paid, and false carries no reason. Throwing a checked exception: the compiler
// FORCES every caller to deal with failure, and the exception carries details (the shortfall).
// Costs: more code at every call site, exceptions are slower than a return value, and using them
// for an ordinary, expected outcome can hide the real control flow.
public class BankWithException {
    public static void main(String[] args) {
        BankAccount a = new BankAccount(100);
        try {
            a.withdraw(40);
            System.out.println("Balance: " + a.getBalance());
            a.withdraw(500);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage() + " (shortfall " + e.getShortfall() + ")");
        }
        System.out.println("Balance unchanged: " + a.getBalance());
    }
}
