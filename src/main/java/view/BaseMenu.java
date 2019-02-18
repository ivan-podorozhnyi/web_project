package view;

import services.ClientService;
import services.OrderService;
import services.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BaseMenu {
    final BufferedReader reader;
    final ClientService clientService;
    final OrderService orderService;
    final ProductService productService;

    public BaseMenu(BufferedReader reader, ClientService clientService, OrderService orderService, ProductService productService) {
        this.reader = reader;
        this.clientService = clientService;
        this.orderService = orderService;
        this.productService = productService;
    }

    int readInteger() {
        try {
            return Integer.valueOf(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Please input number!");
            return readInteger();
        }
    }

    List<String> readStringsList() {
        try {
            return Arrays.asList(reader.readLine().split("\\s*,\\s*"));
        } catch (IOException e) {
            System.out.println("PLease input comma separated values");
            return readStringsList();
        }
    }

    void createClient() throws IOException {
        System.out.println();
        System.out.println("Please input name");
        String name = reader.readLine();
        System.out.println("Please input last name");
        String lastName = reader.readLine();
        System.out.println("Please input phone number");
        String phone = reader.readLine();
        System.out.println("PLease input age");
        int age = readInteger();
        System.out.println("Please input email");
        String email = reader.readLine();
        clientService.createClient(name, lastName, phone, age, email);
    }

    void editClient() throws IOException {
        System.out.println();
        System.out.println("Please input your id");
        int id = readInteger();
        System.out.println("Please input new name");
        String name = reader.readLine();
        System.out.println("Please input new last name");
        String lastName = reader.readLine();
        System.out.println("Please input new phone number");
        String phone = reader.readLine();
        System.out.println("PLease input new age");
        int age = readInteger();
        System.out.println("Please input new email");
        String email = reader.readLine();
        clientService.editClient(id, name, lastName, phone, age, email);
    }

    void removeClient() {
        System.out.println();
        System.out.println("Please input id of your client");
        int id = readInteger();
        clientService.removeClient(id);
    }

    void showAllClients() {
        clientService.getAllClients().forEach(System.out::println);
    }

    void createProduct() throws IOException {
        System.out.println();
        System.out.println("Please input product name");
        String name = reader.readLine();
        System.out.println("Please input product price");
        int price = readInteger();
        productService.createProduct(name, price);
    }

    void editProduct() throws IOException {
        System.out.println();
        System.out.println("Please input product name to edit");
        String name = reader.readLine();
        System.out.println("Please input new product price");
        int price = readInteger();
        productService.editProduct(name, price);
    }

    void removeProduct() throws IOException {
        System.out.println();
        System.out.println("Please input name of product you want to remove");
        String name = reader.readLine();
        productService.removeProduct(name);
    }

    void showAllProducts() {
        productService.getAllProducts().forEach(System.out::println);
    }

    void createOrder() {
        System.out.println();
        System.out.println("Please input client's id");
        int clientsId = readInteger();
        System.out.println("Please input comma separated products you want to add to order");
        List<String> products = readStringsList();
        orderService.createOrder(clientsId, products);
    }

    void editOrder() {
        System.out.println();
        System.out.println("Please input product name to edit");
        int id = readInteger();
        System.out.println("Please input new product price");
        List<String> products = readStringsList();
        orderService.editOrder(id, products);
    }

    void removeOrder() throws IOException {
        System.out.println();
        System.out.println("Please input name of product you want to remove");
        String name = reader.readLine();
        productService.removeProduct(name);
    }

    void showAllOrders() {
        productService.getAllProducts().forEach(System.out::println);
    }

    void exitApp() {
        System.out.println();
        System.out.println("Good bye!");
        System.exit(0);
    }

}
