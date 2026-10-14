// Ex 4.3 (Intermediate)
class Vehicle {
    Vehicle() { System.out.println("1. Vehicle constructor"); }
}
class Car extends Vehicle {
    Car() { System.out.println("2. Car constructor"); }          // implicit super() runs first
}
class ElectricCar extends Car {
    ElectricCar() { System.out.println("3. ElectricCar constructor"); }
}
public class VehicleChain {
    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar:");
        new ElectricCar();     // constructors always run from the top of the hierarchy downwards
    }
}
