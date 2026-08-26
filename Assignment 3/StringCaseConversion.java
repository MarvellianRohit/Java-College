// Assignment 3/StringCaseConversion.java

public class StringCaseConversion {
    public static void main(String[] args) {
        // Input string specified in the question
        String inputStr = "Hello, How are you.";

        // Convert string to Uppercase
        String upperStr = inputStr.toUpperCase();

        // Convert string to Lowercase
        String lowerStr = inputStr.toLowerCase();

        // Display results
        System.out.println("Original String : " + inputStr);
        System.out.println("Uppercase String: " + upperStr);
        System.out.println("Lowercase String: " + lowerStr);
    }
}

/*
Sample Output:
Original String : Hello, How are you.
Uppercase String: HELLO, HOW ARE YOU.
Lowercase String: hello, how are you.
*/
