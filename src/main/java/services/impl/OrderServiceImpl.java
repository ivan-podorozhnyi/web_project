package services.impl;

import dao.ProductDao;
import dao.builtIn.OrderDaoImpl;
import dao.OrderDao;
import domain.Order;
import domain.Product;
import services.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private ProductDao productDao;

    public OrderServiceImpl() {
        this.orderDao = OrderDaoImpl.getInstance();
    }

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderServiceImpl(OrderDao orderDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
    }

    @Override
    public void createOrder(int clientId, List<Integer> productIdList) {
        List<Product> productsList = new ArrayList<>();
        for (Integer productId : productIdList) {
            Product product = productDao.getProduct(productId);
            productsList.add(product);
        }
        Order order = new Order(clientId, productsList);
        boolean result = orderDao.createOrder(order);
        if (result) {
            System.out.println("Order was created");
        }
        else {
            System.out.println(String.format("Could not create order with client id %d", clientId));
        }
    }

    @Override
    public void editOrder(int orderId, List<Integer> productIds) {
        boolean result = orderDao.editOrder(orderId, productIds);
        if (result) {
            System.out.println("Order was edited");
        }
        else {
            System.out.println(String.format("Could not update order with id %d", orderId));
        }
    }

    public void removeOrder(int orderId) {
        boolean result = orderDao.removeOrder(orderId);
        if (result) {
            System.out.println("Order was removed");
        }
        else {
            System.out.println(String.format("Could not remove order with id %d", orderId));
        }
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.getAllOrders();
    }
}
