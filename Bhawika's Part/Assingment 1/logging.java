import java.util.Scanner;

public class logging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Preset correct credentials
        String correctUserId = "admin";
        String correctPassword = "password123";

        // Input User ID and Password
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Validate credentials
        if (userId.equals(correctUserId) && password.equals(correctPassword)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid User ID or Password!");
        }

        sc.close();
    }
}

/*
Output:
Enter User ID: admin
Enter Password: password123
Login Successful!
*/

