import dao.ClientDao;
import dao.jdbc.ClientJDBCDao;
import dao.jdbc.OrderJDBCDao;
import dao.jdbc.ProductJDBCDao;
import dao.OrderDao;
import dao.ProductDao;
import exceptions.BusinessException;
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
    public static void main(String[] args) throws IOException, BusinessException {

        ClientDao clientDao = new ClientJDBCDao();
        ProductDao productDao = new ProductJDBCDao();
        OrderDao orderDao = new OrderJDBCDao();

        ClientService clientService = new ClientServiceImpl(clientDao);
        OrderService orderService = new OrderServiceImpl(orderDao, productDao);
        ProductService productService = new ProductServiceImpl(productDao);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AdminMenu adminMenu = new AdminMenu(br, clientService, orderService, productService);
        ClientMenu clientMenu = new ClientMenu(br, clientService, orderService, productService);

        MainMenu mainMenu = new MainMenu(br, adminMenu, clientMenu);
        mainMenu.showMenu();
    }
}


