/*
 * Lab Assignment 4 - Question 8
 * 
 * Title: Comprehensive Array Operations Menu
 * Objective: Combine all operations into a menu-driven program.
 * 
 * Tasks:
 * Create a menu-driven program with the following options:
 * 1. Input array elements.
 * 2. Display array.
 * 3. Insert an element.
 * 4. Delete an element.
 * 5. Search for an element (linear).
 * 6. Sort the array (ascending).
 * 7. Exit.
 */

import java.util.Scanner;

public class Q8_ArrayOperationsMenu {
    private static final int MAX_CAPACITY = 100;
    private static int[] arr = new int[MAX_CAPACITY];
    private static int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==========================================");
            System.out.println("   COMPREHENSIVE ARRAY OPERATIONS MENU    ");
            System.out.println("==========================================");
            System.out.println("1. Input array elements");
            System.out.println("2. Display array");
            System.out.println("3. Insert an element");
            System.out.println("4. Delete an element");
            System.out.println("5. Search for an element (Linear)");
            System.out.println("6. Sort the array (Ascending)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Option 1: Input array elements
                    System.out.print("Enter number of elements to input (max " + MAX_CAPACITY + "): ");
                    int n = scanner.nextInt();
                    if (n < 0 || n > MAX_CAPACITY) {
                        System.out.println("Invalid number of elements! Must be between 0 and " + MAX_CAPACITY);
                    } else {
                        size = n;
                        System.out.println("Enter " + size + " integer elements:");
                        for (int i = 0; i < size; i++) {
                            System.out.print("Element [" + i + "]: ");
                            arr[i] = scanner.nextInt();
                        }
                        System.out.println("Array populated successfully with " + size + " elements.");
                    }
                    break;

                case 2:
                    // Option 2: Display array
                    if (size == 0) {
                        System.out.println("Array is empty! Please input elements first.");
                    } else {
                        System.out.print("Current Array Elements (" + size + "): [ ");
                        for (int i = 0; i < size; i++) {
                            System.out.print(arr[i] + (i < size - 1 ? ", " : ""));
                        }
                        System.out.println(" ]");
                    }
                    break;

                case 3:
                    // Option 3: Insert an element
                    if (size >= MAX_CAPACITY) {
                        System.out.println("Array is full! Cannot insert more elements.");
                    } else {
                        System.out.print("Enter the value to insert: ");
                        int val = scanner.nextInt();
                        System.out.print("Enter index to insert at (0 to " + size + "): ");
                        int pos = scanner.nextInt();

                        if (pos < 0 || pos > size) {
                            System.out.println("Invalid index! Position must be between 0 and " + size);
                        } else {
                            // Shift elements right
                            for (int i = size; i > pos; i--) {
                                arr[i] = arr[i - 1];
                            }
                            arr[pos] = val;
                            size++;
                            System.out.println("Value " + val + " successfully inserted at index [" + pos + "].");
                        }
                    }
                    break;

                case 4:
                    // Option 4: Delete an element
                    if (size == 0) {
                        System.out.println("Array is empty! Nothing to delete.");
                    } else {
                        System.out.print("Enter index to delete (0 to " + (size - 1) + "): ");
                        int delPos = scanner.nextInt();

                        if (delPos < 0 || delPos >= size) {
                            System.out.println("Invalid index! Position must be between 0 and " + (size - 1));
                        } else {
                            int deletedVal = arr[delPos];
                            // Shift elements left
                            for (int i = delPos; i < size - 1; i++) {
                                arr[i] = arr[i + 1];
                            }
                            size--;
                            System.out.println("Value " + deletedVal + " at index [" + delPos + "] deleted successfully.");
                        }
                    }
                    break;

                case 5:
                    // Option 5: Search for an element (linear)
                    if (size == 0) {
                        System.out.println("Array is empty! Nothing to search.");
                    } else {
                        System.out.print("Enter value to search: ");
                        int target = scanner.nextInt();
                        int foundIndex = -1;

                        for (int i = 0; i < size; i++) {
                            if (arr[i] == target) {
                                foundIndex = i;
                                break;
                            }
                        }

                        if (foundIndex != -1) {
                            System.out.println("Element " + target + " found at index [" + foundIndex + "].");
                        } else {
                            System.out.println("Element " + target + " NOT found in the array.");
                        }
                    }
                    break;

                case 6:
                    // Option 6: Sort the array (ascending)
                    if (size == 0) {
                        System.out.println("Array is empty! Nothing to sort.");
                    } else {
                        // Bubble sort
                        for (int i = 0; i < size - 1; i++) {
                            for (int j = 0; j < size - i - 1; j++) {
                                if (arr[j] > arr[j + 1]) {
                                    int temp = arr[j];
                                    arr[j] = arr[j + 1];
                                    arr[j + 1] = temp;
                                }
                            }
                        }
                        System.out.print("Array sorted in ascending order: [ ");
                        for (int i = 0; i < size; i++) {
                            System.out.print(arr[i] + (i < size - 1 ? ", " : ""));
                        }
                        System.out.println(" ]");
                    }
                    break;

                case 7:
                    // Option 7: Exit
                    System.out.println("Exiting Array Operations Menu. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select an option from 1 to 7.");
            }
        }
    }
}

