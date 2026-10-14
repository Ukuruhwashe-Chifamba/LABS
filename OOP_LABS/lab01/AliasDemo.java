// Ex 1.4 (Intermediate)
public class AliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2, 3);
        Rectangle r2 = r1;          
        r2.width = 99;
        System.out.println("r1.width = " + r1.width);  
       
    }
}
