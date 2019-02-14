package services;

import domain.Order;
import domain.Product;

public interface ClientService {

    /**
     * Create Order instance.
     */
    void addOrder();

    /**
     * Update Order.
     *
     * @param order    Order to be updated.
     */
    void editOrder(Order order);

    /**
     * Remove Order.
     *
     * @param order    Order instance to be removed.
     */
    void removeOrder(Order order);

    /**
     * Create Product instance.
     */
    void addProduct();

    /**
     * Remove Product.
     *
     * @param product    Product instance to be removed.
     */
    void removeProduct(Product product);
}
