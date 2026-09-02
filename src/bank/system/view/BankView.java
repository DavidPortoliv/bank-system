package bank.system.view;

import bank.system.domain.Bank;

public class BankView {

    private Bank bank;

    public BankView(Bank bank) {
        this.bank = bank;
    }

    public void printAccounts() {
        for (int i = 0; i < bank.getAccountCount(); i++) {
            System.out.println("Customer: " + bank.getAccounts()[i].getCustomer().getName());
            System.out.println("Account: " + bank.getAccounts()[i].getAccountNumber());
            System.out.println("Agency: " + bank.getAccounts()[i].getAgency());
            System.out.println();
        }
    }
}
