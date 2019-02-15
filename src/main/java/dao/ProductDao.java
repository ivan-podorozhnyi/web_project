package dao;

import domain.Product;

import java.util.List;

public interface ProductDao {
    boolean createProduct(Product product);

    boolean editProduct(String name, int newPrice);

    boolean removeProduct(String productName);

    List<Product> getAllProducts();
}
