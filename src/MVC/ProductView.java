package MVC;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static Scanner scanner = new Scanner(System.in);

   private static String inputFormat = "[+] %-16S : ";

    public int showMenuAndGetChoice() {
        System.out.println("""
         <=== | Managing Product Menu | ===>
                1. Add Product
                2. Search Product
                3. View all Products
                4. Update Product
                5. Delete Product
                6. Exit the Program
         |==================================|
                """);
        return inputInteger("Please choose one option");

    }

    public static String inputString(String prompt) {
        System.out.printf(inputFormat, prompt);
        String value = scanner.nextLine();
        return value;
    }

    public static double inputDouble(String prompt) {
        System.out.printf(inputFormat, prompt);
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public static int inputInteger(String prompt) {
        System.out.printf(inputFormat, prompt);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public void displayProducts(List<ProductModel> products) {
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("\n--- Product List ---");
        for (ProductModel p : products) {
            System.out.println("ID: "+ p.getId() + ", Name: " + p.getName() + ", Description: "+ p.getDesc()+", Quantity: " + p.getQty() + ", Price: $" + p.getPrice());
        }
    }

    public void displayProductDetails(ProductModel p) {
        if (p != null) {
            System.out.println("\nProduct Found -> ID: " + p.getId() + ", Name: " + p.getName() + ", Description: "+ p.getDesc()+", Quantity: " + p.getQty() + ", Price: $" + p.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
    public void errorMessage(String message) {
        System.err.println(message);
    }
}
