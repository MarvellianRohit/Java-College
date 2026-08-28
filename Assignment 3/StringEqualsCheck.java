/*
 * Question 7: Write a Java program to check whether two String objects contain the same data.
 */

public class StringEqualsCheck {
    public static void main(String[] args) {
        // Creating string objects
        String str1 = new String("Java Programming");
        String str2 = new String("Java Programming");
        String str3 = new String("java programming");
        String str4 = "Python";

        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        System.out.println("String 3: \"" + str3 + "\"");
        System.out.println("String 4: \"" + str4 + "\"");
        System.out.println("----------------------------------------------");

        // 1. Using equals() method (Case Sensitive Data Comparison)
        boolean isEqual1And2 = str1.equals(str2);
        boolean isEqual1And3 = str1.equals(str3);
        boolean isEqual1And4 = str1.equals(str4);

        System.out.println("1. Data comparison using equals() [Case Sensitive]:");
        System.out.println("   str1.equals(str2) -> " + isEqual1And2 + " (Both contain exact same data)");
        System.out.println("   str1.equals(str3) -> " + isEqual1And3 + " (Different case)");
        System.out.println("   str1.equals(str4) -> " + isEqual1And4 + " (Different data)");

        System.out.println("----------------------------------------------");

        // 2. Using equalsIgnoreCase() method (Case Insensitive Data Comparison)
        boolean isEqualsIgnoreCase1And3 = str1.equalsIgnoreCase(str3);

        System.out.println("2. Data comparison using equalsIgnoreCase() [Case Insensitive]:");
        System.out.println("   str1.equalsIgnoreCase(str3) -> " + isEqualsIgnoreCase1And3);

        System.out.println("----------------------------------------------");

        // 3. Demonstrating difference between 'equals' and '==' operator
        System.out.println("3. Reference comparison using '==' vs Content comparison using 'equals()':");
        System.out.println("   str1 == str2       -> " + (str1 == str2) + " (False because str1 and str2 are distinct objects)");
        System.out.println("   str1.equals(str2)  -> " + str1.equals(str2) + " (True because both objects contain the same data)");
    }
}

/*
Sample Output:
String 1: "Java Programming"
String 2: "Java Programming"
String 3: "java programming"
String 4: "Python"
----------------------------------------------
1. Data comparison using equals() [Case Sensitive]:
   str1.equals(str2) -> true (Both contain exact same data)
   str1.equals(str3) -> false (Different case)
   str1.equals(str4) -> false (Different data)
----------------------------------------------
2. Data comparison using equalsIgnoreCase() [Case Insensitive]:
   str1.equalsIgnoreCase(str3) -> true
----------------------------------------------
3. Reference comparison using '==' vs Content comparison using 'equals()':
   str1 == str2       -> false (False because str1 and str2 are distinct objects)
   str1.equals(str2)  -> true (True because both objects contain the same data)
*/
