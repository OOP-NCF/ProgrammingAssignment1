package NovoPizzaStore;

public class Order {

    private Customer customer;
    private Pizza pizza;

    public Order(Customer customer, Pizza pizza) {
        this.customer = customer;
        this.pizza = pizza;
    }

    public double calculateTotal() {
        double basePrice = 0.0;

        // Determine base price based on size
        if (pizza.getSize().equals("small")) {
            basePrice = 8.00;
        }
        else if (pizza.getSize().equals("medium")) {
            basePrice = 10.00;
        }
        else if (pizza.getSize().equals("large")) {
            basePrice = 12.00;
        }
        else {
            System.out.println("Invalid size entered. Defaulting to medium price.");
            basePrice = 10.00;
        }

        double toppingsCost = pizza.getToppings() * 1.50;

        double deliveryFee = 0.0;
        if (pizza.isDelivery()) {
            deliveryFee = 3.00;
        }

        double subtotal = basePrice + toppingsCost + deliveryFee;

        // Apply rewards discount
        if (customer.isRewardsMember()) {
            subtotal = subtotal * 0.90;  // 10% discount
        }

        return subtotal;
    }

    public void printReceipt() {
        System.out.println("\n------ PIZZA RECEIPT ------");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Rewards Member: " + customer.isRewardsMember());
        System.out.println("Size: " + pizza.getSize());
        System.out.println("Toppings: " + pizza.getToppings());
        System.out.println("Delivery: " + pizza.isDelivery());
        System.out.printf("Total Price: $%.2f%n", calculateTotal());
        System.out.println("----------------------------");
    }
}
