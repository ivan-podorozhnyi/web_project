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
    }

    @Override
    public void editOrder(int clientId, List<String> products) {
        boolean result = orderDao.editOrder(clientId, products);
        if (result) {
            System.out.println("Order was edited");
        }
    }

    public void removeOrder(int orderId) {
        boolean result = orderDao.removeOrder(orderId);
        if (result) {
            System.out.println("Product was removed");
        }
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.getAllOrders();
    }
}
