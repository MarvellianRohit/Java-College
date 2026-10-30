/*
 * Q7: Create a tightly encapsulated class BankAccount. Keep data fields like accountNumber and
 * balance strictly private. Provide public getter and setter methods. Ensure the setter method
 * validates the input (e.g., rejecting negative deposits) before updating the balance.
 */

class BankAccount {
    private String accountNumber;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        if (amount >= 0) {
            this.balance += amount;
            System.out.println("Deposited: Rs. " + amount);
        } else {
            System.out.println("Invalid amount! Negative deposits are rejected.");
        }
    }
}

public class Q7_BankAccountEncapsulation {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.setAccountNumber("ACC12345");
        acc.setBalance(5000);
        acc.setBalance(-1500); // Rejected by validation

        System.out.println("Account Number: " + acc.getAccountNumber());
        System.out.println("Current Balance: Rs. " + acc.getBalance());
    }
}

/*
Output:
Deposited: Rs. 5000.0
Invalid amount! Negative deposits are rejected.
Account Number: ACC12345
Current Balance: Rs. 5000.0
*/

