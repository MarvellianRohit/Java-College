/*
 * Lab Assignment 4 - Question 3
 * 
 * Title: Insertion in an Array
 * Objective: Insert an element at a specified position in a 1D array.
 * 
 * Tasks:
 * 1. Declare an integer array of size 10 and input 5 elements from the user.
 * 2. Ask the user for a value and a position (index) to insert.
 * 3. Shift elements to the right to make space and insert the new value.
 * 4. Display the updated array.
 */

import java.util.Scanner;

public class Q3_ArrayInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1: Declare array of size 10 and input 5 elements
        int[] arr = new int[10];
        int currentSize = 5;

        System.out.println("=== Array Insertion Program ===");
        System.out.println("Enter 5 initial elements:");
        for (int i = 0; i < currentSize; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Display current array
        System.out.print("\nInitial Array (" + currentSize + " elements): ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Task 2: Ask user for value and position (index) to insert
        System.out.print("\nEnter the value to insert: ");
        int value = scanner.nextInt();

        System.out.print("Enter the index/position to insert at (0 to " + currentSize + "): ");
        int index = scanner.nextInt();

        // Validate index
        if (index < 0 || index > currentSize) {
            System.out.println("Invalid index! Position must be between 0 and " + currentSize);
        } else if (currentSize >= arr.length) {
            System.out.println("Array is full! Cannot insert new element.");
        } else {
            // Task 3: Shift elements to the right to make space
            for (int i = currentSize; i > index; i--) {
                arr[i] = arr[i - 1];
            }

            // Insert new value at the specified index
            arr[index] = value;
            currentSize++;

            // Task 4: Display the updated array
            System.out.println("\n--- Element Inserted Successfully ---");
            System.out.print("Updated Array (" + currentSize + " elements): ");
            for (int i = 0; i < currentSize; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            System.out.print("Full Array of capacity " + arr.length + ": ");
            for (int i = 0; i < arr.length; i++) {
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
 * === Array Insertion Program ===
 * Enter 5 initial elements:
 * Enter element 1: 10
 * Enter element 2: 20
 * Enter element 3: 30
 * Enter element 4: 40
 * Enter element 5: 50
 * 
 * Initial Array (5 elements): 10 20 30 40 50 
 * 
 * Enter the value to insert: 99
 * Enter the index/position to insert at (0 to 5): 2
 * 
 * --- Element Inserted Successfully ---
 * Updated Array (6 elements): 10 20 99 30 40 50 
 * Full Array of capacity 10: 10 20 99 30 40 50 0 0 0 0 
 */
