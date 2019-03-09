package dao;

import domain.Order;
import domain.Product;

import java.util.List;

public interface OrderDao {
    boolean createOrder(Order order);

    boolean editOrder(int orderId, List<Integer> productIdsList);

    boolean removeOrder(int orderId);

    List<Order> getAllOrders();
}
