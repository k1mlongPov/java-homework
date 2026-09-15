package MVC;

import java.util.List;

public class ProductController {
    private ProductRepository  repository = new ProductRepository();
    private ProductView view = new ProductView();

    public void createCtrl() {
       String name = ProductView.inputString("Name");
        while (name == null || name.isEmpty()) {
            view.errorMessage("Name field is required!");
            name = ProductView.inputString("Re-enter name");
        }

        String desc =  ProductView.inputString("Description");
        while(desc == null || desc.isEmpty()) {
            view.errorMessage("Description field is required!");
            desc = ProductView.inputString("Re-enter description");
        }
        int qty = ProductView.inputInteger("Quantity");
        while(qty < 0) {
            view.errorMessage("Quantity of product can not be lower than 0!");
            qty = ProductView.inputInteger("Re-enter quantity");
        }
        double price = ProductView.inputDouble("Price");
        while(price < 0.00) {
            view.errorMessage("Price of the product can not be lower than 0.00$ !");
            price = ProductView.inputDouble("Re-enter price");
        }

        repository.create(name, desc, qty, price);
    }

    public void getByIdCtrl() {
        int searchId = ProductView.inputInteger("Enter product id");

        ProductModel product = repository.getById(searchId);

        view.displayProductDetails(product);

        if(product.getId() != searchId) {
            view.errorMessage("Product not found!");
        }
    }

    public void getAllCtrl() {
        List<ProductModel> products = repository.getAllProducts();
        view.displayProducts(products);
    }

    public void updateCtrl () {
        int searchId = ProductView.inputInteger("Enter product id");

        ProductModel product = repository.getById(searchId);

        if(product.getId() != searchId) {
            view.errorMessage("Product not found!");
        }
        String name = ProductView.inputString("Name");
        while(name == null || name.isEmpty() || product.getName().contains(name)) {
            if(name == null || name.isEmpty()){
                view.errorMessage("Name field is required!");
            }

            if(product.getName().contains(name)) {
                view.errorMessage("Product name already existed!");
            }
            name = ProductView.inputString("Name");
        }
        String desc =  ProductView.inputString("Description");
        while(desc == null || desc.isEmpty()) {
            view.errorMessage("Description field is required!");
            desc = ProductView.inputString("Description");
        }
        int qty = ProductView.inputInteger("Quantity");
        while(qty < 0) {
            view.errorMessage("Quantity of product can not be lower than 0!");
            qty = ProductView.inputInteger("Quantity");
        }
        double price = ProductView.inputDouble("Price");
        while(price < 0.00) {
            view.errorMessage("Price of the product can not be lower than 0.00$ !");
            price = ProductView.inputDouble("Price");
        }

       boolean success = repository.update(searchId,name, desc, qty, price);
        if(success) {
            view.displayMessage("Product updated successfully.");
        }else {
            view.errorMessage("Failed to update the product!");
        }
    }

    public void deleteCtrl () {
        int searchId = ProductView.inputInteger("Enter product id");

        ProductModel product = repository.getById(searchId);

        if(product.getId() != searchId) {
            view.errorMessage("Product not found!");
        }

        boolean success = repository.delete(searchId);
        if(success) {
            view.displayMessage("Product deleted successfully.");
        }else {
            view.errorMessage("Failed to delete the product!");
        }
    }

}
