import VehicleManagement.Bike;
import VehicleManagement.Car;
import VehicleManagement.Motorcycle;

Scanner scan = new Scanner(System.in);

void main() {

    while (true) {

        System.out.println("""
                
                ==============================
                    VEHICLE MANAGEMENT
                ==============================
                1. Add
                2. Display
                3. Update
                4. Delete
                5. Exit
                ==============================
                """);

        System.out.print("Choose an option: ");
        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {

            case 1 -> add();

            case 2 -> display();

            case 3 -> update();

            case 4 -> delete();

            case 5 -> {
                System.out.println("Exiting the program!");
                return;
            }

            default -> System.out.println("Invalid choice!");
        }
    }
}


// ADD
void add() {

    System.out.println("""
            
            =================
                    ADD
            =================
            1. Car
            2. Motorcycle
            3. Bike
            """);

    System.out.print("Choose vehicle: ");
    int choice = scan.nextInt();
    scan.nextLine();

    switch (choice) {

        case 1 -> addCar();

        case 2 -> addMotorcycle();

        case 3 -> addBike();

        default -> System.out.println("Invalid choice!");
    }
}


void addCar() {

    System.out.println("\n--- Add Car ---");

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

    saveCar(car);

    System.out.println("Car added successfully!");
}


void addMotorcycle() {

    System.out.println("\n--- Add Motorcycle ---");

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

    saveMotorcycle(motorcycle);

    System.out.println("Motorcycle added successfully!");
}


void addBike() {

    System.out.println("\n--- Add Bike ---");

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

    saveBike(bike);

    System.out.println("Bike added successfully!");
}


// DISPLAY
void display() {

    System.out.println("""
            
            =================
                  DISPLAY
            =================
            1. Car
            2. Motorcycle
            3. Bike
            """);

    System.out.print("Choose vehicle: ");
    int choice = scan.nextInt();
    scan.nextLine();

    switch (choice) {

        case 1 -> displayCars();

        case 2 -> displayMotorcycles();

        case 3 -> displayBikes();

        default -> System.out.println("Invalid choice!");
    }
}


void displayCars() {

    Car[] cars = readCars();

    System.out.println("\n========== CARS ==========");

    if (cars == null) {
        System.out.println("No cars found.");
        return;
    }

    for (int i = 0; i < cars.length; i++) {
        System.out.println("[" + i + "] " + cars[i]);
    }
}


void displayMotorcycles() {

    Motorcycle[] motorcycles = readMotorcycles();

    System.out.println("\n====== MOTORCYCLES ======");

    if (motorcycles == null) {
        System.out.println("No motorcycles found.");
        return;
    }

    for (int i = 0; i < motorcycles.length; i++) {
        System.out.println("[" + i + "] " + motorcycles[i]);
    }
}


void displayBikes() {

    Bike[] bikes = readBikes();

    System.out.println("\n========== BIKES ==========");

    if (bikes == null) {
        System.out.println("No bikes found.");
        return;
    }

    for (int i = 0; i < bikes.length; i++) {
        System.out.println("[" + i + "] " + bikes[i]);
    }
}


// UPDATE

void update() {

    System.out.println("""
            
            =================
                  UPDATE
            =================
            1. Car
            2. Motorcycle
            3. Bike
            """);

    System.out.print("Choose vehicle: ");
    int choice = scan.nextInt();
    scan.nextLine();

    switch (choice) {

        case 1 -> updateCar();

        case 2 -> updateMotorcycle();

        case 3 -> updateBike();

        default -> System.out.println("Invalid choice!");
    }
}


void updateCar() {

    Car[] cars = readCars();

    if (cars == null) {
        System.out.println("No cars found.");
        return;
    }

    displayCars();

    System.out.print("\nEnter car index to update: ");
    int index = scan.nextInt();
    scan.nextLine();

    if (index < 0 || index >= cars.length) {
        System.out.println("Invalid index!");
        return;
    }

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

    cars[index] = new Car(
            brand,
            model,
            year,
            color,
            price,
            doors,
            fuelType,
            transmission
    );

    writeCars(cars);

    System.out.println("Car updated successfully!");
}


void updateMotorcycle() {

    Motorcycle[] motorcycles = readMotorcycles();

    if (motorcycles == null) {
        System.out.println("No motorcycles found.");
        return;
    }

    displayMotorcycles();

    System.out.print("\nEnter motorcycle index to update: ");
    int index = scan.nextInt();
    scan.nextLine();

    if (index < 0 || index >= motorcycles.length) {
        System.out.println("Invalid index!");
        return;
    }

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

    motorcycles[index] = new Motorcycle(
            brand,
            model,
            year,
            color,
            price,
            engineCC,
            hasSidecar,
            type
    );

    writeMotorcycles(motorcycles);

    System.out.println("Motorcycle updated successfully!");
}


void updateBike() {

    Bike[] bikes = readBikes();

    if (bikes == null) {
        System.out.println("No bikes found.");
        return;
    }

    displayBikes();

    System.out.print("\nEnter bike index to update: ");
    int index = scan.nextInt();
    scan.nextLine();

    if (index < 0 || index >= bikes.length) {
        System.out.println("Invalid index!");
        return;
    }

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

    bikes[index] = new Bike(
            brand,
            model,
            year,
            color,
            price,
            bikeType,
            gearCount,
            frameMaterial
    );

    writeBikes(bikes);

    System.out.println("Bike updated successfully!");
}


