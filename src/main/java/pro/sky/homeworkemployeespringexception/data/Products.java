package pro.sky.homeworkemployeespringexception.data;

import java.util.HashMap;
import java.util.Map;

public class Products {

    private final Map<Integer, String> products = new HashMap<>();

    public Products() {
        this.products.put(1, "Milk");
        this.products.put(2, "Breath");
        this.products.put(3, "Egg");
        this.products.put(4, "Apple");
        this.products.put(5, "Water");
    }

    public String getProduct(int id) {
        return products.get(id);
    }

    public Map<Integer, String> getProducts() {
        return products;
    }
}
