package Demo1;
public class Customer {

    // -------------------------
    // FIELDS  (all private)
    // -------------------------
    private String name;
    private String email;
    private int customerId;
    private double balance;


    // -------------------------
    // CONSTRUCTOR
    // -------------------------
    /**
     * Creates a new Customer.
     * The balance always starts at 0.00 -- a customer cannot be
     * created with a pre-loaded (or negative) balance.
     */
    public Customer(String name, String email, int customerId) {
        this.name       = name;
        this.email      = email;
        this.customerId = customerId;
        this.balance    = 0.00;   // every new customer starts at zero
    }


    // -------------------------
    // GETTERS  (read the data)
    // -------------------------

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }


    // -------------------------
    // SETTERS  (change the data)
    // -------------------------

    public void setName(String name) {
        // Guard: reject an empty or null name
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Name cannot be empty. Name was not changed.");
            return;
        }
        this.name = name;
    }

    public void setEmail(String email) {
        // Guard: a very basic check -- a real app would do more
        if (email == null || !email.contains("@")) {
            System.out.println("Error: '" + email + "' is not a valid email. Email was not changed.");
            return;
        }
        this.email = email;
    }

    // NOTE: We intentionally have NO setCustomerId().
    // Once a customer is created, their ID should never change.
    // Not providing a setter is itself a form of protection!

    public void setBalance(double balance) {
        // Guard: we do not allow a negative balance
        if (balance < 0) {
            System.out.println("Error: Balance cannot be negative. Balance was not changed.");
            return;
        }
        this.balance = balance;
    }


    // -------------------------
    // HELPER METHOD
    // -------------------------

    /**
     * Prints a neat summary of this customer's information.
     */
    public void printInfo() {
        System.out.println("-------------------------------");
        System.out.println("Customer ID : " + customerId);
        System.out.println("Name        : " + name);
        System.out.println("Email       : " + email);
        System.out.printf( "Balance     : $%.2f%n", balance);
        System.out.println("-------------------------------");
    }
}