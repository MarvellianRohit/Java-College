/*
 * Question: Write a Java program using OOP to reverse a string passed via command-line arguments.
 */

// Class 1: Contains method to reverse a string
class StringReverser {

    // Method to reverse a string
    public String reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }
}

// Class 2: Main class using command line argument
public class ReverseString {
    public static void main(String[] args) {
        // Check if argument is passed in command line
        if (args.length == 0) {
            System.out.println("Please provide a string as a command line argument!");
            return;
        }

        // Get the string from command line input
        String input = args[0];

        // Create object of StringReverser class
        StringReverser sr = new StringReverser();

        // Call method and print result
        String result = sr.reverse(input);

        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + result);
    }
}

/*
Output:
Original String: hello world
Reversed String: dlrow olleh
*/

