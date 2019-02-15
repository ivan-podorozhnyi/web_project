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

/*Домашка

написать ряд валидаторов в частности
        1) правильность ввода имейла
        2) проверку на ввод телефона (только укр +38(050)777-22-22)
        потом вносить в клиент только цифры 0504523109 10 цифр и код оператора
        3) если у нас клиент или админ пробует добавить клиента с одинаковым телефоном
        */
public class app {
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


