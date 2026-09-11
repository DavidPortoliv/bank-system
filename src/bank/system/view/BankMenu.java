package bank.system.view;

import bank.system.domain.Account;
import bank.system.domain.Bank;
import bank.system.domain.Customer;

import java.util.Scanner;

public class BankMenu {
    private Scanner scanner;
    private Bank bank;
    private BankView bankView;
    private boolean running = true;

    public BankMenu(Bank bank) {
        this.bank = bank;
        this.bankView = new BankView(this.bank);
        this.scanner = new Scanner(System.in);
    }

    public void startMenu() {
        while (running) {
            bankView.showMainMenu();
            int optionMainMenu = scanner.nextInt();
            scanner.nextLine();
            switch (optionMainMenu) {
                case 1:
                    registerAccount();
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Exiting Bank...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Option");
                    System.out.println("Please select again");
            }
        }
    }

    private void registerAccount() {
        String customerName;
        int customerAge;
        String customerCpf;
        int agencyNumber = 1000;
        System.out.println("Type your name");
        customerName = scanner.nextLine();
        System.out.println("Type your age");
        customerAge = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Type your CPF");
        customerCpf = scanner.nextLine();

        Customer customer = new Customer(customerName, customerAge, customerCpf);
        Account account = new Account(customer, bank.getNextAccountNumber(), agencyNumber);

        boolean accountAdded = bank.addAccount(account);

        if (!accountAdded) {
            System.out.println("Invalid account creation");
            return;
        }
        System.out.println("Congratulations! Account added");
        System.out.println("Number of account " + account.getAccountNumber());
        bank.nextAccountNumberIncrease();


    }
}
