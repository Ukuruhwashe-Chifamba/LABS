// Ex 5.5 (Challenge)
interface Payment { double amount(); }

record CardPayment(double amount, String cardNumber) implements Payment { }
record MobileMoneyPayment(double amount, String phone) implements Payment { }
record CashPayment(double amount) implements Payment { }     // added later: shows the weakness of design 1

// Design 1: central instanceof chain. Works, but every NEW payment type means editing this method.
class PaymentProcessorV1 {
    static String pay(Payment p) {
        if (p instanceof CardPayment c) return "Charging card ending " + c.cardNumber().substring(c.cardNumber().length() - 4) + ": " + c.amount();
        else if (p instanceof MobileMoneyPayment m) return "Requesting mobile money from " + m.phone() + ": " + m.amount();
        else return "Unsupported payment type";      // CashPayment silently falls through here
    }
}

// Design 2: polymorphic. Each type knows how to process itself.
interface Processable { String process(); }
record CardPayment2(double amount, String cardNumber) implements Processable {
    public String process() { return "Charging card ending " + cardNumber.substring(cardNumber.length() - 4) + ": " + amount; }
}
record MobileMoneyPayment2(double amount, String phone) implements Processable {
    public String process() { return "Requesting mobile money from " + phone + ": " + amount; }
}
record CashPayment2(double amount) implements Processable {
    public String process() { return "Cash received: " + amount; }   // new type, no existing code edited
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment[] v1 = { new CardPayment(50, "4111111111111234"), new MobileMoneyPayment(20, "0771234567"), new CashPayment(5) };
        for (Payment p : v1) System.out.println("V1: " + PaymentProcessorV1.pay(p));
        Processable[] v2 = { new CardPayment2(50, "4111111111111234"), new MobileMoneyPayment2(20, "0771234567"), new CashPayment2(5) };
        for (Processable p : v2) System.out.println("V2: " + p.process());
        // Comparison: V1 keeps logic in one place and is quick for a fixed set of types, but it breaks
        // the open/closed principle and fails silently for unhandled types. V2 is open for extension
        // and the compiler forces each new type to implement process(). V2 puts behaviour in the data classes.
    }
}