/*
 * Sample Output:
 * 
 * ==========================================
 *    COMPREHENSIVE ARRAY OPERATIONS MENU    
 * ==========================================
 * 1. Input array elements
 * 2. Display array
 * 3. Insert an element
 * 4. Delete an element
 * 5. Search for an element (Linear)
 * 6. Sort the array (Ascending)
 * 7. Exit
 * Enter your choice (1-7): 1
 * Enter number of elements to input (max 100): 5
 * Enter 5 integer elements:
 * Element [0]: 40
 * Element [1]: 10
 * Element [2]: 50
 * Element [3]: 20
 * Element [4]: 30
 * Array populated successfully with 5 elements.
 * 
 * ==========================================
 *    COMPREHENSIVE ARRAY OPERATIONS MENU    
 * ==========================================
 * 1. Input array elements
 * 2. Display array
 * 3. Insert an element
 * 4. Delete an element
 * 5. Search for an element (Linear)
 * 6. Sort the array (Ascending)
 * 7. Exit
 * Enter your choice (1-7): 2
 * Current Array Elements (5): [ 40, 10, 50, 20, 30 ]
 * 
 * ==========================================
 *    COMPREHENSIVE ARRAY OPERATIONS MENU    
 * ==========================================
 * 1. Input array elements
 * 2. Display array
 * 3. Insert an element
 * 4. Delete an element
 * 5. Search for an element (Linear)
 * 6. Sort the array (Ascending)
 * 7. Exit
 * Enter your choice (1-7): 3
 * Enter the value to insert: 99
 * Enter index to insert at (0 to 5): 2
 * Value 99 successfully inserted at index [2].
 * 
 * ==========================================
 *    COMPREHENSIVE ARRAY OPERATIONS MENU    
 * ==========================================
 * 1. Input array elements
 * 2. Display array
 * 3. Insert an element
 * 4. Delete an element
 * 5. Search for an element (Linear)
 * 6. Sort the array (Ascending)
 * 7. Exit
 * Enter your choice (1-7): 4
 * Enter index to delete (0 to 5): 0
 * Value 40 at index [0] deleted successfully.
 * 
 * ==========================================
 *    COMPREHENSIVE ARRAY OPERATIONS MENU    
 * ==========================================
 * 1. Input array elements
 * 2. Display array
 * 3. Insert an element
 * 4. Delete an element
 * 5. Search for an element (Linear)
 * 6. Sort the array (Ascending)
 * 7. Exit
 * Enter your choice (1-7): 5
 * Enter value to search: 99
 * Element 99 found at index [1].
 * 
 * ==========================================
 *    COMPREHENSIVE ARRAY OPERATIONS MENU    
 * ==========================================
 * 1. Input array elements
 * 2. Display array
 * 3. Insert an element
 * 4. Delete an element
 * 5. Search for an element (Linear)
 * 6. Sort the array (Ascending)
 * 7. Exit
 * Enter your choice (1-7): 6
 * Array sorted in ascending order: [ 10, 20, 30, 50, 99 ]
 * 
 * ==========================================
 *    COMPREHENSIVE ARRAY OPERATIONS MENU    
 * ==========================================
 * 1. Input array elements
 * 2. Display array
 * 3. Insert an element
 * 4. Delete an element
 * 5. Search for an element (Linear)
 * 6. Sort the array (Ascending)
 * 7. Exit
 * Enter your choice (1-7): 7
 * Exiting Array Operations Menu. Goodbye!
 */
