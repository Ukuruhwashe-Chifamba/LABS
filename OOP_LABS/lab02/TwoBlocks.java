// Ex 2.4 (Intermediate): predict, then verify.
// Prediction: static field/blocks in written order (once) -> then for EACH object:
// instance field/blocks in written order -> constructor.
// S1, S2 once; then I1, I2, ctor for the first object; I1, I2, ctor for the second.
public class TwoBlocks {
    static { System.out.println("S1 static block"); }
    { System.out.println("I1 instance block"); }
    static { System.out.println("S2 static block"); }
    { System.out.println("I2 instance block"); }
    TwoBlocks() { System.out.println("constructor"); }

    public static void main(String[] args) {
        System.out.println("main starts");
        new TwoBlocks();
        new TwoBlocks();
    }
}
