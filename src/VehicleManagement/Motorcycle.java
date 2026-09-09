package VehicleManagement;

public class Motorcycle extends Vehicle {

    private int engineCC;
    private boolean hasSidecar;
    private String type;

    public Motorcycle(String brand, String model, int year,
                      String color, double price,
                      int engineCC, boolean hasSidecar,
                      String type) {

        super(brand, model, year, color, price);

        this.engineCC = engineCC;
        this.hasSidecar = hasSidecar;
        this.type = type;
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }

    @Override
    public String getDescription() {
        return type + " motorcycle with a " +
                engineCC + "cc engine.";
    }

    @Override
    public String toString() {
        return getVehicleType() + " {" +
                super.toString() +
                ", Engine: " + engineCC + "cc" +
                ", Sidecar: " + hasSidecar +
                ", Type: " + type +
                "}";
    }
}