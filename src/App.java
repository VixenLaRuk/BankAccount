/**
 * The App class serves as the entry point for a bank account simulation program.
 * This program uses the BankAccount class to perform transactions and logs results
 * with serpartors for better readability. It includes test for valid and invalid operations.
 * 
 * @author Vixen La Ruk
 * @author Isaiah Johnson
 * @since 11/04/2025
 */
public class App {

    /**
     * Prints the current balance of the given BankAccount to the console.
     * Formats the balance to two decimal places for currency display.
     * 
     * @param account the BankAccount instance whose balance is to be printed
     */
    private static void printBalance(BankAccount account) {
        System.out.println("Current Balance: $" + String.format("%.2f", account.getBalance()));
    }
    /**
     * The main method initializes a BankAccount and performs a series of transactions,
     * including deposits, withdrawals, and error cases. It prints operation results,
     * balances, and finally an account summary and full transaction statement.
     * 
     * Operations include:
     * -Depositing $1000.00
     * -Withdrawing $200.00
     * -Attempting to withdraw $900.00 (insufficient funds)
     * -Attempting to deposit -$50.00 (invalid amount)
     * -Attempting to withdraw -$100.00 (invalid amount)
     * 
     * Each operation is wrapped in try-catch for error handling, with suggestions provided.
     * 
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {

        BankAccount account = new BankAccount("123456", 0.0);
        // Enhanced: Added separators and descriptive prints for better output flow
        System.out.println("=== Starting Bank Account Simulation ===");
        // Deposit operation with improved feedback
        try {
            System.out.println("Operation: Depositing $1000.00");
            account.deposit(1000.0);
            System.out.println("Success!");
            printBalance(account);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " Suggestion: Ensure amount is positive.");
        }
        System.out.println("---");
        try {
            System.out.println("Operation: Withdrawing $200.00");
            account.withdraw(200.0);
            System.out.println("Success!");
            printBalance(account);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " Suggestion: Deposit more funds.");
        }
        System.out.println("---");
        // Another withdrawal to test error handling
        try {
            System.out.println("Operation: Withdrawing $900.00");
            account.withdraw(900.0);
            System.out.println("Success!");
            printBalance(account);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " Suggestion: Deposit more funds.");
        }
        System.out.println("---");

        try {
            System.out.println("Operation: Attempting to Deposit -$50.00 (negative amount)");
            account.deposit(-50.0);
            System.out.println("Success!");
            printBalance(account);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " Suggestion: Ensure amount is positive.");
        }
        System.out.println("---");

        try {
            System.out.println("Operation: Attempting to withdraw -$100.00 (negative amount)");
            account.withdraw(-100.0);
            System.out.println("Success!");
            printBalance(account);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " Suggestion: Ensure amount is positive.");
        }
        System.out.println("---");

        // Added: Print summary before full statement for overview
        System.out.println("=== Account Summary ===");
        System.out.println(account.getSummary());
        System.out.println("=== Full Transaction Statement ===");
        System.out.println(account.getStatement());
    }
}