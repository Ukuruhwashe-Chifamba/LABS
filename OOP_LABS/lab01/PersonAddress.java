// Ex 1.5 (Challenge)
class Address {
    String city;
    Address(String city) { this.city = city; }
}

class Person {
    String name;
    Address address;      // may be null
    Person(String name, Address address) { this.name = name; this.address = address; }
}

public class PersonAddress {
    public static void main(String[] args) {
        Person withAddress = new Person("Tariro", new Address("Harare"));
        System.out.println(withAddress.name + " lives in " + withAddress.address.city);  

        Person noAddress = new Person("Farai", null);
        try {
            System.out.println(noAddress.address.city);        
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: address is null, so .city cannot be read");
        }
        // Safe version: check first
        if (noAddress.address != null) System.out.println(noAddress.address.city);
        else System.out.println(noAddress.name + " has no address on file");
    }
}
