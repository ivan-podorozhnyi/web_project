import services.ClientService;
import services.OrderService;
import services.ProductService;
import services.impl.ClientServiceImpl;
import services.impl.OrderServiceImpl;
import services.impl.ProductServiceImpl;
import view.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    public static void main(String[] args) throws IOException {
        ClientService clientService = new ClientServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        ProductService productService = new ProductServiceImpl();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AdminMenu adminMenu = new AdminMenu(br, clientService, orderService, productService);
        ClientMenu clientMenu = new ClientMenu(br, clientService, orderService, productService);

        MainMenu mainMenu = new MainMenu(br, adminMenu, clientMenu);
        mainMenu.showMenu();
    }
}


