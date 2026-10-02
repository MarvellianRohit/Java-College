/*
 * Lab Assignment 4 - Question 10
 * 
 * Title: Bank Account Transaction System (Exception Handling)
 * Objective: Write a Java program to implement a simple Bank Account Transaction System that
 *            allows a user to deposit money, withdraw money, and check the account balance.
 * 
 * Key Requirements:
 * 1. Create a BankAccount class with methods such as deposit(), withdraw(), and checkBalance().
 * 2. Use try-catch to handle invalid operations such as:
 *    - Withdrawing more money than the available balance.
 *    - Entering a negative deposit or withdrawal amount (IllegalArgumentException).
 *    - Division by zero if any transaction-related calculation requires division (ArithmeticException, 
 *      e.g., calculating EMI installments or interest split).
 * 3. Create a user-defined exception named InsufficientBalanceException and use throw to generate 
 *    the exception when the withdrawal amount exceeds the balance.
 * 4. Use throws in the withdraw() method to declare the user-defined exception.
 * 5. Use finally to display the final account balance or a transaction-completion message 
 *    regardless of whether an exception occurs.
 * 6. Demonstrate the use of final by declaring a fixed value such as MIN_BALANCE that cannot be changed.
 * 7. Override or demonstrate finalize() to show when the BankAccount object is eligible for garbage collection. 
 *    Also explain that finalize() is related to object cleanup and is different from finally.
 * 8. Identify the possible checked and unchecked exceptions in the program and explain their position 
 *    in the Java exception hierarchy.
 * 
 * Exception Hierarchy & Concepts Explanation:
 * -------------------------------------------------------------
 * 1. Java Exception Hierarchy:
 *                      java.lang.Throwable
 *                         /          \
 *              java.lang.Error    java.lang.Exception
 *                                   /             \
 *                 Checked Exceptions       java.lang.RuntimeException (Unchecked)
 *                 (e.g., Insufficient-      (e.g., ArithmeticException,
 *                  BalanceException)               IllegalArgumentException,
 *                                                 InputMismatchException)
 * 
 * 2. Checked vs. Unchecked Exceptions:
 *    - Checked Exceptions (e.g., InsufficientBalanceException): Checked at compile-time. Must be declared 
 *      using 'throws' or handled inside a 'try-catch' block.
 *    - Unchecked Exceptions (e.g., IllegalArgumentException, ArithmeticException): Inherit from RuntimeException. 
 *      Occur due to logical errors and are not mandated to be declared by the compiler.
 * 
 * 3. finalize() vs finally:
 *    - finally: A keyword used in exception handling. The finally block is GUARANTEED to execute after try/catch, 
 *      whether an exception is thrown or not. Used for resource cleanup (e.g., closing scanners/connections).
 *    - finalize(): A protected method of java.lang.Object called by the Garbage Collector (GC) just before an object 
 *      is destroyed and reclaimed from heap memory. It is non-deterministic and deprecated in newer Java versions.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

// User-Defined Checked Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// BankAccount Class
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Fixed constant using final keyword
    public static final double MIN_BALANCE = 1000.0;

    public BankAccount(String accountNumber, String accountHolder, double initialDeposit) throws IllegalArgumentException {
        if (initialDeposit < MIN_BALANCE) {
            throw new IllegalArgumentException("Initial deposit (₹" + initialDeposit 
                + ") must be at least minimum balance of ₹" + MIN_BALANCE);
        }
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    // Method to deposit money (throws unchecked IllegalArgumentException for negative amount)
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive. Provided: ₹" + amount);
        }
        this.balance += amount;
        System.out.println(" Successfully deposited ₹" + amount + ". Updated Balance: ₹" + this.balance);
    }

    // Method to withdraw money (throws checked InsufficientBalanceException and unchecked IllegalArgumentException)
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive. Provided: ₹" + amount);
        }
        if ((this.balance - amount) < MIN_BALANCE) {
            throw new InsufficientBalanceException("Withdrawal of ₹" + amount + " failed! "
                + "Account balance cannot fall below the minimum required balance of ₹" + MIN_BALANCE 
                + ". Current balance: ₹" + this.balance);
        }
        this.balance -= amount;
        System.out.println(" Successfully withdrew ₹" + amount + ". Remaining Balance: ₹" + this.balance);
    }

    // Method to check balance
    public double checkBalance() {
        return this.balance;
    }

    // Method to calculate EMI / Installment split (demonstrates ArithmeticException when installments = 0)
    public double calculateInstallment(double loanAmount, int numMonths) {
        if (numMonths == 0) {
            // Integer division by zero triggers ArithmeticException
            int zeroDiv = 100 / numMonths; 
        }
        return loanAmount / numMonths;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }

    // Demonstrating finalize() for garbage collection
    @Override
    @SuppressWarnings("removal")
    protected void finalize() throws Throwable {
        try {
            System.out.println("\n[GARBAGE COLLECTION] finalize() invoked for BankAccount [" + accountNumber + "]. Object memory reclaimed.");
        } finally {
            super.finalize();
        }
    }
}

public class Q10_BankAccountSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("=================================================");
        System.out.println("         BANK ACCOUNT TRANSACTION SYSTEM         ");
        System.out.println("=================================================");

        try {
            // Account Creation
            System.out.print("Enter Account Number: ");
            String accNo = scanner.nextLine();

            System.out.print("Enter Account Holder Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Initial Deposit Amount (Min ₹" + BankAccount.MIN_BALANCE + "): ");
            double initDeposit = scanner.nextDouble();

            account = new BankAccount(accNo, name, initDeposit);
            System.out.println(" Account created successfully for " + name + " with Balance: ₹" + account.checkBalance());

            boolean running = true;
            while (running) {
                System.out.println("\n-----------------------------------------");
                System.out.println("               BANK MENU                 ");
                System.out.println("-----------------------------------------");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Check Balance");
                System.out.println("4. Calculate Loan Monthly Installment (EMI)");
                System.out.println("5. Trigger GC Demo & Exit");
                System.out.print("Enter your choice (1-5): ");

                int choice = scanner.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter deposit amount: ₹");
                            double depAmount = scanner.nextDouble();
                            account.deposit(depAmount);
                            break;

                        case 2:
                            System.out.print("Enter withdrawal amount: ₹");
                            double withAmount = scanner.nextDouble();
                            account.withdraw(withAmount);
                            break;

                        case 3:
                            System.out.println(" Current Available Balance: ₹" + account.checkBalance());
                            System.out.println(" Mandatory Minimum Balance: ₹" + BankAccount.MIN_BALANCE);
                            break;

                        case 4:
                            System.out.print("Enter loan amount: ₹");
                            double loan = scanner.nextDouble();
                            System.out.print("Enter number of installment months: ");
                            int months = scanner.nextInt();
                            double emi = account.calculateInstallment(loan, months);
                            System.out.println(" Monthly Installment: ₹" + emi + " per month.");
                            break;

                        case 5:
                            running = false;
                            System.out.println("Logging out from account session...");
                            break;

                        default:
                            System.out.println("Invalid choice! Please choose between 1 and 5.");
                    }
                } catch (InsufficientBalanceException ibe) {
                    // Handling custom checked exception
                    System.err.println("\n[TRANSACTION ERROR] " + ibe.getMessage());
                } catch (IllegalArgumentException iae) {
                    // Handling negative / invalid amount
                    System.err.println("\n[INVALID INPUT ERROR] " + iae.getMessage());
                } catch (ArithmeticException ae) {
                    // Handling division by zero
                    System.err.println("\n[ARITHMETIC ERROR] Division by zero in installment calculation: Number of months cannot be 0.");
                } finally {
                    // Finally block for every transaction step
                    if (account != null) {
                        System.out.println("[TRANSACTION LOG] Transaction ended. Current balance is: ₹" + account.checkBalance());
                    }
                }
            }

        } catch (InputMismatchException ime) {
            System.err.println("\n[INPUT ERROR] Non-numeric input encountered. Please restart and provide valid numerical values.");
        } catch (IllegalArgumentException iae) {
            System.err.println("\n[CREATION ERROR] " + iae.getMessage());
        } catch (Exception e) {
            System.err.println("\n[GENERAL ERROR] Unexpected error: " + e.getMessage());
        } finally {
            // Master finally block
            System.out.println("\n=================================================");
            System.out.println("[MASTER FINALLY] Session closed. Scanner resource released.");
            System.out.println("=================================================");
            scanner.close();
        }

        // Demonstrating finalize() and Garbage Collection
        System.out.println("\n[DEMO] Dereferencing account object for garbage collection demonstration...");
        account = null; // Eligible for GC
        System.gc();    // Request JVM to execute Garbage Collector

        // Brief sleep to allow GC thread to output finalize() message if invoked
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
    }
}

/*
 * Sample Output:
 * 
 * =================================================
 *          BANK ACCOUNT TRANSACTION SYSTEM         
 * =================================================
 * Enter Account Number: SB-1002345
 * Enter Account Holder Name: Rohit Chandra
 * Enter Initial Deposit Amount (Min ₹1000.0): 5000
 *  Account created successfully for Rohit Chandra with Balance: ₹5000.0
 * 
 * -----------------------------------------
 *                BANK MENU                 
 * -----------------------------------------
 * 1. Deposit Money
 * 2. Withdraw Money
 * 3. Check Balance
 * 4. Calculate Loan Monthly Installment (EMI)
 * 5. Trigger GC Demo & Exit
 * Enter your choice (1-5): 1
 * Enter deposit amount: ₹2500
 *  Successfully deposited ₹2500.0. Updated Balance: ₹7500.0
 * [TRANSACTION LOG] Transaction ended. Current balance is: ₹7500.0
 * 
 * -----------------------------------------
 *                BANK MENU                 
 * -----------------------------------------
 * 1. Deposit Money
 * 2. Withdraw Money
 * 3. Check Balance
 * 4. Calculate Loan Monthly Installment (EMI)
 * 5. Trigger GC Demo & Exit
 * Enter your choice (1-5): 2
 * Enter withdrawal amount: ₹7000
 * 
 * [TRANSACTION ERROR] Withdrawal of ₹7000.0 failed! Account balance cannot fall below the minimum required balance of ₹1000.0. Current balance: ₹7500.0
 * [TRANSACTION LOG] Transaction ended. Current balance is: ₹7500.0
 * 
 * -----------------------------------------
 *                BANK MENU                 
 * -----------------------------------------
 * 1. Deposit Money
 * 2. Withdraw Money
 * 3. Check Balance
 * 4. Calculate Loan Monthly Installment (EMI)
 * 5. Trigger GC Demo & Exit
 * Enter your choice (1-5): 2
 * Enter withdrawal amount: -500
 * 
 * [INVALID INPUT ERROR] Withdrawal amount must be positive. Provided: ₹-500.0
 * [TRANSACTION LOG] Transaction ended. Current balance is: ₹7500.0
 * 
 * -----------------------------------------
 *                BANK MENU                 
 * -----------------------------------------
 * 1. Deposit Money
 * 2. Withdraw Money
 * 3. Check Balance
 * 4. Calculate Loan Monthly Installment (EMI)
 * 5. Trigger GC Demo & Exit
 * Enter your choice (1-5): 4
 * Enter loan amount: ₹12000
 * Enter number of installment months: 0
 * 
 * [ARITHMETIC ERROR] Division by zero in installment calculation: Number of months cannot be 0.
 * [TRANSACTION LOG] Transaction ended. Current balance is: ₹7500.0
 * 
 * -----------------------------------------
 *                BANK MENU                 
 * -----------------------------------------
 * 1. Deposit Money
 * 2. Withdraw Money
 * 3. Check Balance
 * 4. Calculate Loan Monthly Installment (EMI)
 * 5. Trigger GC Demo & Exit
 * Enter your choice (1-5): 5
 * Logging out from account session...
 * [TRANSACTION LOG] Transaction ended. Current balance is: ₹7500.0
 * 
 * =================================================
 * [MASTER FINALLY] Session closed. Scanner resource released.
 * =================================================
 * 
 * [DEMO] Dereferencing account object for garbage collection demonstration...
 * 
 * [GARBAGE COLLECTION] finalize() invoked for BankAccount [SB-1002345]. Object memory reclaimed.
 */
