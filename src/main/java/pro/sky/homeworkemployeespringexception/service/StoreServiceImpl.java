package pro.sky.homeworkemployeespringexception.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkemployeespringexception.data.ShoppingCart;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

    private ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    public List<String> addProduct(List<Integer> idItems) {
        return shoppingCart.addProductToShoppingCart(idItems);
    }

    @Override
    public List<String> getShoppingCart() {
        return shoppingCart.getShoppingCart();
    }
}
