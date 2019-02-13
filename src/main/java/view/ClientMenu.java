package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientMenu {
    private final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public void showMenu() throws IOException {
        boolean isRunning = true;
        while (isRunning) {
            showGreetingMenu();

            switch (reader.readLine()) {
                case "1": {
                    System.out.println("New user was created");
                    break;
                }
                case "2": {
                    System.out.println("New order was created");
                    break;
                }
                case "3": {
                    System.out.println("New product was created");
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
        System.out.println("Please choose action:");
        System.out.println("1. Create user");
        System.out.println("2. Create order");
        System.out.println("3. Create product");
        System.out.println("0. Exit");
    }
}
