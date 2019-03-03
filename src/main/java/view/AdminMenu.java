package view;

import exceptions.BusinessException;
import services.ClientService;
import services.OrderService;
import services.ProductService;

import java.io.BufferedReader;
import java.io.IOException;

public class AdminMenu extends BaseMenu {

    public AdminMenu(BufferedReader reader, ClientService clientService, OrderService orderService, ProductService productService) {
        super(reader, clientService, orderService, productService);
    }

    void showMenu() throws IOException, BusinessException {
        boolean isRunning = true;
        while (isRunning) {
            showGreetingMenu();

            switch (reader.readLine()) {
                case "1": {
                    createClient();
                    break;
                }
                case "2": {
                    editClient();
                    break;
                }
                case "3": {
                    removeClient();
                    break;
                }
                case "4": {
                    showAllClients();
                    break;
                }
                case "5": {
                    createOrder();
                    break;
                }
                case "6": {
                    editOrder();
                    break;
                }
                case "7": {
                    removeOrder();
                    break;
                }
                case "8": {
                    showAllOrders();
                    break;
                }
                case "9": {
                    createProduct();
                    break;
                }
                case "10": {
                    editProduct();
                    break;
                }
                case "11": {
                    removeProduct();
                }
                case "12": {
                    showAllProducts();
                    break;
                }
                case "R": {
                    isRunning = false;
                    break;
                }
                case "E": {
                    exitApp();
                }
                default: {
                    System.out.println("Wrong input");
                }
            }
        }
    }

    private void showGreetingMenu() {
        System.out.println();
        System.out.println("Please choose action:");
        System.out.println("1. Create client");
        System.out.println("2. Edit client");
        System.out.println("3. Remove client");
        System.out.println("4. Show all clients");
        System.out.println("5. Create order");
        System.out.println("6. Edit order");
        System.out.println("7. Remove order");
        System.out.println("8. Show all orders");
        System.out.println("9. Create product");
        System.out.println("10. Edit product");
        System.out.println("11. Remove product");
        System.out.println("12. Show all available products");
        System.out.println("R. Return to previous menu");
        System.out.println("E. Exit");
    }

    int readInteger() {
        try {
            return Integer.valueOf(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Please input a number!");
            return readInteger();
        }
    }
}
