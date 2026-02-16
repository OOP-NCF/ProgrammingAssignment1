package NovoPizzaStore;

public class Pizza {

    private String size;      // small, medium, large
    private int toppings;
    private boolean delivery;

    public Pizza(String size, int toppings, boolean delivery) {
        this.size = size.toLowerCase();
        this.toppings = toppings;
        this.delivery = delivery;
    }

    public String getSize() {
        return size;
    }

    public int getToppings() {
        return toppings;
    }

    public boolean isDelivery() {
        return delivery;
    }
}

