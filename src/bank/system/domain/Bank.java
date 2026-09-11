package bank.system.domain;

public class Bank {
    private String name;
    private Account[] accounts;
    private int accountCount;
    private int nextAccountNumber;

    public Bank(String name) {
        this.name = name;
        accounts = new Account[10];
        nextAccountNumber = 21962;
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

    public boolean addAccount(Account account) {
        if (account == null) {
            return false;
        }
        if (findAccountByNumber(account.getAccountNumber()) != null) {
            return false;
        }
        if (accountCount >= accounts.length) {
            return false;
        }
        accounts[accountCount] = account;
        accountCount++;
        return true;
    }

    public void nextAccountNumberIncrease() {
        nextAccountNumber++;
    }

    public String getName() {
        return name;
    }

    public int getNextAccountNumber() {
        return nextAccountNumber;
    }

    public int getAccountCount() {
        return accountCount;
    }
}
