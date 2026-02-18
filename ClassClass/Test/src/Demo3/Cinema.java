package Demo3;

/**
 * Cinema.java
 *
 * Uses the MovieTicket class to simulate a small cinema booking system.
 * Run this file -- it contains the main() method.
 */
public class Cinema {

    public static void main(String[] args) {

        // ----- Create two tickets for different movies -----
        MovieTicket ticket1 = new MovieTicket("Inception",    12.99);
        MovieTicket ticket2 = new MovieTicket("The Lion King", 9.99);


        // ----- Print starting status -- both should be AVAILABLE -----
        System.out.println("=== Starting Ticket Status ===");
        ticket1.printStatus();
        ticket2.printStatus();


        // ----- Book both tickets -----
        System.out.println("=== Booking Tickets ===");
        ticket1.bookTicket("Alice Johnson", 14);
        System.out.println();
        ticket2.bookTicket("Bob Smith", 7);


        // ----- Try to book ticket1 again -- already taken -----
        System.out.println("\n=== Trying to Double-Book Ticket 1 ===");
        ticket1.bookTicket("Carol Davis", 14);


        // ----- Cancel ticket2 -----
        System.out.println("\n=== Cancelling Bob's Ticket ===");
        ticket2.cancelTicket();


        // ----- Try to set a negative price -----
        System.out.println("\n=== Testing Setter Validation ===");
        System.out.println("Trying to set a negative price on ticket1:");
        ticket1.setPrice(-5.00);   // ❌ setter will reject this

        System.out.println("Trying to set seat number 0 on ticket2:");
        ticket2.setSeatNumber(0);  // ❌ setter will reject this


        // ----- Book ticket2 again for a new customer -----
        System.out.println("\n=== Booking the Cancelled Ticket for a New Customer ===");
        ticket2.bookTicket("Carol Davis", 3);


        // ----- Final status of both tickets -----
        System.out.println("\n=== Final Ticket Status ===");
        ticket1.printStatus();
        ticket2.printStatus();
    }
}