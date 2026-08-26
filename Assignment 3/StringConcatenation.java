// Assignment 3/StringConcatenation.java

public class StringConcatenation {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = ", World!";

        System.out.println("String 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");
        System.out.println("----------------------------------------");

        // 1. Concatenation using String concat() method & + operator
        String stringResult1 = str1.concat(str2);
        String stringResult2 = str1 + str2;

        System.out.println("1. Using String.concat():");
        System.out.println("   Result: " + stringResult1);
        System.out.println("   Using + operator: " + stringResult2);

        System.out.println("----------------------------------------");

        // 2. Concatenation using StringBuffer append() method
        StringBuffer stringBuffer = new StringBuffer(str1);
        stringBuffer.append(str2);
        String stringBufferResult = stringBuffer.toString();

        System.out.println("2. Using StringBuffer.append():");
        System.out.println("   Result: " + stringBufferResult);
    }
}

/*
Sample Output:
String 1: "Hello"
String 2: ", World!"
----------------------------------------
1. Using String.concat():
   Result: Hello, World!
   Using + operator: Hello, World!
----------------------------------------
2. Using StringBuffer.append():
   Result: Hello, World!
*/
