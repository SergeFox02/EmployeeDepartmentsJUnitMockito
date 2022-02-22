package pro.sky.homeworkemployeespringexception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homeworkemployeespringexception.data.Products;
import pro.sky.homeworkemployeespringexception.service.StoreService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/store/order")
public class StoreController {

    private final StoreService storeService;
    private final Products products = new Products();

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public Map<Integer, String> getProductsInStore(){
        return products.getProducts();
    }

    @GetMapping(path = "/add")
    public List<String> addProducts(@RequestParam List<Integer> idItems) {
        return storeService.addProduct(idItems);
    }

    @GetMapping(path = "/get")
    public List<String> getProductsInStoreCart() {
        return storeService.getCart();
    }
}
