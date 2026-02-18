/**
 * StoreDemo.java
 *
 * This is the "driver" class that runs the program.
 * It creates Store and Customer objects and shows how they work together.
 *
 * Run this file -- it contains the main() method.
 */
public class StoreDemo {

    public static void main(String[] args) {

        // ----- Create the store -----
        Store myStore = new Store("Penny's Tech Shop");

        System.out.println("=== Welcome to " + myStore.getStoreName() + " ===\n");  // GETTER


        // ----- Create some customers -----
        Customer alice = new Customer("Alice Johnson", "alice@email.com", 1001);
        Customer bob   = new Customer("Bob Smith",    "bob@email.com",   1002);


        // ----- Print their starting info -----
        System.out.println("-- New customers created --");
        alice.printInfo();
        bob.printInfo();


        // ----- Send welcome emails (uses getters inside) -----
        myStore.sendWelcomeEmail(alice);
        myStore.sendWelcomeEmail(bob);


        // ----- Alice makes some purchases -----
        System.out.println("\n-- Alice goes shopping --");
        myStore.addPurchase(alice, 49.99);
        myStore.addPurchase(alice, 15.00);


        // ----- Bob makes a purchase -----
        System.out.println("\n-- Bob goes shopping --");
        myStore.addPurchase(bob, 120.00);


        // ----- Apply a discount to Alice -----
        System.out.println("\n-- Applying discount to Alice --");
        myStore.applyDiscount(alice, 10.00);


        // ----- Show what happens when setters REJECT bad data -----
        System.out.println("\n-- Testing setter validation --");

        System.out.println("Trying to set a negative balance on Bob:");
        bob.setBalance(-300.00);

        System.out.println("Trying to set an invalid email on Alice:");
        alice.setEmail("not-an-email");

        System.out.println("Trying to set an empty name on Bob:");
        bob.setName("");


        // ----- Update Alice's email with a valid one -----
        System.out.println("\n-- Updating Alice's email with a valid address --");
        alice.setEmail("alice.johnson@newemail.com");
        System.out.println("Alice's new email: " + alice.getEmail());


        // ----- Final summary -----
        System.out.println("\n=== Final Customer Summary ===");
        alice.printInfo();
        bob.printInfo();
    }
}