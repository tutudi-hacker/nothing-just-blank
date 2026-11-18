package Lab06ex4;

public class BankError extends Exception {
    public BankError(String message) {
        super(message);
    }

    public static void main(String[] args) {
        BankService bank = new BankService();

        try {
            bank.processTransaction("ACC-999", 100.0, "USD");
        } catch (BankError e) {
            System.out.println("Caught " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            bank.processTransaction("ACC-101", 100.0, "EUR");
        } catch (BankError e) {
            System.out.println("Caught " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            bank.processTransaction("ACC-101", 1000.0, "USD");
        } catch (BankError e) {
            System.out.println("Caught " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}

class InsufficientFundsError extends BankError {
    public InsufficientFundsError(String message) {
        super(message);
    }
}

class AccountNotFoundError extends BankError {
    public AccountNotFoundError(String message) {
        super(message);
    }
}

class CurrencyMismatchError extends BankError {
    public CurrencyMismatchError(String message) {
        super(message);
    }
}

class BankService {
    private String validAccount = "ACC-101";
    private String accountCurrency = "USD";
    private double balance = 500.0;

    public void processTransaction(String accountId, double amount, String currency) throws BankError {
        if (!this.validAccount.equals(accountId)) {
            throw new AccountNotFoundError("Account " + accountId + " does not exist.");
        }
        if (!this.accountCurrency.equals(currency)) {
            throw new CurrencyMismatchError("Expected " + this.accountCurrency + " but received " + currency + ".");
        }
        if (amount > this.balance) {
            throw new InsufficientFundsError("Cannot withdraw $" + amount + ". Available balance is $" + this.balance + ".");
        }
        this.balance -= amount;
        System.out.println("Transaction successful. Remaining balance: $" + this.balance);
    }
}
