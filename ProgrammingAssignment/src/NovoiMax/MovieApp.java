package NovoiMax;

import java.util.Scanner;

public class MovieApp {

    public static void main(String[] args) {

        System.out.println("=========== WELCOME TO NOVO CINEMA ===========");
        System.out.println("                NOW PLAYING");
        System.out.println("----------------------------------------------");
        System.out.println("1. LOTR       - 1:00 PM, 4:00 PM, 7:00 PM");
        System.out.println("2. Harry Potter        - 12:30 PM, 3:30 PM, 6:30 PM");
        System.out.println("3. Avatar    - 2:00 PM, 5:00 PM, 8:00 PM");
        System.out.println("----------------------------------------------");

        System.out.println("\n============= TICKET PRICING =============");
        System.out.println("Base Price: $12.00");
        System.out.println("Children under 12: $6.00");
        System.out.println("Seniors (60+): $8.00");
        System.out.println("Students: $9.00");
        System.out.println("Matinee Discount: -$2.00");
        System.out.println("Only ONE age/student discount applies.");
        System.out.println("===========================================\n");

        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter movie title: ");
        String title = scnr.nextLine();

        // Check if movie is valid
        boolean isValidMovie = title.equals("LOTR") || title.equals("Harry Potter") || title.equals("Avatar");

        if (!isValidMovie) {
            System.out.println("Invalid movie title. Please choose from: LOTR, Harry Potter, or Avatar");
            scnr.close();
            return;
        }

        System.out.print("Is this a matinee showing? (true/false): ");
        boolean matinee = scnr.nextBoolean();

        System.out.print("Enter customer age: ");
        int age = scnr.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        boolean student = scnr.nextBoolean();

        // Create objects
        Customer customer = new Customer(age, student);
        Movie movie = new Movie(title, matinee);
        Ticket ticket = new Ticket(customer, movie);

        // Print final ticket
        ticket.printTicket();

        scnr.close();
    }
}