package exercise1;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Tests the Account and Transaction classes by simulating concurrent transactions
public class AccountTest {
    public static void main(String[] args) {
        System.out.println("***** Transaction Details *****\n"); // Prints the header for transaction details

        // Creates an Account object with an initial balance of 5000
        Account account = new Account(5000);

        // Creates a list to hold multiple transactions.
        ArrayList<Transaction> transactionList = new ArrayList<>();

        // Adds various transactions to the list.
        transactionList.add(new Transaction(account, "deposit Amount", 1500)); // Deposit $1500
        transactionList.add(new Transaction(account, "withdraw Amount", 500)); // Withdraw $500
        transactionList.add(new Transaction(account, "withdraw Amount", 35000)); // withdraw $35000 (exceeds balance)
        transactionList.add(new Transaction(account, "deposit Amount", 150)); // Deposit $150

        // Creates a thread pool with a fixed number of threads to execute transactions concurrently
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submits each transaction in the list to the executor for execution
        for (Transaction transaction : transactionList) {
            executor.execute(transaction);
        }

        // Shuts down the executor to prevent further task submissions
        executor.shutdown();
    }
}



