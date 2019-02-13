package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminMenu {
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
                    System.out.println("User was removed");
                    break;
                }
                case "3": {
                    System.out.println("User was updated");
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
        System.out.println("2. Remove user");
        System.out.println("3. Update user");
        System.out.println("0. Exit");
    }
}
