package Demo3;

/**
 * MovieTicket.java
 *
 * Represents a single movie ticket that can be booked or cancelled.
 *
 * Notice:
 *   - isBooked has NO setter -- only bookTicket() and cancelTicket()
 *     can change it. This protects the booking logic.
 *   - seatNumber must be 1 or greater
 *   - price cannot be negative
 */
public class MovieTicket {

    // -------------------------
    // FIELDS
    // -------------------------
    private String  movieTitle;
    private String  customerName;
    private int     seatNumber;
    private double  price;
    private boolean isBooked;


    // -------------------------
    // CONSTRUCTOR
    // -------------------------
    /**
     * Creates a new ticket for a movie at a given price.
     * The ticket starts unbooked -- no customer or seat yet.
     */
    public MovieTicket(String movieTitle, double price) {
        this.movieTitle    = movieTitle;
        this.price         = price;
        this.customerName  = "None";
        this.seatNumber    = 0;
        this.isBooked      = false;   // always starts unbooked
    }


    // -------------------------
    // GETTERS
    // -------------------------
    public String getMovieTitle() {
        return movieTitle;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsBooked() {
        return isBooked;
    }


    // -------------------------
    // SETTERS
    // -------------------------
    public void setMovieTitle(String movieTitle) {
        if (movieTitle == null || movieTitle.isEmpty()) {
            System.out.println("Error: Movie title cannot be empty.");
            return;
        }
        this.movieTitle = movieTitle;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.isEmpty()) {
            System.out.println("Error: Customer name cannot be empty.");
            return;
        }
        this.customerName = customerName;
    }

    public void setSeatNumber(int seatNumber) {
        if (seatNumber < 1) {
            System.out.println("Error: Seat number must be 1 or greater. Got: " + seatNumber);
            return;
        }
        this.seatNumber = seatNumber;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Error: Price cannot be negative. Got: $" + price);
            return;
        }
        this.price = price;
    }

    // NOTE: There is NO setIsBooked().
    // isBooked should only change through bookTicket() and cancelTicket().
    // If it were a plain setter, someone could write setIsBooked(true)
    // without ever assigning a customer or seat -- broken data!


    // -------------------------
    // BOOKING METHODS
    // -------------------------

    /**
     * Books this ticket for a customer at a given seat.
     * Does nothing if the ticket is already booked.
     */
    public void bookTicket(String customerName, int seatNumber) {
        if (isBooked) {
            System.out.println("Sorry! This ticket for '" + movieTitle
                    + "' is already booked by " + this.customerName + ".");
            return;
        }

        // Use our own setters so the validation runs here too
        setCustomerName(customerName);
        setSeatNumber(seatNumber);
        this.isBooked = true;

        System.out.println("Booking confirmed!");
        System.out.println("  Movie    : " + movieTitle);
        System.out.println("  Customer : " + this.customerName);
        System.out.println("  Seat     : " + this.seatNumber);
        System.out.printf( "  Price    : $%.2f%n", price);
    }

    /**
     * Cancels the booking and resets the ticket back to available.
     * Does nothing if the ticket was not booked.
     */
    public void cancelTicket() {
        if (!isBooked) {
            System.out.println("Cannot cancel -- ticket for '" + movieTitle
                    + "' was not booked.");
            return;
        }

        System.out.println("Cancellation confirmed for " + customerName
                + " ('" + movieTitle + "', Seat " + seatNumber + ").");

        // Reset back to defaults
        this.customerName = "None";
        this.seatNumber   = 0;
        this.isBooked     = false;
    }

    /**
     * Prints the current status of this ticket.
     */
    public void printStatus() {
        System.out.println("-------------------------------");
        System.out.println("Movie    : " + movieTitle);
        System.out.printf( "Price    : $%.2f%n", price);

        if (isBooked) {
            System.out.println("Status   : BOOKED");
            System.out.println("Customer : " + customerName);
            System.out.println("Seat     : " + seatNumber);
        } else {
            System.out.println("Status   : AVAILABLE");
        }

        System.out.println("-------------------------------");
    }
}