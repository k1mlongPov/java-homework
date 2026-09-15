package MVC;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<ProductModel> products = new ArrayList<>();
    int id = 1;

    public void create(String name, String desc, int qty, double price) {
        products.add(new ProductModel(id, name, desc, qty, price));
        id++;
    }

    public List<ProductModel> getAllProducts () {
        return products;
    }

    public ProductModel getById(int id) {
       return  products.stream().filter(productModel -> productModel.getId() == id).findFirst().orElse(null);
    }

    public boolean update(int searchId, String name, String desc, int qty, double price) {
        ProductModel product = getById(searchId);

        if(product == null) {
            return false;
        }

        product.setName(name);
        product.setDesc(desc);
        product.setQty(qty);
        product.setPrice(price);

        return true;
    }

    public boolean delete(int id) {
        ProductModel product = getById(id);
        if(product == null) {
            return false;
        }

        products.remove(product);
        return true;
    }
}
