/*
 * Question 9: Write a Java program to trim any leading or trailing whitespace 
 * from a given string.
 */

public class StringTrimWhitespace {
    public static void main(String[] args) {
        // String with leading and trailing whitespaces
        String originalString = "   \t  Hello, World! Welcome to Java Programming.   \n  ";

        System.out.println("Original String with Whitespace:");
        System.out.println("  Content: \"" + originalString + "\"");
        System.out.println("  Length : " + originalString.length());

        System.out.println("--------------------------------------------------");

        // Trim leading and trailing whitespaces using trim()
        String trimmedString = originalString.trim();

        System.out.println("Trimmed String (using trim()):");
        System.out.println("  Content: \"" + trimmedString + "\"");
        System.out.println("  Length : " + trimmedString.length());

        System.out.println("--------------------------------------------------");
        System.out.println("Total Whitespace Characters Removed: " 
                           + (originalString.length() - trimmedString.length()));
    }
}

/*
Sample Output:
Original String with Whitespace:
  Content: "   	  Hello, World! Welcome to Java Programming.   
  "
  Length : 55
--------------------------------------------------
Trimmed String (using trim()):
  Content: "Hello, World! Welcome to Java Programming."
  Length : 42
--------------------------------------------------
Total Whitespace Characters Removed: 13
*/
