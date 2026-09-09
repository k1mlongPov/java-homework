package VehicleManagement;

public class Car extends Vehicle {

    private int numberOfDoors;
    private String fuelType;
    private String transmission;

    public Car(String brand, String model, int year,
               String color, double price,
               int numberOfDoors, String fuelType,
               String transmission) {

        super(brand, model, year, color, price);

        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmission = transmission;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public String getDescription() {
        return "A " + fuelType + " " + transmission +
                " car with " + numberOfDoors + " doors.";
    }

    @Override
    public String toString() {
        return getVehicleType() + " {" +
                super.toString() +
                ", Doors: " + numberOfDoors +
                ", Fuel: " + fuelType +
                ", Transmission: " + transmission +
                "}";
    }
}