
// LoginSystem.java
import java.util.Scanner;

// Class containing the login validation method
class Login {

    // Method to check credentials
    public boolean checkCredentials(String user, String pass) {
        if (user.equals("MRC") && pass.equals("2007")) {
            return true;
        } else {
            return false;
        }
    }
}

// Main class
public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating object of Login class
        Login log = new Login();

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Calling the method using the object
        if (log.checkCredentials(userId, password)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid User ID or Password!");
        }

        sc.close();
    }
}
