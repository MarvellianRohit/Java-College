/*
 * Question 5: Write a java program to split the given string 
 * into words: "Hello, How are you."
 */

public class Q5_StringSplitWords {
    public static void main(String[] args) {
        // Input string specified in the question
        String inputStr = "Hello, How are you.";

        System.out.println("Original String: \"" + inputStr + "\"");
        System.out.println("----------------------------------------");

        // Split string into words using regular expression (splits on spaces and commas)
        String[] words = inputStr.split("[\\s,]+");

        System.out.println("Words after splitting:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("Word [" + i + "]: " + words[i]);
        }
    }
}

/*
Sample Output:
Original String: "Hello, How are you."
----------------------------------------
Words after splitting:
Word [0]: Hello
Word [1]: How
Word [2]: are
Word [3]: you.
*/
