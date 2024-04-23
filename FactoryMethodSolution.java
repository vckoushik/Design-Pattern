
//Solution: After Adding new vechicle no need to change in client code
// Vehicle Factory Creates all the objects for client
import java.util.*;

public class FactoryMethodSolution {
    // Super Class
    abstract class Vehicle {
        abstract void createVehicle();
    }

    class Bike extends Vehicle {
        void createVehicle() {
            System.out.println("Created a bike");
        }
    }

    class Car extends Vehicle {
        void createVehicle() {
            System.out.println("Created a car");
        }
    }

    // Factory Class that Create Vehicles for client
    class VehicleFactory {
        Vehicle createVehicle(String vehicleType) {
            if ("Bike".equals(vehicleType)) {
                return new Bike();
            } else if ("Car".equals(vehicleType)) {
                return new Car();
            }
            return null;
        }
    }

    // Client code
    // After Adding new vechicle no need to change in client code
    class Client {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String vehicleType = sc.next();

            VehicleFactory factory = new VehicleFactory();
            Vehicle vehicle = factory.createVehicle(vehicleType);

            if (vehicle != null) {
                vehicle.createVehicle();
            } else {
                System.out.println("Invalid vehicle type.");
            }
        }
    }

}
