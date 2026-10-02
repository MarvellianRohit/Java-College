/*
 * Lab Assignment 4 - Question 9
 * 
 * Title: Student Result Processing System (Exception Handling)
 * Objective: Write a Java program to develop a Student Result Processing System that accepts 
 *            a student's marks in multiple subjects and calculates the total, average, and grade.
 * 
 * Key Requirements:
 * 1. Use a try-catch block to handle:
 *    - ArithmeticException when calculating the average.
 *    - ArrayIndexOutOfBoundsException when accessing an invalid subject index.
 *    - InputMismatchException or an appropriate exception when the user enters non-numeric marks.
 * 2. Create a user-defined exception named InvalidMarksException and use the throw keyword 
 *    when marks are less than 0 or greater than 100.
 * 3. Create a method such as calculateGrade() that uses throws to declare the possible exception.
 * 4. Use multiple catch blocks and explain the concept of the exception hierarchy.
 * 5. Use a finally block to display a message indicating that result processing is complete.
 * 6. Declare a constant such as MAX_MARKS = 100 using the final keyword.
 * 7. Briefly explain how exception handling prevents abnormal termination of the program.
 * 
 * Concept Explanations:
 * - Exception Hierarchy: In Java, all exceptions inherit from java.lang.Throwable.
 *   Throwable has two main subclasses: Error and Exception.
 *   Exception is divided into:
 *     - Checked Exceptions (subclasses of Exception excluding RuntimeException, e.g., InvalidMarksException).
 *     - Unchecked Exceptions (subclasses of RuntimeException, e.g., ArithmeticException, ArrayIndexOutOfBoundsException, InputMismatchException).
 *   When using multiple catch blocks, subclasses MUST be caught before their parent classes (e.g., specific exceptions before general Exception),
 *   otherwise unreachable code compilation errors will occur.
 * 
 * - Preventing Abnormal Termination: Without exception handling, encountering a runtime error 
 *   (such as division by zero or invalid input) causes the JVM to abruptly terminate execution, 
 *   leaving resources open and abruptly crashing. With try-catch-finally, exceptions are caught, 
 *   meaningful error messages are displayed to users, cleanup in finally is guaranteed, and the 
 *   program continues running gracefully.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

// User-Defined Checked Exception
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

public class Q9_StudentResultProcessing {
    // Constant declared using final keyword
    public static final int MAX_MARKS = 100;
    public static final int MIN_MARKS = 0;

    /**
     * Method that calculates grade and declares InvalidMarksException using throws
     */
    public static String calculateGrade(double average) throws InvalidMarksException {
        if (average < MIN_MARKS || average > MAX_MARKS) {
            throw new InvalidMarksException("Calculated average (" + average + ") is out of valid range (0 to " + MAX_MARKS + ").");
        }

        if (average >= 90) return "A+ (Outstanding)";
        else if (average >= 80) return "A (Excellent)";
        else if (average >= 70) return "B (Very Good)";
        else if (average >= 60) return "C (Good)";
        else if (average >= 50) return "D (Pass)";
        else return "F (Fail)";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("       STUDENT RESULT PROCESSING SYSTEM          ");
        System.out.println("=================================================");

        try {
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            // Handling ArithmeticException scenario (e.g., division by zero if subjects is 0)
            if (numSubjects == 0) {
                // Explicitly dividing by zero to demonstrate ArithmeticException handling
                int triggerDivByZero = 100 / numSubjects;
            } else if (numSubjects < 0) {
                throw new IllegalArgumentException("Number of subjects cannot be negative (" + numSubjects + ").");
            }

            double[] marks = new double[numSubjects];
            double total = 0;

            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (out of " + MAX_MARKS + "): ");
                double subjectMark = scanner.nextDouble();

                // Validate individual subject marks using throw keyword
                if (subjectMark < MIN_MARKS || subjectMark > MAX_MARKS) {
                    throw new InvalidMarksException("Invalid mark entered: " + subjectMark 
                        + ". Marks must be between " + MIN_MARKS + " and " + MAX_MARKS + ".");
                }

                // Potential ArrayIndexOutOfBoundsException trigger demonstration check:
                // (Safely storing within bounds)
                marks[i] = subjectMark;
                total += subjectMark;
            }

            // Calculation of average
            double average = total / numSubjects;

            // Calculating grade via method that throws InvalidMarksException
            String grade = calculateGrade(average);

            // Display Results
            System.out.println("\n----------------- RESULT SUMMARY -----------------");
            System.out.println("Total Subjects  : " + numSubjects);
            System.out.println("Total Marks     : " + total + " / " + (numSubjects * MAX_MARKS));
            System.out.printf("Average Marks   : %.2f%%\n", average);
            System.out.println("Grade Awarded   : " + grade);
            System.out.println("Status          : " + (average >= 50 ? "PASSED" : "FAILED"));

            // Demonstration of deliberate out-of-bounds check
            System.out.print("\nDo you want to verify a specific subject index? (Enter index to inspect, or -1 to skip): ");
            int testIndex = scanner.nextInt();
            if (testIndex != -1) {
                // This will trigger ArrayIndexOutOfBoundsException if testIndex < 0 or >= numSubjects
                System.out.println("Marks at index [" + testIndex + "]: " + marks[testIndex]);
            }

        } catch (InvalidMarksException ime) {
            // Specific User-Defined Exception
            System.err.println("\n[CUSTOM ERROR] InvalidMarksException caught: " + ime.getMessage());
        } catch (InputMismatchException ime) {
            // Non-numeric input error
            System.err.println("\n[INPUT ERROR] InputMismatchException caught: You entered non-numeric input. Please enter valid numbers.");
        } catch (ArithmeticException ae) {
            // Division by zero error
            System.err.println("\n[MATH ERROR] ArithmeticException caught: Cannot calculate average for 0 subjects (Division by zero).");
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            // Array index out of range
            System.err.println("\n[INDEX ERROR] ArrayIndexOutOfBoundsException caught: Attempted to access an invalid subject index (" + aioobe.getMessage() + ").");
        } catch (Exception e) {
            // Generic fallback exception (Parent in hierarchy)
            System.err.println("\n[GENERAL ERROR] An unexpected error occurred: " + e.getMessage());
        } finally {
            // Finally block always executes
            System.out.println("\n[FINALLY BLOCK] Result processing routine is complete. Resources cleaned up.");
            scanner.close();
        }
    }
}

