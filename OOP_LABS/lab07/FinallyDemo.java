// Ex 7.5 (Challenge)
public class FinallyDemo {
    @SuppressWarnings("finally")
    static int test() {
        int x = 1;
        try {
            System.out.println("in try, x = " + x);
            return x;                       // the value 1 is saved as the return value here
        } finally {
            x = 99;                         // changes the variable, NOT the already-saved return value
            System.out.println("in finally, x = " + x);
        }
    }
    @SuppressWarnings("finally")
    static int override() {
        try { return 1; }
        finally { return 2; }               // a return in finally REPLACES the earlier one (bad practice)
    }
    public static void main(String[] args) {
        System.out.println("test() returned " + test());       // try prints, finally prints, then 1
        System.out.println("override() returned " + override()); // 2
        // Why finally still runs: the JVM guarantees finally executes whenever control leaves the try
        // block, including by return, break, continue or an exception. The only exceptions are
        // System.exit(), a JVM crash or the thread being killed.
    }
}
