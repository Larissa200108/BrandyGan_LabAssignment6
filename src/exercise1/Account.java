package exercise1;

// Account class that represents a bank account with basic operations
public class Account {
    // balance private field to store the account balance
    private double balance;

    // Constructor to initialize the account with an initial balance
    public Account(double initialBalance) {
        balance = initialBalance;
    }
    // Adds a specified amount to the account balance. Synchronized for thread safety
    public synchronized void deposit(double amount) {
        balance += amount; // Increase the balance by the deposit amount
        System.out.println("Amount deposited: $" + amount +
                " --> Current Balance: $" + balance);
    }
    // Deducts a specified amount from the account balance if there is enough funds. Synchronized for thread safety
    public synchronized void withdraw(double amount) {
        if (amount <= balance) { // Check if sufficient funds are available
            balance -= amount; // Decrease the balance by the withdrawal amount
            System.out.println("Amount withdrawn: $" + amount +
                    " --> Current Balance: $" + balance);
        } else {
            // Print a message if funds are insufficient
            System.out.println("Insufficient Funds: $" + amount);
        }
    }
    // Returns the current account balance
    public double getBalance() {
        return balance;
    }
}

