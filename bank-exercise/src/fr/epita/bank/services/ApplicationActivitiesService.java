package fr.epita.bank.services;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

import java.util.List;
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

    public static void customersToCsv(List<Customer> customers) {
        System.out.println("Printing the list of customers");
        System.out.println("name,address");
        customers.forEach(System.out::println);
    }

    public static void withdrawMoney(Scanner scanner, SavingsAccount savingsAccount){
        System.out.println("Input the amount:");
        Integer amount = Integer.parseInt(scanner.nextLine());
        Double balance = savingsAccount.getBalance();
        if (balance < amount){
            System.out.println("insufficient balance, the current balance is : " + balance +" you requested :" + amount);
        } else {
            savingsAccount.setBalance(balance - amount);
        }
    }
}