// DELETE

void delete() {

    System.out.println("""
            
            =================
                  DELETE
            =================
            1. Car
            2. Motorcycle
            3. Bike
            """);

    System.out.print("Choose vehicle: ");
    int choice = scan.nextInt();
    scan.nextLine();

    switch (choice) {

        case 1 -> deleteCar();

        case 2 -> deleteMotorcycle();

        case 3 -> deleteBike();

        default -> System.out.println("Invalid choice!");
    }
}


void deleteCar() {

    Car[] cars = readCars();

    if (cars == null) {
        System.out.println("No cars found.");
        return;
    }

    displayCars();

    System.out.print("\nEnter car index to delete: ");
    int index = scan.nextInt();

    if (index < 0 || index >= cars.length) {
        System.out.println("Invalid index!");
        return;
    }

    Car[] newCars = new Car[cars.length - 1];

    for (int i = 0, j = 0; i < cars.length; i++) {

        if (i != index) {
            newCars[j] = cars[i];
            j++;
        }
    }

    writeCars(newCars);

    System.out.println("Car deleted successfully!");
}


void deleteMotorcycle() {

    Motorcycle[] motorcycles = readMotorcycles();

    if (motorcycles == null) {
        System.out.println("No motorcycles found.");
        return;
    }

    displayMotorcycles();

    System.out.print("\nEnter motorcycle index to delete: ");
    int index = scan.nextInt();

    if (index < 0 || index >= motorcycles.length) {
        System.out.println("Invalid index!");
        return;
    }

    Motorcycle[] newMotorcycles =
            new Motorcycle[motorcycles.length - 1];

    for (int i = 0, j = 0; i < motorcycles.length; i++) {

        if (i != index) {
            newMotorcycles[j] = motorcycles[i];
            j++;
        }
    }

    writeMotorcycles(newMotorcycles);

    System.out.println("Motorcycle deleted successfully!");
}


void deleteBike() {

    Bike[] bikes = readBikes();

    if (bikes == null) {
        System.out.println("No bikes found.");
        return;
    }

    displayBikes();

    System.out.print("\nEnter bike index to delete: ");
    int index = scan.nextInt();

    if (index < 0 || index >= bikes.length) {
        System.out.println("Invalid index!");
        return;
    }

    Bike[] newBikes = new Bike[bikes.length - 1];

    for (int i = 0, j = 0; i < bikes.length; i++) {

        if (i != index) {
            newBikes[j] = bikes[i];
            j++;
        }
    }

    writeBikes(newBikes);

    System.out.println("Bike deleted successfully!");
}


// FILE

void saveCar(Car car) {

    Car[] cars = readCars();

    if (cars == null) {
        cars = new Car[1];
    } else {

        Car[] newCars = new Car[cars.length + 1];

        for (int i = 0; i < cars.length; i++) {
            newCars[i] = cars[i];
        }

        cars = newCars;
        cars[cars.length - 1] = car;

        writeCars(cars);
        return;
    }

    cars[0] = car;

    writeCars(cars);
}


void saveMotorcycle(Motorcycle motorcycle) {

    Motorcycle[] motorcycles = readMotorcycles();

    if (motorcycles == null) {
        motorcycles = new Motorcycle[1];
    } else {

        Motorcycle[] newMotorcycles = new Motorcycle[motorcycles.length + 1];

        for (int i = 0; i < motorcycles.length; i++) {
            newMotorcycles[i] = motorcycles[i];
        }

        motorcycles = newMotorcycles;
        motorcycles[motorcycles.length - 1] = motorcycle;

        writeMotorcycles(motorcycles);
        return;
    }

    motorcycles[0] = motorcycle;

    writeMotorcycles(motorcycles);
}


void saveBike(Bike bike) {

    Bike[] bikes = readBikes();

    if (bikes == null) {
        bikes = new Bike[1];
    } else {
        Bike[] newBikes = new Bike[bikes.length + 1];

        for (int i = 0; i < bikes.length; i++) {
            newBikes[i] = bikes[i];
        }

        bikes = newBikes;
        bikes[bikes.length - 1] = bike;

        writeBikes(bikes);
        return;
    }
    bikes[0] = bike;
    writeBikes(bikes);
}


Car[] readCars() {
    try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("cars.bin"))) {
        return (Car[]) input.readObject();
    } catch (Exception e) {
        return null;
    }
}


Motorcycle[] readMotorcycles() {
    try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("motorcycles.bin"))) {
        return (Motorcycle[]) input.readObject();
    } catch (Exception e) {
        return null;
    }
}


Bike[] readBikes() {
    try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("bikes.bin"))) {
        return (Bike[]) input.readObject();
    } catch (Exception e) {
        return null;
    }
}


void writeCars(Car[] cars) {
    try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("cars.bin"))) {
        output.writeObject(cars);
    } catch (IOException e) {
        System.out.println("Error writing cars file.");
    }
}


void writeMotorcycles(Motorcycle[] motorcycles) {
    try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("motorcycles.bin"))) {
        output.writeObject(motorcycles);
    } catch (IOException e) {
        System.out.println("Error writing motorcycles file.");
    }
}


void writeBikes(Bike[] bikes) {
    try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("bikes.bin"))) {
        output.writeObject(bikes);
    } catch (IOException e) {
        System.out.println("Error writing bikes file.");
    }
}