import java.util.Calendar;
/**
 * This program simulates banking transactions and prints an account
 * summary and also a full transaction statement.
 * 
 * The BankAccount class manages a bank account with features for depositing,
 * withdrawing, checking balance, and generating transaction statements and summaries.
 * It uses a StringBuilder to efficiently log transactions with timestamps.
 * 
 * @author Vixen La Ruk
 * @author Isaiah Johnson
 * @since 11/04/2025
 */
public class BankAccount {

    private String accountNumber;
    private double balance;
    private StringBuilder transactions;
    private int transactionCount;

    /**
     * Constructs a new BankAccount with the specified account number and initial balance.
     * Initializes the transaction log with the account creation event.
     * 
     * @param accountNumber the unique account number for this account
     * @param initialBalance the starting balance, must be non-negative
     */
    public BankAccount(String accountNumber, double initialBalance) { // default constructor
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new StringBuilder();
        this.transactionCount = 0;
        transactions.append("Account created with initial balance: $")
                .append(String.format("%.2f", initialBalance))
                .append(" on ").append(Calendar.getInstance().getTime())
                .append("\n");

    }

    /**
     * Constructs a new BankAccount with a default account number ("000000") and the specified initial balance.
     * This is a convenience constructor that calls the primary constructor.
     * 
     * @param initialBalance the starting balance, must be non-negative
     */
    public BankAccount(double initialBalance) {
        this("000000", initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        Calendar cal = Calendar.getInstance();
        transactions.append("Transaction ").append(++transactionCount).append(": Deposit: $")
                .append(String.format("%.2f", amount))
                .append(" on ").append(cal.getTime()).append("\n");
    }

    /**
     * 
     * @param amount
     * @return
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (balance < amount) {
            throw new IllegalStateException("Insufficient funds. Available balance: $" + 
            String.format("%.2f", balance)
             + ", Requested: $" + String.format("%.2f", amount));
        }
        balance -= amount;
        Calendar cal = Calendar.getInstance();
        transactions.append("Transaction ").append(++transactionCount).append(": Withdraw: $")
                .append(String.format("%.2f", amount))
                .append(" on ").append(cal.getTime()).append("\n");
    }

    public double getBalance() {
        return balance;
    }

    public String getStatement() {
        return transactions.toString();
    }

    public String getSummary() {
        return "Account: " + accountNumber + "\nBalance: $" + 
        String.format("%.2f", balance) + "\nTotal Transactions: " + transactionCount;
    }
}