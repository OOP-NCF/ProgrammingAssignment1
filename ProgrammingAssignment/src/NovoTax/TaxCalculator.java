package NovoTax;

public class TaxCalculator {

    public double findBracketRate(double income, String filingStatus) {
        double rate = 0;

        if (filingStatus.equals("single")) {
            if (income >= 0 && income <= 10000) {
                rate = 0.10;
            } else if (income > 10000 && income <= 40000) {
                rate = 0.12;
            } else if (income > 40000 && income <= 85000) {
                rate = 0.22;
            } else if (income > 85000) {
                rate = 0.24;
            }
        } else if (filingStatus.equals("married")) {
            if (income >= 0 && income <= 20000) {
                rate = 0.10;
            } else if (income > 20000 && income <= 80000) {
                rate = 0.12;
            } else if (income > 80000 && income <= 170000) {
                rate = 0.22;
            } else if (income > 170000) {
                rate = 0.24;
            }
        }

        return rate;
    }

    public double calculateTax(double income, String filingStatus) {
        double rate = findBracketRate(income, filingStatus);
        double tax = income * rate;
        return tax;
    }

    public String classifyIncome(double income) {
        String category = "";

        if (income < 30000) {
            category = "Low";
        } else if (income >= 30000 && income < 75000) {
            category = "Middle";
        } else {
            category = "High";
        }

        return category;
    }
}
