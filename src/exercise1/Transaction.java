package exercise1;

// Transaction class Represents a transaction that can be executed on an account
public class Transaction implements Runnable {
    // The account on which the transaction will be performed
    public Account account;

    // The type of transaction: "deposit amount" or "withdraw amount"
    public String transactionType;

    // The amount involved in the transaction
    public double transactionAmount;

    // Initializes a transaction with the specified account, type, and amount
    public Transaction(Account account, String transactionType, double transactionAmount) {
        this.account = account; // Associates the transaction with the given account
        this.transactionType = transactionType; // Sets the type of transaction
        this.transactionAmount = transactionAmount; // Sets the transaction amount
    }

    // Executes the transaction. Depending on the type, either deposits or withdraws the amount
    public void run() {
        if (transactionType.equalsIgnoreCase("Deposit amount")) {
            account.deposit(transactionAmount); // Executes a deposit operation
        } else if (transactionType.equalsIgnoreCase("Withdraw amount")) {
            account.withdraw(transactionAmount); // Executes a withdrawal operation
        } else {
            System.out.println("Invalid Transaction."); // Handles invalid transaction
        }
    }
}
