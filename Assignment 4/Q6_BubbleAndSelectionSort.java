/*
 * Lab Assignment 4 - Question 6
 * 
 * Title: Sorting Arrays (Bubble and Selection Sort)
 * Objective: Implement sorting algorithms on 1D arrays.
 * 
 * Tasks:
 * 1. Input 8 integers into an array.
 * 2. Sort the array in ascending order using bubble sort.
 * 3. Display the sorted array.
 * 4. Sort another array in descending order using selection sort.
 * 5. Display the result.
 */

import java.util.Scanner;

public class Q6_BubbleAndSelectionSort {

    // Bubble Sort in Ascending Order
    public static void bubbleSortAscending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization if already sorted
        }
    }

    // Selection Sort in Descending Order
    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find maximum element index in remaining unsorted portion
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swap the found maximum element with the first element of unsorted portion
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Utility function to print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Part 1: Bubble Sort (Ascending) ---
        System.out.println("=== 1. Bubble Sort (Ascending Order) ===");
        int[] arr1 = new int[8];
        System.out.println("Enter 8 integers for Array 1:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Element [" + i + "]: ");
            arr1[i] = scanner.nextInt();
        }

        System.out.print("\nOriginal Array 1: ");
        printArray(arr1);

        bubbleSortAscending(arr1);

        System.out.print("Sorted Array 1 (Bubble Sort - Ascending): ");
        printArray(arr1);

        // --- Part 2: Selection Sort (Descending) ---
        System.out.println("\n=== 2. Selection Sort (Descending Order) ===");
        int[] arr2 = new int[8];
        System.out.println("Enter 8 integers for Array 2:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Element [" + i + "]: ");
            arr2[i] = scanner.nextInt();
        }

        System.out.print("\nOriginal Array 2: ");
        printArray(arr2);

        selectionSortDescending(arr2);

        System.out.print("Sorted Array 2 (Selection Sort - Descending): ");
        printArray(arr2);

        scanner.close();
    }
}

/*
 * Sample Output:
 * 
 * === 1. Bubble Sort (Ascending Order) ===
 * Enter 8 integers for Array 1:
 * Element [0]: 64
 * Element [1]: 34
 * Element [2]: 25
 * Element [3]: 12
 * Element [4]: 22
 * Element [5]: 11
 * Element [6]: 90
 * Element [7]: 48
 * 
 * Original Array 1: 64 34 25 12 22 11 90 48 
 * Sorted Array 1 (Bubble Sort - Ascending): 11 12 22 25 34 48 64 90 
 * 
 * === 2. Selection Sort (Descending Order) ===
 * Enter 8 integers for Array 2:
 * Element [0]: 29
 * Element [1]: 10
 * Element [2]: 14
 * Element [3]: 37
 * Element [4]: 13
 * Element [5]: 85
 * Element [6]: 42
 * Element [7]: 5
 * 
 * Original Array 2: 29 10 14 37 13 85 42 5 
 * Sorted Array 2 (Selection Sort - Descending): 85 42 37 29 14 13 10 5 
 */
