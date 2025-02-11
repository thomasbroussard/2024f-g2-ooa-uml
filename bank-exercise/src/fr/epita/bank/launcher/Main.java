package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1. create a customer named Quentin
        // 2. create a savings account and assign it to Quentin with initial balance set to 500€
        // 3. compute the interests gain (supposing we have had the same amount over a year)
        // 4. increase the balance of the account with the gains
        // 5. Quentin wants to withdraw 300€ then 500€, if the balance is negative a warning should be issued

        System.out.println("please input the customer name");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("you have input this : "  + line);

        //1.
        Customer firstCustomer = createCustomerFromUserInput(scanner);

        //2.
        System.out.println("please enter an account balance (floating point format)");
        Double balance = Double.parseDouble(scanner.nextLine());
        System.out.println("please enter an interest rate (floating point format)");
        Double interestRate = Double.parseDouble(scanner.nextLine());
        SavingsAccount savingsAccount = new SavingsAccount(balance, firstCustomer);
        savingsAccount.setInterestRate(interestRate);

        //3.
        Double interestGains = savingsAccount.getInterestRate() * savingsAccount.getBalance();

        //4.
        savingsAccount.setBalance(savingsAccount.getBalance() + interestGains);

        //5.
        System.out.println();


        //TODO find a usecase involving stocks, stock orders, investment account.
    }

    private static Customer createCustomerFromUserInput(Scanner scanner) {
        System.out.println("please enter a customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("please enter a customer address: ");
        String customerAddress = scanner.nextLine();
        Customer firstCustomer = new Customer(customerName, customerAddress);
        return firstCustomer;
    }
}
