package services;

import domain.Client;
import domain.Order;
import domain.Product;

public class AdminServiceImpl implements AdminService {
    @Override
    public void createClient(String name, String lastName, String phone) {
        Client client = new Client(name, lastName, phone);
        System.out.println(String.format("Client %s %s was created", client.getName(), client.getLastName()));
    }

    @Override
    public void createClient(String name, String lastName, String phone, int age, String email) {
        Client client = new Client(name, lastName, age, email, phone);
        System.out.println(String.format("Client %s %s was created", client.getName(), client.getLastName()));
    }

    @Override
    public void editClient(Client client, String newName, String newLastName, String newPhone) {
        client.setName(newName);
        client.setLastName(newLastName);
        client.setPhone(newPhone);
        client.setName(newName);
        System.out.println("Client was updated");
    }

    @Override
    public void editClient(Client client, String newName, String newPhone, String newLastName, int newAge, String newEmail) {
        client.setName(newName);
        client.setLastName(newLastName);
        client.setPhone(newPhone);
        client.setAge(newAge);
        client.setEmail(newEmail);
        client.setName(newName);
        System.out.println("Client was updated");
    }

    @Override
    public void removeClient(Client client) {
        client = null;
        System.out.println("Order was removed");
    }

    @Override
    public void addOrder() {
        Order order = new Order();
        System.out.println("New order was created");
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
