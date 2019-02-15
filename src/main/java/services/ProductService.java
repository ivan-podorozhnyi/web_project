package services;

import domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * Create Product instance.
     *
     * @param name  name of the product.
     * @param price price of the product.
     */
    void createProduct(String name, int price);

    /**
     * Edit Product instance.
     *
     * @param name     name of the product to edit.
     * @param newPrice new price of the product.
     */
    void editProduct(String name, int newPrice);

    /**
     * Remove Product.
     *
     * @param productName name of the Product to be removed.
     */
    void removeProduct(String productName);

    /**
     * Show list of all existing products.
     */
    List<Product> getAllProducts();
}
