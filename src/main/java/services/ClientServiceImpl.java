package services;

import domain.Order;
import domain.Product;

public class ClientServiceImpl implements ClientService {

    @Override
    public void addOrder() {
        Order order = new Order();
        System.out.println("New order was created");
    }

    @Override
    public void editOrder(Order order) {
        System.out.println("Order was updated");
    }

    @Override
    public void removeOrder(Order order) {
        order = null;
        System.out.println("Order was removed");
    }

    @Override
    public void addProduct() {
        Product order = new Product();
        System.out.println("New product was created");
    }

    @Override
    public void removeProduct(Product product) {
        product = null;
        System.out.println("Order was removed");
    }
}
