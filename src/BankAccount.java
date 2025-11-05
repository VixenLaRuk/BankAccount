import java.util.Calendar;
public class BankAccount {

    private String accountNumber;
    private double balance;
    private StringBuilder transactions;
    private int transactionCount;

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