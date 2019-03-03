package view;

import exceptions.BusinessException;
import services.ClientService;
import services.OrderService;
import services.ProductService;

import java.io.BufferedReader;
import java.io.IOException;


public class ClientMenu extends BaseMenu {

    public ClientMenu(BufferedReader reader, ClientService clientService, OrderService orderService, ProductService productService) {
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
                    createOrder();
                    break;
                }
                case "3": {
                    editOrder();
                    break;
                }
                case "4": {
                    removeOrder();
                    break;
                }
                case "5": {
                    showClientOrders();
                    break;
                }
                case "6": {
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

    private void showClientOrders() {
        orderService.showAllOrders();
    }

    private void showGreetingMenu() {
        System.out.println();
        System.out.println("Please choose action:");
        System.out.println("1. Create client");
        System.out.println("2. Create order");
        System.out.println("3. Edit order");
        System.out.println("4. Remove order");
        System.out.println("5. Show client's orders");
        System.out.println("6. Show all products");
        System.out.println("R. Return to previous menu");
        System.out.println("E. Exit");
    }
}
