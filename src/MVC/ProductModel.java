package MVC;

public class ProductModel {
    private int id;
    private String name;
    private String desc;
    private int qty;
    private double price;

    public ProductModel(int id, String name, String desc, int qty, double price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
