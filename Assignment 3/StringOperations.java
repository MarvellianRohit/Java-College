/*
 * Question 1: Write a java program to implement the following operations: 
 * (take user input and use switch case) - String reverse, substring, 
 * calculate string length, and fetch character at 5, search string using index of.
 */

import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputStr = scanner.nextLine();

        while (true) {
            System.out.println("\n--- STRING OPERATIONS MENU ---");
            System.out.println("1. Reverse String");
            System.out.println("2. Substring");
            System.out.println("3. Calculate String Length");
            System.out.println("4. Fetch Character at Index 5");
            System.out.println("5. Search Substring using indexOf");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    StringBuffer sb = new StringBuffer(inputStr);
                    System.out.println("Reversed String: " + sb.reverse().toString());
                    break;

                case 2:
                    System.out.print("Enter start index: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter end index: ");
                    int end = scanner.nextInt();
                    scanner.nextLine();

                    if (start >= 0 && end <= inputStr.length() && start <= end) {
                        System.out.println("Substring (" + start + " to " + end + "): \"" 
                                           + inputStr.substring(start, end) + "\"");
                    } else {
                        System.out.println("Invalid indices! String length is " + inputStr.length());
                    }
                    break;

                case 3:
                    System.out.println("Length of String: " + inputStr.length());
                    break;

                case 4:
                    if (inputStr.length() > 5) {
                        System.out.println("Character at index 5: '" + inputStr.charAt(5) + "'");
                    } else {
                        System.out.println("String length is " + inputStr.length() 
                                           + ". Index 5 is out of bounds (needs length >= 6).");
                    }
                    break;

                case 5:
                    System.out.print("Enter substring to search: ");
                    String searchStr = scanner.nextLine();
                    int index = inputStr.indexOf(searchStr);
                    if (index != -1) {
                        System.out.println("\"" + searchStr + "\" found at index: " + index);
                    } else {
                        System.out.println("\"" + searchStr + "\" not found in the string.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
}

/*
Sample Output:
Enter a string: Hello World Java

--- STRING OPERATIONS MENU ---
1. Reverse String
2. Substring
3. Calculate String Length
4. Fetch Character at Index 5
5. Search Substring using indexOf
6. Exit
Enter your choice (1-6): 3
Length of String: 16

--- STRING OPERATIONS MENU ---
1. Reverse String
2. Substring
3. Calculate String Length
4. Fetch Character at Index 5
5. Search Substring using indexOf
6. Exit
Enter your choice (1-6): 4
Character at index 5: ' '

--- STRING OPERATIONS MENU ---
1. Reverse String
2. Substring
3. Calculate String Length
4. Fetch Character at Index 5
5. Search Substring using indexOf
6. Exit
Enter your choice (1-6): 1
Reversed String: avaJ dlroW olleH

--- STRING OPERATIONS MENU ---
1. Reverse String
2. Substring
3. Calculate String Length
4. Fetch Character at Index 5
5. Search Substring using indexOf
6. Exit
Enter your choice (1-6): 6
Exiting program. Goodbye!
*/
