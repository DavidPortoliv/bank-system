package bank.system.domain;

public class Bank {
    private String name;
    private Account[] accounts;
    private int accountCount;

    public Bank(String name) {
        this.name = name;
        accounts = new Account[10];
    }

    public Account findAccountByNumber(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public boolean transferByNumber(int accountNumberOrigin, int accountNumberDestiny, double value) {
        Account origin = findAccountByNumber(accountNumberOrigin);
        Account destiny = findAccountByNumber(accountNumberDestiny);
        if (origin == null || destiny == null) {
            return false;
        }
        return origin.transfer(destiny, value);
    }

    public void addAccount(Account account) {
        if (account == null) {
            System.out.println("Invalid action");
            return;
        }

        if (findAccountByNumber(account.getAccountNumber()) != null) {
            System.out.println("Account already exists");
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

    public int getAccountCount() {
        return accountCount;
    }

    public Account[] getAccounts() {
        return accounts;
    }
}
