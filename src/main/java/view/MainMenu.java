package view;

import exceptions.BusinessException;

import java.io.BufferedReader;
import java.io.IOException;

public class MainMenu {

    private final BufferedReader reader;
    private final AdminMenu adminMenu;
    private final ClientMenu clientMenu;

    public MainMenu(BufferedReader reader, AdminMenu adminMenu, ClientMenu clientMenu) {
        this.reader = reader;
        this.adminMenu = adminMenu;
        this.clientMenu = clientMenu;
    }

    public void showMenu() throws IOException, BusinessException {
        boolean isRunning = true;
        while (isRunning) {
            showGreetingMenu();

            switch (reader.readLine()) {
                case "1": {
                    System.out.println("Welcome to admin menu");
                    adminMenu.showMenu();
                    break;
                }
                case "2": {
                    System.out.println("Welcome to user menu");
                    try {
                        clientMenu.showMenu();
                    } catch (BusinessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "E": {
                    System.out.println("Good bye!");
                    isRunning = false;
                    break;
                }
                default: {
                    System.out.println("Wrong input");
                }
            }
        }
    }

    private void showGreetingMenu() {
        System.out.println("Greetings! Please choose your menu:");
        System.out.println("1. Admin menu");
        System.out.println("2. Client menu");
        System.out.println("E. Exit");
    }
}
