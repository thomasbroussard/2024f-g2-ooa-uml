package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;
import static fr.epita.bank.services.ApplicationActivitiesService.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to this bank application");
        List<SavingsAccount> accounts = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        String answer = "";
        do {
            System.out.println("What would you like to do?");
            System.out.println("1. create a customer");
            System.out.println("2. withdraw money");
            System.out.println("3. print list of customers");
            System.out.println("9. quit the application");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();
            if (answer.equals("1")) {
                Customer customer = createCustomerFromUserInput(scanner);
                customers.add(customer);
                SavingsAccount savingsFromUserInput = createSavingsFromUserInput(scanner, customer);
                accounts.add(savingsFromUserInput);
                //TODO add customer in a customers list
            } else if (answer.equals("2")) {
                //account selection before, take the first account for now
                withdrawMoney(scanner, accounts.get(0));
            } else if (answer.equals("3")){
                customersToCsv(customers);
            } else {

                System.out.println("option not recognized, try again");
            }
        }while (!"9".equals(answer));

    }


}
