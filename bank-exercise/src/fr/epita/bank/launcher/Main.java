package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

import java.util.Scanner;

import static fr.epita.bank.services.AccountService.computeInterestGains;
import static fr.epita.bank.services.AccountService.increaseBalance;
import static fr.epita.bank.services.ApplicationActivitiesService.createCustomerFromUserInput;
import static fr.epita.bank.services.ApplicationActivitiesService.createSavingsFromUserInput;

public class Main {

    public static void main(String[] args) {
        // 1. create a customer named Quentin
        // 2. create a savings account and assign it to Quentin with initial balance set to 500€
        // 3. compute the interests gain (supposing we have had the same amount over a year)
        // 4. increase the balance of the account with the gains
        // 5. Quentin wants to withdraw 300€ then 500€, if the balance is negative a warning should be issued

        Scanner scanner = new Scanner(System.in);


        //1.
        Customer firstCustomer = createCustomerFromUserInput(scanner);

        //2.
        SavingsAccount savingsAccount = createSavingsFromUserInput(scanner, firstCustomer);

        //3.
        Double interestGains = computeInterestGains(savingsAccount);

        //4.
        increaseBalance(savingsAccount, interestGains);

        //5.
        System.out.println();


        //TODO find a usecase involving stocks, stock orders, investment account.
    }



}
