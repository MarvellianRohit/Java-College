/*
 * Q10: Create a scenario demonstrating both types of polymorphism:
 * - Compile-Time (Overloading): Create a class BillCalculator with overloaded
 *   methods computeBill(double itemPrice), computeBill(double itemPrice,
 *   double discount), and computeBill(double itemPrice, double discount,
 *   double tax).
 * - Runtime (Overriding): Create a base class PaymentMode with a method
 *   processPayment(). Override it in subclasses CreditCardPayment and UPICallback
 *   to change execution behavior at runtime via dynamic method dispatch.
 */

class BillCalculator {
    double computeBill(double itemPrice) {
        return itemPrice;
    }

    double computeBill(double itemPrice, double discount) {
        return itemPrice - discount;
    }

    double computeBill(double itemPrice, double discount, double tax) {
        return (itemPrice - discount) + tax;
    }
}

class PaymentMode {
    void processPayment() {
        System.out.println("Processing generic payment...");
    }
}

class CreditCardPayment extends PaymentMode {
    @Override
    void processPayment() {
        System.out.println("Payment processed via Credit Card.");
    }
}

class UPICallback extends PaymentMode {
    @Override
    void processPayment() {
        System.out.println("Payment processed via UPI Callback.");
    }
}

public class Q10_PolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("--- Compile-Time Polymorphism (Overloading) ---");
        BillCalculator calc = new BillCalculator();
        System.out.println("Bill (Price only): Rs. " + calc.computeBill(1000));
        System.out.println("Bill (With Discount): Rs. " + calc.computeBill(1000, 100));
        System.out.println("Bill (With Discount & Tax): Rs. " + calc.computeBill(1000, 100, 50));

        System.out.println("\n--- Runtime Polymorphism (Overriding) ---");
        PaymentMode payment;
        payment = new CreditCardPayment();
        payment.processPayment();

        payment = new UPICallback();
        payment.processPayment();
    }
}

/*
Output:
--- Compile-Time Polymorphism (Overloading) ---
Bill (Price only): Rs. 1000.0
Bill (With Discount): Rs. 900.0
Bill (With Discount & Tax): Rs. 950.0

--- Runtime Polymorphism (Overriding) ---
Payment processed via Credit Card.
Payment processed via UPI Callback.
*/

