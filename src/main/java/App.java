import dao.ClientDao;
import dao.Impl.ClientDBDao;
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


/*домашка
* добавить проверку существует ли клиент/това/ордер в базе при любой операции
*
* валидация номера телефона на существование
* проверять телефон сразу, а не после ввода всех аргументов
*
* переделать хранение ордеров и товаров на мэп
* переделать изменение клиента/итд по принципу сначала поиск если есть: а потом только ввод параметров
* вынести инпут в отдельный метод
*
* */


public class App {
    public static void main(String[] args) throws IOException {

        ClientDao clientDao = new ClientDBDao();
        ClientService clientService = new ClientServiceImpl(clientDao);
        OrderService orderService = new OrderServiceImpl();
        ProductService productService = new ProductServiceImpl();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AdminMenu adminMenu = new AdminMenu(br, clientService, orderService, productService);
        ClientMenu clientMenu = new ClientMenu(br, clientService, orderService, productService);

        MainMenu mainMenu = new MainMenu(br, adminMenu, clientMenu);
        mainMenu.showMenu();
    }
}


