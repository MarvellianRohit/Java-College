/*
 * Q5: Create a custom exception class named InvalidAgeException. Write a voting application that
 * prompts the user to enter their age. If the age is less than 18, explicitly throw the
 * InvalidAgeException with the message "Not eligible to vote". Otherwise, display "Welcome to
 * vote".
 */

import java.util.Scanner;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

public class Q5_CustomExceptionVoting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            if (age < 18) {
                throw new InvalidAgeException("Not eligible to vote");
            } else {
                System.out.println("Welcome to vote");
            }
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

/*
Output (Case 1 - Age < 18):
Enter your age: 16
Exception: Not eligible to vote

Output (Case 2 - Age >= 18):
Enter your age: 20
Welcome to vote
*/

