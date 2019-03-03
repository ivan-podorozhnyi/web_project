package dao;

import domain.Product;

import java.util.List;

public interface ProductDao {
    boolean createProduct(Product product);

    boolean editProduct(int productId, String newName, int newPrice);

    boolean removeProduct(int productId);

    List<Product> getAllProducts();

    Product getProduct(int productId);
}
