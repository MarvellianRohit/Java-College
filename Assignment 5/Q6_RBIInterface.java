/*
 * Q6: Define an interface RBI with methods findInterestRate() and checkBalanceLimit().
 * Create two classes, SBI and HDFC, that implement this interface. Show that fields declared inside
 * the interface are implicitly public static final by trying to modify them, and explain the
 * result.
 */

interface RBI {
    double MIN_BALANCE = 1000.0; // Implicitly public, static, and final

    void findInterestRate();
    void checkBalanceLimit();
}

class SBI implements RBI {
    @Override
    public void findInterestRate() {
        System.out.println("SBI Interest Rate: 6.5% p.a.");
    }

    @Override
    public void checkBalanceLimit() {
        System.out.println("SBI Minimum Balance Limit: Rs. " + MIN_BALANCE);
    }
}

class HDFC implements RBI {
    @Override
    public void findInterestRate() {
        System.out.println("HDFC Interest Rate: 7.0% p.a.");
    }

    @Override
    public void checkBalanceLimit() {
        System.out.println("HDFC Minimum Balance Limit: Rs. " + MIN_BALANCE);
    }
}

public class Q6_RBIInterface {
    public static void main(String[] args) {
        SBI sbi = new SBI();
        HDFC hdfc = new HDFC();

        sbi.findInterestRate();
        sbi.checkBalanceLimit();

        hdfc.findInterestRate();
        hdfc.checkBalanceLimit();

        // Trying to modify the interface field causes a compile-time error:
        // RBI.MIN_BALANCE = 2000.0; // Error: cannot assign a value to final variable MIN_BALANCE
        System.out.println("\nExplanation: Interface fields are implicitly 'public static final' constants, so they cannot be modified.");
    }
}

/*
Output:
SBI Interest Rate: 6.5% p.a.
SBI Minimum Balance Limit: Rs. 1000.0
HDFC Interest Rate: 7.0% p.a.
HDFC Minimum Balance Limit: Rs. 1000.0

Explanation: Interface fields are implicitly 'public static final' constants, so they cannot be modified.
*/

