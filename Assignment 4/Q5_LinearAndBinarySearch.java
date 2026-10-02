/*
 * Lab Assignment 4 - Question 5
 * 
 * Title: Linear and Binary Search
 * Objective: Implement searching operations in arrays.
 * 
 * Tasks:
 * 1. Input 10 unsorted integers into an array.
 * 2. Implement linear search to find a user-provided value and display its index (or "not found").
 * 3. Sort the array (use any sorting method).
 * 4. Implement binary search on the sorted array and display the result.
 */

import java.util.Scanner;

public class Q5_LinearAndBinarySearch {

    // Linear Search Implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found at index i
            }
        }
        return -1; // Not found
    }

    // Binary Search Implementation (Iterative)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Found at index mid
            } else if (arr[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }

    // Bubble Sort Implementation
    public static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1: Input 10 unsorted integers
        int[] arr = new int[10];
        System.out.println("=== Search Operations in Arrays ===");
        System.out.println("Enter 10 unsorted integers:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Element [" + i + "]: ");
            arr[i] = scanner.nextInt();
        }

        // Display initial array
        System.out.print("\nOriginal Unsorted Array: ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Task 2: Linear Search
        System.out.println("\n--- 1. Linear Search ---");
        System.out.print("Enter value to search linearly: ");
        int linearTarget = scanner.nextInt();

        int linearIndex = linearSearch(arr, linearTarget);
        if (linearIndex != -1) {
            System.out.println("Result: Value " + linearTarget + " found at index [" + linearIndex + "] in original array.");
        } else {
            System.out.println("Result: Value " + linearTarget + " not found in the array.");
        }

        // Task 3: Sort the array
        sortArray(arr);
        System.out.println("\n--- 2. Array Sorting ---");
        System.out.print("Sorted Array (Ascending): ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Task 4: Binary Search
        System.out.println("\n--- 3. Binary Search ---");
        System.out.print("Enter value to search via Binary Search: ");
        int binaryTarget = scanner.nextInt();

        int binaryIndex = binarySearch(arr, binaryTarget);
        if (binaryIndex != -1) {
            System.out.println("Result: Value " + binaryTarget + " found at index [" + binaryIndex + "] in sorted array.");
        } else {
            System.out.println("Result: Value " + binaryTarget + " not found in the sorted array.");
        }

        scanner.close();
    }
}

/*
 * Sample Output:
 * 
 * === Search Operations in Arrays ===
 * Enter 10 unsorted integers:
 * Element [0]: 45
 * Element [1]: 12
 * Element [2]: 89
 * Element [3]: 23
 * Element [4]: 67
 * Element [5]: 34
 * Element [6]: 90
 * Element [7]: 11
 * Element [8]: 56
 * Element [9]: 78
 * 
 * Original Unsorted Array: 45 12 89 23 67 34 90 11 56 78 
 * 
 * --- 1. Linear Search ---
 * Enter value to search linearly: 34
 * Result: Value 34 found at index [5] in original array.
 * 
 * --- 2. Array Sorting ---
 * Sorted Array (Ascending): 11 12 23 34 45 56 67 78 89 90 
 * 
 * --- 3. Binary Search ---
 * Enter value to search via Binary Search: 34
 * Result: Value 34 found at index [3] in sorted array.
 */
