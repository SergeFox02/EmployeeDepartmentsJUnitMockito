package pro.sky.homeworkemployeespringexception.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkemployeespringexception.data.Cart;

import java.util.List;

@Service
public class OrderServiceImpl implements StoreService{

    private final Cart cart;

    public OrderServiceImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public List<String> addProduct(List<Integer> idItems) {
        return cart.addItems(idItems);
    }

    @Override
    public List<String> getCart() {
        return cart.getItems();
    }
}
