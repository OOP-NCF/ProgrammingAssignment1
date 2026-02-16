package NovoPizzaStore;

import java.util.Scanner;

public class PizzaApp {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scnr.nextLine();

        System.out.print("Are you a rewards member? (true/false): ");
        boolean rewards = scnr.nextBoolean();
        scnr.nextLine(); // consume leftover newline

        System.out.print("Enter pizza size (small/medium/large): ");
        String size = scnr.nextLine();

        System.out.print("Enter number of toppings: ");
        int toppings = scnr.nextInt();

        System.out.print("Delivery required? (true/false): ");
        boolean delivery = scnr.nextBoolean();

        // Create objects
        Customer customer = new Customer(name, rewards);
        Pizza pizza = new Pizza(size, toppings, delivery);
        Order order = new Order(customer, pizza);

        // Print receipt
        order.printReceipt();

        scnr.close();
    }
}
