package bank.system.domain;

public class Bank {
    private String name;
    private Account[] accounts;
    private int accountCount;


    public Bank(String name) {
        this.name = name;
        accounts = new Account[10];
    }

    public void printAccounts() {
        for (int i = 0; i < accountCount; i++) {
            System.out.println("Customer: " + accounts[i].getCustomer().getName());
            System.out.println("Account: " + accounts[i].getAccountNumber());
            System.out.println("Agency: " + accounts[i].getAgency());
            System.out.println();
        }
    }

    public Account findAccountByNumber(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void addAccount(Account account) {
        if (account == null) {
            System.out.println("Invalid action");
            return;
        }
        if (accountCount >= accounts.length) {
            System.out.println("Bank is full");
            return;
        }

        accounts[accountCount] = account;
        accountCount++;
    }

    public String getName() {
        return name;
    }
}