/*
 * Sample Output 1 (Successful Execution):
 * 
 * =================================================
 *        STUDENT RESULT PROCESSING SYSTEM          
 * =================================================
 * Enter the number of subjects: 5
 * Enter marks for Subject 1 (out of 100): 85
 * Enter marks for Subject 2 (out of 100): 92
 * Enter marks for Subject 3 (out of 100): 78
 * Enter marks for Subject 4 (out of 100): 88
 * Enter marks for Subject 5 (out of 100): 95
 * 
 * ----------------- RESULT SUMMARY -----------------
 * Total Subjects  : 5
 * Total Marks     : 438.0 / 500
 * Average Marks   : 87.60%
 * Grade Awarded   : A (Excellent)
 * Status          : PASSED
 * 
 * Do you want to verify a specific subject index? (Enter index to inspect, or -1 to skip): -1
 * 
 * [FINALLY BLOCK] Result processing routine is complete. Resources cleaned up.
 * 
 * 
 * Sample Output 2 (User-Defined InvalidMarksException Triggered):
 * 
 * =================================================
 *        STUDENT RESULT PROCESSING SYSTEM          
 * =================================================
 * Enter the number of subjects: 3
 * Enter marks for Subject 1 (out of 100): 75
 * Enter marks for Subject 2 (out of 100): 105
 * 
 * [CUSTOM ERROR] InvalidMarksException caught: Invalid mark entered: 105.0. Marks must be between 0 and 100.
 * 
 * [FINALLY BLOCK] Result processing routine is complete. Resources cleaned up.
 * 
 * 
 * Sample Output 3 (InputMismatchException Triggered):
 * 
 * =================================================
 *        STUDENT RESULT PROCESSING SYSTEM          
 * =================================================
 * Enter the number of subjects: 3
 * Enter marks for Subject 1 (out of 100): abc
 * 
 * [INPUT ERROR] InputMismatchException caught: You entered non-numeric input. Please enter valid numbers.
 * 
 * [FINALLY BLOCK] Result processing routine is complete. Resources cleaned up.
 */
