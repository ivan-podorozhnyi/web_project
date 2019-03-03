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
     * @param productId id of the product to edit.
     * @param newName   new name of the product.
     * @param newPrice  new price of the product.
     */
    void editProduct(int productId, String newName, int newPrice);

    /**
     * Remove Product.
     *
     * @param productId id of the Product to be removed.
     */
    void removeProduct(int productId);

    /**
     * Show list of all existing products.
     */
    List<Product> getAllProducts();
}
