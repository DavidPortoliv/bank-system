package bank.system.test;

import bank.system.domain.Account;
import bank.system.domain.Bank;
import bank.system.domain.Customer;
import bank.system.view.BankMenu;
import bank.system.view.BankView;

public class BankSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("David", 18, "342523424");
        Customer customer2 = new Customer("Ayumi", 22, "314434232");
        Customer customer3 = new Customer("Jonas", 54, "312321221");
        Account account1 = new Account(customer1, 83193, 1313);
        Account account2 = new Account(customer2, 83192, 3232);
        Account account3 = new Account(customer3, 53253, 2323);
        Bank bank = new Bank("Sicoob");
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.findAccountByNumber(83193).deposit(323);


        bank.transferByNumber(83193, 83192, 221);
        BankMenu bankMenu = new BankMenu(bank);
        bankMenu.startMenu();
    }
}
