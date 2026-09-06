package bank.system.domain;

public class Account {
    private Customer customer;
    private int accountNumber;
    private int agency;
    private double balance;

    public Account(Customer customer, int accountNumber, int agency) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.agency = agency;
        balance = 0;
    }


    public void deposit(double value) {
        if (value <= 0) {
            System.out.println("Invalid Operation!");
            return;
        }
        this.balance += value;
    }

    public void withdraw(double value) {
        if (value > this.balance || value <= 0) {
            System.out.println("Invalid Operation!");
            return;
        }
        this.balance -= value;
    }

    boolean transfer(Account account, double value) {
        if (account == null || account == this) {
            System.out.println("Invalid Operation!");
            return false;
        }

        if (value <= 0 || value > this.balance) {
            System.out.println("Invalid Operation!");
            return false;
        }
        account.balance += value;
        this.balance -= value;
        return true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAgency() {
        return agency;
    }

    public double getBalance() {
        return balance;
    }
}
