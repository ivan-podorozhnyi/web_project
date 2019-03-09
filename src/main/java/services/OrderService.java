package services;

import domain.Order;

import java.util.List;

public interface OrderService {
    /**
     * Create Order instance.
     *
     * @param clientId      client id related to new order.
     * @param productIdList list of product ids in new order.
     */
    void createOrder(int clientId, List<Integer> productIdList);

    /**
     * Edit Order instance.
     *
     * @param clientId   client id related to order which will be edited.
     * @param productIds updated list of product ids in order.
     */
    void editOrder(int clientId, List<Integer> productIds);


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
