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
                    enterAccount();
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

    private void enterAccount() {
        System.out.println("Please type your Account Number");
        int enteredAccountNumber = scanner.nextInt();
        scanner.nextLine();
        Account account = bank.findAccountByNumber(enteredAccountNumber);
        if (account == null) {
            System.out.println("Incorrect Number!");
            return;
        }
        System.out.println("Welcome " + account.getCustomer().getName());
        startAccountMenu(account);
    }

    private void startAccountMenu(Account account) {
        boolean accountMenuRunning = true;
        while (accountMenuRunning) {
            bankView.showAccountMenu();
            int optionAccountMenu = scanner.nextInt();
            scanner.nextLine();
            switch (optionAccountMenu) {
                case 1:
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Type a value to deposit");
                    double valueDeposit = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(valueDeposit);
                    System.out.println("Successful operation!");
                    System.out.println("Updated balance: " + account.getBalance());
                    break;
                case 3:
                    System.out.println("Type a value to withdraw");
                    double valueWithdraw = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(valueWithdraw);
                    System.out.println("Successful operation!");
                    System.out.println("Updated balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Type the number of the account you would like to transfer");
                    int destinationAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Type a value to transfer");
                    double valueTransfer = scanner.nextDouble();
                    scanner.nextLine();
                    if (!bank.transferByNumber(account.getAccountNumber(), destinationAccountNumber, valueTransfer)) {
                        System.out.println("Operation failed!");
                        break;
                    }
                    System.out.println("Successful operation!");
                    System.out.println("Updated balance: " + account.getBalance());
                    break;
                case 0:
                    System.out.println("Previous Menu...");
                    accountMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid option!");
                    System.out.println("Type again");
            }
        }
    }
}
