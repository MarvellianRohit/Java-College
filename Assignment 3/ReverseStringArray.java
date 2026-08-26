// Assignment 3/ReverseStringArray.java

import java.util.Arrays;

public class ReverseStringArray {
    public static void main(String[] args) {
        // Original String array
        String[] originalArray = {"Java", "Python", "C++", "JavaScript", "Go", "Rust"};

        System.out.println("Original String Array: " + Arrays.toString(originalArray));

        // Create a copy to reverse
        String[] reversedArray = new String[originalArray.length];

        // Reverse the array elements
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }

        System.out.println("Reversed String Array:  " + Arrays.toString(reversedArray));

        // In-place reverse demo
        String[] inPlaceArray = originalArray.clone();
        int left = 0;
        int right = inPlaceArray.length - 1;
        while (left < right) {
            String temp = inPlaceArray[left];
            inPlaceArray[left] = inPlaceArray[right];
            inPlaceArray[right] = temp;
            left++;
            right--;
        }

        System.out.println("In-Place Reversed Array: " + Arrays.toString(inPlaceArray));
    }
}

/*
Sample Output:
Original String Array: [Java, Python, C++, JavaScript, Go, Rust]
Reversed String Array:  [Rust, Go, JavaScript, C++, Python, Java]
In-Place Reversed Array: [Rust, Go, JavaScript, C++, Python, Java]
*/
