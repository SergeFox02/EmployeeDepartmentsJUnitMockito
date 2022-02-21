package pro.sky.homeworkemployeespringexception.data;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;


@Component
@SessionScope
public class Cart {

    private List<String> shoppingCart;
    private final Products products = new Products();

    public Cart() {
        this.shoppingCart = new ArrayList<>();
    }

    public List<String> getItems() {
        return shoppingCart;
    }

    public List<String> addItems(List<Integer> idItems) {
        for (Integer idItem : idItems) {
            shoppingCart.add(products.getProduct(idItem));
        }
        return this.shoppingCart;
    }
}
