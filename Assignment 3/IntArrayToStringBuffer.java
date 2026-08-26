// Assignment 3/IntArrayToStringBuffer.java

public class IntArrayToStringBuffer {
    public static void main(String[] args) {
        // Sample integer array
        int[] numbers = {10, 20, 30, 40, 50, 60, 70};

        // Create a StringBuffer object
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
            if (i < numbers.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        // Convert StringBuffer to String
        String resultString = sb.toString();

        // Print the original array elements and converted string
        System.out.println("Original int Array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        System.out.println("Converted String using StringBuffer:");
        System.out.println(resultString);
    }
}

/*
Sample Output:
Original int Array:
10 20 30 40 50 60 70 

Converted String using StringBuffer:
[10, 20, 30, 40, 50, 60, 70]
*/
