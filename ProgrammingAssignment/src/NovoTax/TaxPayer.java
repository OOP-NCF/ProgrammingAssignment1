package NovoTax;

public class TaxPayer {
    public String name;
    public double income;
    public String filingStatus;

    public TaxPayer(String name, double income, String filingStatus) {
        this.name = name;
        this.income = income;
        this.filingStatus = filingStatus;
    }
}