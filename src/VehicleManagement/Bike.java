package VehicleManagement;

public class Bike extends Vehicle {

    private String bikeType;
    private int gearCount;
    private String frameMaterial;

    public Bike(String brand, String model, int year,
                String color, double price,
                String bikeType, int gearCount,
                String frameMaterial) {

        super(brand, model, year, color, price);

        this.bikeType = bikeType;
        this.gearCount = gearCount;
        this.frameMaterial = frameMaterial;
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }

    @Override
    public String getDescription() {
        return bikeType + " bike with " +
                gearCount + " gears and a " +
                frameMaterial + " frame.";
    }

    @Override
    public String toString() {
        return getVehicleType() + " {" +
                super.toString() +
                ", Type: " + bikeType +
                ", Gears: " + gearCount +
                ", Frame: " + frameMaterial +
                "}";
    }
}