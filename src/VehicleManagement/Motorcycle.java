package VehicleManagement;

public class Motorcycle extends Vehicle {
    private int engineCC;
    private boolean hasSidecar;
    private String type;

    public Motorcycle(String brand, String model, int year, String color, double price,
                      int engineCC, boolean hasSidecar, String type) {

        super(brand, model, year, color, price);

        this.engineCC = engineCC;
        this.hasSidecar = hasSidecar;
        this.type = type;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Motorcycle {" +
                super.toString() +
                ", Engine: " + engineCC + "cc" +
                ", Sidecar: " + hasSidecar +
                ", Type: " + type +
                "}";
    }
}