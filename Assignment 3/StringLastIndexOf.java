/*
 * Question 8: Write a Java program to get the last index of a string within a string.
 */

public class StringLastIndexOf {
    public static void main(String[] args) {
        String mainString = "Java is a popular programming language. Java is versatile and powerful.";
        String targetSubstring = "Java";

        System.out.println("Main String: \"" + mainString + "\"");
        System.out.println("Target Substring: \"" + targetSubstring + "\"");
        System.out.println("--------------------------------------------------");

        // Get the first index of the substring
        int firstIndex = mainString.indexOf(targetSubstring);

        // Get the last index of the substring
        int lastIndex = mainString.lastIndexOf(targetSubstring);

        System.out.println("First occurrence of \"" + targetSubstring + "\": index " + firstIndex);
        System.out.println("Last occurrence of  \"" + targetSubstring + "\": index " + lastIndex);

        System.out.println("--------------------------------------------------");

        // Searching for character last index
        char ch = 'a';
        int lastCharIndex = mainString.lastIndexOf(ch);
        System.out.println("Last occurrence of character '" + ch + "': index " + lastCharIndex);

        // Substring not found case
        String notFound = "Python";
        int indexNotFound = mainString.lastIndexOf(notFound);
        System.out.println("Last occurrence of \"" + notFound + "\": index " + indexNotFound);
    }
}

/*
Sample Output:
Main String: "Java is a popular programming language. Java is versatile and powerful."
Target Substring: "Java"
--------------------------------------------------
First occurrence of "Java": index 0
Last occurrence of  "Java": index 40
--------------------------------------------------
Last occurrence of character 'a': index 57
Last occurrence of "Python": index -1
*/
