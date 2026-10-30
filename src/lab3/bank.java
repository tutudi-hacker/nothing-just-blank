package lab3;

import java.util.Scanner;

class BankCustomer {
    String accountNumber; 
    String name;
    double balance;

    BankCustomer(String accountNumber, String name, double initialBalance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f. New Balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.printf("Transaction Failed! Insufficient balance. Available: $%.2f\n", balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f. New Balance: $%.2f\n", amount, balance);
        }
    }

    void displayDetails() {
        System.out.printf("Acc No: %s | Name: %s | Current Balance: $%.2f\n", accountNumber, name, balance);
    }
}

public class bank { // Matches your filename bank.java perfectly
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers (N): ");
        int n = sc.nextInt();
        sc.nextLine(); 

        BankCustomer[] customers = new BankCustomer[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Customer " + (i + 1) + " Setup ---");
            System.out.print("Enter 14-digit Account Number: ");
            String accNum = sc.nextLine();
            
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine(); 

            customers[i] = new BankCustomer(accNum, name, balance);
        }

        boolean running = true;
        while (running) {
            System.out.println("\n===== BANKING OPERATIONS =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 4) {
                running = false;
                System.out.println("Thank you for using the banking system!");
                break;
            }

            if (choice == 3) {
                System.out.println("\n--- All Customer Details ---");
                for (BankCustomer c : customers) {
                    c.displayDetails();
                }
                continue;
            }

            System.out.print("Enter the 14-digit Account Number for transaction: ");
            String searchAcc = sc.nextLine();
            
            BankCustomer targetCustomer = null;
            for (BankCustomer c : customers) {
                if (c.accountNumber.equals(searchAcc)) {
                    targetCustomer = c;
                    break;
                }
            }

            if (targetCustomer == null) {
                System.out.println("Account number not found!");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                double amount = sc.nextDouble();
                targetCustomer.deposit(amount);
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double amount = sc.nextDouble();
                targetCustomer.withdraw(amount);
            }
        }
        sc.close();
    }
}

