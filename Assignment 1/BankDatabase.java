/*
 * Question: Write a Java program to implement a BankAccount class with operations: 
 * (i) Deposit a certain amount into an account
 * (ii) Withdraw a certain amount from an account
 * (iii) Return a value specifying the amount (i.e. balance) in an account.
 */

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // i. Deposit a certain amount into an account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: Rs. " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // ii. Withdrawing a certain amount from an account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew: Rs. " + amount);
        }
    }

    // iii. Return a value specifying the amount (i.e. balance) in an account
    public double getBalance() {
        return balance;
    }
}

public class BankDatabase {
    public static void main(String[] args) {
        // Create a bank account object
        BankAccount account = new BankAccount("ACC1001", "Rohit Chandra", 5000.0);

        System.out.println("Initial Balance: Rs. " + account.getBalance());

        // i. Deposit
        account.deposit(2000.0);
        System.out.println("Current Balance: Rs. " + account.getBalance());

        // ii. Withdraw
        account.withdraw(1500.0);
        System.out.println("Current Balance: Rs. " + account.getBalance());

        // Test withdrawing more than balance
        account.withdraw(6000.0);
        System.out.println("Final Balance: Rs. " + account.getBalance());
    }
}

/*
Output:
Initial Balance: Rs. 5000.0
Successfully deposited: Rs. 2000.0
Current Balance: Rs. 7000.0
Successfully withdrew: Rs. 1500.0
Current Balance: Rs. 5500.0
Insufficient balance! Withdrawal failed.
Final Balance: Rs. 5500.0
*/
