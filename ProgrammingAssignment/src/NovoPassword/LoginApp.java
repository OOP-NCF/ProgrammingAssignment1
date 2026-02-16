package NovoPassword;

import java.util.Scanner;

public class LoginApp {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("============ LOGIN SYSTEM ============");
        System.out.println("Correct credentials: admin / java123");
        System.out.println("Account locks after 3 failed attempts");
        System.out.println("=====================================\n");

        User user = new User("", "");
        Account account = new Account();
        LoginManager loginManager = new LoginManager(user, account);

        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            if (loginManager.isAccountLocked()) {
                System.out.println("Account is locked. No more login attempts allowed.");
                break;
            }

            System.out.print("Enter username: ");
            String inputUsername = scnr.nextLine();

            System.out.print("Enter password: ");
            String inputPassword = scnr.nextLine();

            boolean credentialsValid = loginManager.validateCredentials(inputUsername, inputPassword);

            if (credentialsValid) {
                System.out.println("\nLogin successful! Access granted.");
                isLoggedIn = true;
            } else {
                System.out.println("Invalid credentials. Attempt " + loginManager.getFailedAttempts() + " of 3");
                System.out.println();
            }
        }

        scnr.close();
    }
}