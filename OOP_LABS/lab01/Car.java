import java.time.Year;

public class Car {
    String brand;
    int year;
    double mileage;

    Car(String brand, int year, double mileage) {
        this.brand = brand; this.year = year; this.mileage = mileage;
    }

    void display() {
        System.out.println(brand + " (" + year + "), " + mileage + " km");
    }

    // Ex 1.2 (Basic): "more than 25 years old"
    boolean isAntique() {
        return Year.now().getValue() - year > 25;
    }

    // Ex 1.1 + 1.2
    public static void main(String[] args) {
        Car[] cars = { new Car("Toyota", 1995, 250000), new Car("Honda", 2015, 120000), new Car("Mazda", 2022, 30000) };
        for (Car c : cars) {
            c.display();
            System.out.println("  antique? " + c.isAntique());
        }
    }
}
