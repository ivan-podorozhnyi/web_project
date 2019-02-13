package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

    private final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private final AdminMenu adminMenu = new AdminMenu();
    private final ClientMenu clientMenu = new ClientMenu();

    public void showMenu() throws IOException {
        boolean isRunning = true;
        while (isRunning) {
            showGreetingMenu();

            switch (reader.readLine()) {
                case "1": {
                    System.out.println("Welcome to admin menu");
                    break;
                }
                case "2": {
                    System.out.println("Welcome to user menu");
                    break;
                }
                case "0": {
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
        System.out.println("0. Exit");
    }
}
