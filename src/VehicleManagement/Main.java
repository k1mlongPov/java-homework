import VehicleManagement.Bike;
import VehicleManagement.Car;
import VehicleManagement.Motorcycle;

void main() {
    Scanner scan = new Scanner(System.in);

    System.out.println("""
                
                =========================
                  VEHICLE MANAGEMENT
                =========================
                1. Add Car
                2. Add Motorcycle
                3. Add Bike
                """);

    System.out.print("Choose a vehicle: ");
    int choice = scan.nextInt();
    scan.nextLine(); // clear buffer

    try {

        switch (choice) {

            case 1 -> {

                System.out.print("Brand: ");
                String brand = scan.nextLine();

                System.out.print("Model: ");
                String model = scan.nextLine();

                System.out.print("Year: ");
                int year = scan.nextInt();
                scan.nextLine();

                System.out.print("Color: ");
                String color = scan.nextLine();

                System.out.print("Price: ");
                double price = scan.nextDouble();

                System.out.print("Number of doors: ");
                int doors = scan.nextInt();
                scan.nextLine();

                System.out.print("Fuel type: ");
                String fuelType = scan.nextLine();

                System.out.print("Transmission: ");
                String transmission = scan.nextLine();

                Car car = new Car(
                        brand,
                        model,
                        year,
                        color,
                        price,
                        doors,
                        fuelType,
                        transmission
                );

                ObjectOutputStream output =
                        new ObjectOutputStream(
                                new FileOutputStream("cars.bin")
                        );

                output.writeObject(car);
                output.close();

                System.out.println("Car saved successfully!");
            }

            case 2 -> {

                System.out.print("Brand: ");
                String brand = scan.nextLine();

                System.out.print("Model: ");
                String model = scan.nextLine();

                System.out.print("Year: ");
                int year = scan.nextInt();
                scan.nextLine();

                System.out.print("Color: ");
                String color = scan.nextLine();

                System.out.print("Price: ");
                double price = scan.nextDouble();

                System.out.print("Engine CC: ");
                int engineCC = scan.nextInt();

                System.out.print("Has sidecar? (true/false): ");
                boolean hasSidecar = scan.nextBoolean();
                scan.nextLine();

                System.out.print("Type: ");
                String type = scan.nextLine();

                Motorcycle motorcycle = new Motorcycle(
                        brand,
                        model,
                        year,
                        color,
                        price,
                        engineCC,
                        hasSidecar,
                        type
                );

                ObjectOutputStream output =
                        new ObjectOutputStream(
                                new FileOutputStream("motorcycles.bin")
                        );

                output.writeObject(motorcycle);
                output.close();

                System.out.println("Motorcycle saved successfully!");
            }

            case 3 -> {

                System.out.print("Brand: ");
                String brand = scan.nextLine();

                System.out.print("Model: ");
                String model = scan.nextLine();

                System.out.print("Year: ");
                int year = scan.nextInt();
                scan.nextLine();

                System.out.print("Color: ");
                String color = scan.nextLine();

                System.out.print("Price: ");
                double price = scan.nextDouble();
                scan.nextLine();

                System.out.print("Bike type: ");
                String bikeType = scan.nextLine();

                System.out.print("Gear count: ");
                int gearCount = scan.nextInt();
                scan.nextLine();

                System.out.print("Frame material: ");
                String frameMaterial = scan.nextLine();

                Bike bike = new Bike(
                        brand,
                        model,
                        year,
                        color,
                        price,
                        bikeType,
                        gearCount,
                        frameMaterial
                );

                ObjectOutputStream output =
                        new ObjectOutputStream(
                                new FileOutputStream("bikes.bin")
                        );

                output.writeObject(bike);
                output.close();

                System.out.println("Bike saved successfully!");
            }

            default -> System.out.println("Invalid choice!");

        }

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

    scan.close();
}