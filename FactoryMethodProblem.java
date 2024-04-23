import java.util.*;

//Problem: Every Time a new vehicleType class added client is to be updated
public class FactoryMethodProblem {
    // Super Class
    class Vehicle {

        void createVehicle() {
        }
    }

    class Bike extends Vehicle {
        Bike() {
        }

        void createVehicle() {
            System.out.println("Created a bike");
        }
    }

    class Car extends Vehicle {
        Car() {
        }

        void createVehicle() {
            System.out.println("Created a car");
        }
    }

    // Client code
    // Each Time a new type of vehicle is added the client has to modify the code
    class Client {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String vehicleType = sc.next();
            Vehicle vehicle = null;
            if ("Bike".equals(vehicleType)) {
                vehicle = new Bike();
            } else if ("Car".equals(vehicleType)) {
                vehicle = new Car();
            }
            vehicle.createVehicle();
        }
    }

}