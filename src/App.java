public class App {

    private static void printBalance(BankAccount account) {
        System.out.println("Current Balance: $" + String.format("%.2f", account.getBalance()));
    }
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
        /**
        System.out.println("*****************************************************************************");
        BankAccount account = new BankAccount(100.0);
        System.out.println("New Account Balance: $" + String.format("%.2f", account.getBalance()));
        System.out.println("*****************************************************************************");
        // Withdraw 200 (should fail due to insufficient funds)
        try {
            System.out.println("Withdrawing $200");
            account.withdraw(200.0);
            System.out.println("New Balance: $" + String.format("%.2f", account.getBalance()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("*****************************************************************************");
        }
        // Withdraw -100 (should fail due to negative amount)
        try {
            System.out.println("Withdrawing $-100");
            account.withdraw(-100.0);
            System.out.println("New Balance: $" + String.format("%.2f", account.getBalance()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("*****************************************************************************");
        }
        // Deposit -100 (should fail due to negative amount)
        try {
            System.out.println("Depositing $-100");
            account.deposit(-100.0);
            System.out.println("New Balance: $" + String.format("%.2f", account.getBalance()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("*****************************************************************************");
        }
        // Deposit 1000 (should succeed)
        try {
            System.out.println("Depositing $1000");
            account.deposit(1000.0);
            System.out.println("New Balance: $" + String.format("%.2f", account.getBalance()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Withdraw 2000 (should fail due to insufficient funds)
        System.out.println("*****************************************************************************");
        try {
            System.out.println("Withdrawing $2000");
            account.withdraw(2000.0);
            System.out.println("New Balance: $" + String.format("%.2f", account.getBalance()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("*****************************************************************************");
        }
        // Display the transaction statement
        System.out.println("\nTransaction Statement:");
        System.out.println(account.getStatement());
    }
}
    */