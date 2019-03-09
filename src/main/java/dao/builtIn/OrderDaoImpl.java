package dao.builtIn;

import dao.OrderDao;
import domain.Order;
import domain.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private List<Order> ordersList = new ArrayList<>();
    private static int orderCounter = 0;
    private static OrderDao orderDao;

    private OrderDaoImpl() {
        if (orderDao != null) {
            orderDao = new OrderDaoImpl();
        }
    }

    public static OrderDao getInstance() {
        if (orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }

    @Override
    public boolean createOrder(Order order) {
        order.setId(orderCounter++);
        ordersList.add(order);
        return true;

    }

    @Override
    public boolean editOrder(int orderId, List<Integer> productsIdsList) {
        for (Order order : ordersList) {
            if (order.getId() == orderId) {
                List<Product> newProductsList = new ArrayList<>();
                for (Integer productId : productsIdsList) {
                    Product product = new Product(productId);
                    newProductsList.add(product);
                }
                order.setProducts(newProductsList);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeOrder(int orderId) {
        for (Order order : ordersList) {
            if (order.getId() == orderId) {
                ordersList.remove(order);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        return ordersList;
    }
}
