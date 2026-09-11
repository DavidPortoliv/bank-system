package bank.system.view;

import bank.system.domain.Account;
import bank.system.domain.Bank;

public class BankView {

    private Bank bank;

    public BankView(Bank bank) {
        this.bank = bank;
    }

    public void printBalanceAccount(Account account) {
        System.out.println("Customer: " + account.getCustomer().getName());
        System.out.println("Balance: " + account.getBalance());
    }

    public void showMainMenu() {
        System.out.println("Welcome to the <" + bank.getName() + "> bank!");
        System.out.println("Please choose an option below:");
        System.out.println();
        System.out.println("1 - register a account");
        System.out.println("2 - enter your account");
        System.out.println("0 - leave");
    }

    public void showAccountMenu() {
        System.out.println("Welcome!");
        System.out.println("Account Menu");
        System.out.println("Please choose a option down below");
        System.out.println();
        System.out.println("1 - Check balance");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        System.out.println("4 - Transfer");
        System.out.println("0 - Back");
    }
}
