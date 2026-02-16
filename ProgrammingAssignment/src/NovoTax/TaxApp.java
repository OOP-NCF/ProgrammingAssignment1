package NovoTax;

import java.util.Scanner;

public class TaxApp {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        TaxCalculator calculator = new TaxCalculator();

        System.out.println("========== INCOME TAX CALCULATOR ==========\n");

        boolean continueProcessing = true;

        while (continueProcessing) {
            System.out.print("Enter taxpayer name: ");
            String name = scnr.nextLine();

            System.out.print("Enter annual income: ");
            double income = scnr.nextDouble();

            scnr.nextLine();

            System.out.print("Enter filing status (single/married): ");
            String filingStatus = scnr.nextLine();

            TaxPayer taxpayer = new TaxPayer(name, income, filingStatus);

            double bracketRate = calculator.findBracketRate(taxpayer.income, taxpayer.filingStatus);
            double estimatedTax = calculator.calculateTax(taxpayer.income, taxpayer.filingStatus);
            String incomeCategory = calculator.classifyIncome(taxpayer.income);

            System.out.println("\n========== TAX SUMMARY ==========");
            System.out.println("Name: " + taxpayer.name);
            System.out.println("Income: $" + taxpayer.income);
            System.out.println("Filing Status: " + taxpayer.filingStatus);
            System.out.println("Bracket Rate: " + (bracketRate * 100) + "%");
            System.out.println("Estimated Tax: $" + estimatedTax);
            System.out.println("Income Category: " + incomeCategory);
            System.out.println("================================\n");

            System.out.print("Process another taxpayer? (true/false): ");
            continueProcessing = scnr.nextBoolean();
            scnr.nextLine();
        }

        System.out.println("Thank you for using the Tax Calculator!");
        scnr.close();
    }
}