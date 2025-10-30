public class BankAccount {

    private double balance;
    StringBuilder transactions;

    BankAccount() { // default constructor
        balance = 0.0;
        transactions = new StringBuilder();

    }

    BankAccount(double amount) {
        balance = amount;
        transactions = new StringBuilder();
    }

    int deposit(double amount) {
        if (amount < 0) {
            return -1;
        }
        else {
            balance += amount;
            return 1;
        }
    }

    /**
     * 
     * @param amount
     * @return
     */
    int withdraw(double amount) throws Exception {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return 1;
        }
        else {
            return -1;
        }
    }

    void temp() {
        
    }

    void temp2() {
        int hi = 1;
    }
}
