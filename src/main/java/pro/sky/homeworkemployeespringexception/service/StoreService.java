package pro.sky.homeworkemployeespringexception.service;

import java.util.List;

public interface StoreService {

    List<String> addProduct(List<Integer> idItems);
    List<String> getCart();
}
