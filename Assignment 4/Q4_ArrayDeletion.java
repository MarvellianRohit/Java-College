/*
 * Lab Assignment 4 - Question 4
 * 
 * Title: Deletion from an Array
 * Objective: Delete an element from a specified position in a 1D array.
 * 
 * Tasks:
 * 1. Input 8 integers into an array.
 * 2. Ask the user for the index to delete.
 * 3. Shift elements to the left to fill the gap.
 * 4. Display the updated array.
 */

import java.util.Scanner;

public class Q4_ArrayDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1: Input 8 integers into an array
        int[] arr = new int[8];
        int size = 8;

        System.out.println("=== Array Deletion Program ===");
        System.out.println("Enter 8 integers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element [" + i + "]: ");
            arr[i] = scanner.nextInt();
        }

        // Display current array
        System.out.print("\nOriginal Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Task 2: Ask the user for the index to delete
        System.out.print("\nEnter the index of the element to delete (0 to " + (size - 1) + "): ");
        int deleteIndex = scanner.nextInt();

        // Validate index
        if (deleteIndex < 0 || deleteIndex >= size) {
            System.out.println("Invalid index! Please enter an index between 0 and " + (size - 1));
        } else {
            int deletedValue = arr[deleteIndex];

            // Task 3: Shift elements to the left to fill the gap
            for (int i = deleteIndex; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--; // Decrement size

            // Task 4: Display the updated array
            System.out.println("\n--- Element " + deletedValue + " at index [" + deleteIndex + "] Deleted ---");
            System.out.print("Updated Array (" + size + " elements): ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

/*
 * Sample Output:
 * 
 * === Array Deletion Program ===
 * Enter 8 integers:
 * Element [0]: 15
 * Element [1]: 28
 * Element [2]: 33
 * Element [3]: 49
 * Element [4]: 52
 * Element [5]: 67
 * Element [6]: 71
 * Element [7]: 80
 * 
 * Original Array: 15 28 33 49 52 67 71 80 
 * 
 * Enter the index of the element to delete (0 to 7): 3
 * 
 * --- Element 49 at index [3] Deleted ---
 * Updated Array (7 elements): 15 28 33 52 67 71 80 
 */
