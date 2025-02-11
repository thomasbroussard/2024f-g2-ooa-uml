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
        System.out.println("What would you like to do?");
        System.out.println("1. create a customer");
        //more options later
        System.out.println("9. quit the application");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        List<SavingsAccount> accounts = new ArrayList<>();

        if (answer.equals("1")){
            Customer customer = createCustomerFromUserInput(scanner);
            SavingsAccount savingsFromUserInput = createSavingsFromUserInput(scanner, customer);
            accounts.add(savingsFromUserInput);
        } else if (answer.equals("9")){

        } else {
            System.out.println("option not recognized, try again");
        }

    }
}
