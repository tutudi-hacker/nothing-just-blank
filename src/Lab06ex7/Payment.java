package Lab06ex7;

public abstract class Payment {
    public abstract void process_payment(double amount);

    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment("1234-5678-9012-3456");
        Payment payPal = new PayPalPayment("user@example.com");
        Payment bankTransfer = new BankTransferPayment("ACC-00112233");

        creditCard.process_payment(120.50);
        payPal.process_payment(75.00);
        bankTransfer.process_payment(450.00);
    }
}

class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void process_payment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " using card " + this.cardNumber);
    }
}

class PayPalPayment extends Payment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void process_payment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " from account " + this.email);
    }
}

class BankTransferPayment extends Payment {
    private String bankAccount;

    public BankTransferPayment(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void process_payment(double amount) {
        System.out.println("Processing bank transfer of $" + amount + " from account " + this.bankAccount);
    }
}
