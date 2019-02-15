package services;

import domain.Client;
import domain.Order;
import domain.Product;

import java.util.List;

public interface OrderService {
    /**
     * Create Order instance.
     *
     * @param clientId client id related to new order.
     * @param products list of products in new order.
     */
    void createOrder(int clientId, List<String> products);

    /**
     * Edit Order instance.
     *
     * @param clientId client id related to order which will be edited.
     * @param products updated list of products in order.
     */
    void editOrder(int clientId, List<String> products);


    /**
     * Remove Order.
     *
     * @param orderId id of order to be removed.
     */
    void removeOrder(int orderId);

    /**
     * Show list of all existing orders.
     */
    List<Order> showAllOrders();
}
