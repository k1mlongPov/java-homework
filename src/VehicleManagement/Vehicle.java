package VehicleManagement;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;

    public Vehicle(String brand, String model, int year,
                   String color, double price) {

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getVehicleType();

    public abstract String getDescription();

    @Override
    public String toString() {
        return "Brand: " + brand +
                ", Model: " + model +
                ", Year: " + year +
                ", Color: " + color +
                ", Price: $" + price;
    }
}