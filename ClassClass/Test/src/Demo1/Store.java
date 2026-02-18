/**
 * Store.java
 *
 * This class shows HOW and WHY you use the Customer class.
 * Notice that Store never touches Customer's private fields directly.
 * Everything goes through getters and setters -- that is the point!
 */
public class Store {

    // The store's name (just a simple field for context)
    private String storeName;


    // -------------------------
    // CONSTRUCTOR
    // -------------------------
    public Store(String storeName) {
        this.storeName = storeName;
    }


    // -------------------------
    // GETTER
    // -------------------------
    public String getStoreName() {
        return storeName;
    }


    // -------------------------
    // METHODS THAT USE Customer
    // -------------------------

    /**
     * Adds a purchase amount to a customer's balance.
     * Uses getBalance() to read the current balance,
     * then setBalance() to update it.
     */
    public void addPurchase(Customer customer, double amount) {
        if (amount <= 0) {
            System.out.println("Purchase amount must be positive.");
            return;
        }

        double currentBalance = customer.getBalance();        // GETTER
        double newBalance     = currentBalance + amount;
        customer.setBalance(newBalance);                      // SETTER

        System.out.println(customer.getName() + " bought $"  // GETTER
                + String.format("%.2f", amount)
                + " worth of goods. New balance: $"
                + String.format("%.2f", customer.getBalance())); // GETTER
    }

    /**
     * Applies a discount by reducing the customer's balance.
     * Again -- only uses getBalance() and setBalance(), never the field itself.
     */
    public void applyDiscount(Customer customer, double discountAmount) {
        double currentBalance = customer.getBalance();        // GETTER

        if (discountAmount > currentBalance) {
            System.out.println("Discount is larger than the balance. Setting balance to $0.00.");
            customer.setBalance(0.00);                        // SETTER
        } else {
            customer.setBalance(currentBalance - discountAmount); // GETTER + SETTER
            System.out.println("Discount of $" + String.format("%.2f", discountAmount)
                    + " applied to " + customer.getName() + "."); // GETTER
        }
    }

    /**
     * Sends a welcome email -- we read the name and email via getters.
     */
    public void sendWelcomeEmail(Customer customer) {
        System.out.println("\n Sending email to: " + customer.getEmail()); // GETTER
        System.out.println("   Subject: Welcome to " + storeName + ", " + customer.getName() + "!"); // GETTER
        System.out.println("   Your customer ID is: " + customer.getCustomerId()); // GETTER
    }
}