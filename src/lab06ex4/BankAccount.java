package lab06ex4;

public class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("ACC-98765", 2500.00, 3.5);
        savings.displayAccountDetails();
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: $" + this.balance);
        System.out.println("Interest Rate: " + this.interestRate + "%");
    }
}
