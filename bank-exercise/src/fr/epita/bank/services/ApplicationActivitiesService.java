package fr.epita.bank.services;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

import java.util.Scanner;

public class ApplicationActivitiesService {


    public static SavingsAccount createSavingsFromUserInput(Scanner scanner, Customer customer) {
        System.out.println("please enter an account balance (floating point format)");
        Double balance = Double.parseDouble(scanner.nextLine());
        System.out.println("please enter an interest rate (floating point format)");
        Double interestRate = Double.parseDouble(scanner.nextLine());
        SavingsAccount savingsAccount = new SavingsAccount(balance, customer);
        savingsAccount.setInterestRate(interestRate);
        return savingsAccount;
    }

    public static Customer createCustomerFromUserInput(Scanner scanner) {
        System.out.println("please enter a customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("please enter a customer address: ");
        String customerAddress = scanner.nextLine();
        Customer firstCustomer = new Customer(customerName, customerAddress);
        return firstCustomer;
    }
}
