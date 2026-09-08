package VehicleManagement;

public class Bike extends Vehicle {
    private String bikeType;
    private int gearCount;
    private String frameMaterial;

    public Bike(String brand, String model, int year, String color, double price,
                String bikeType, int gearCount, String frameMaterial) {

        super(brand, model, year, color, price);

        this.bikeType = bikeType;
        this.gearCount = gearCount;
        this.frameMaterial = frameMaterial;
    }

    public String getBikeType() {
        return bikeType;
    }

    public int getGearCount() {
        return gearCount;
    }

    public String getFrameMaterial() {
        return frameMaterial;
    }

    @Override
    public String toString() {
        return "Bike {" +
                super.toString() +
                ", Type: " + bikeType +
                ", Gears: " + gearCount +
                ", Frame: " + frameMaterial +
                "}";
    }
}