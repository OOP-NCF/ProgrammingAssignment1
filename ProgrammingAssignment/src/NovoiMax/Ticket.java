package NovoiMax;

public class Ticket {
    private Customer customer;
    private Movie movie;
    private double basePrice = 12.0;

    public Ticket(Customer customer, Movie movie) {
        this.customer = customer;
        this.movie = movie;
    }

    public double calculatePrice() {
        double discountedPrice = basePrice;

        // Apply only one discount based on priority
        if (customer.getAge() < 12) {
            discountedPrice = 6.0;
        } else if (customer.getAge() >= 60) {
            discountedPrice = 8.0;
        } else if (customer.isStudent()) {
            discountedPrice = 9.0;
        }

        // Apply matinee discount if applicable
        if (movie.isMatinee()) {
            discountedPrice -= 2.0;
        }

        // Ensure price doesn't go below 0
        if (discountedPrice < 0) {
            discountedPrice = 0;
        }

        return discountedPrice;
    }

    public void printTicket() {
        System.out.println("\n========================================");
        System.out.println("           TICKET RECEIPT");
        System.out.println("========================================");
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Show Time: " + (movie.isMatinee() ? "Matinee" : "Evening"));
        System.out.println("Customer Age: " + customer.getAge());
        System.out.println("Student: " + (customer.isStudent() ? "Yes" : "No"));
        System.out.println("----------------------------------------");
        System.out.println("Final Price: $" + String.format("%.2f", calculatePrice()));
        System.out.println("========================================\n");
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}