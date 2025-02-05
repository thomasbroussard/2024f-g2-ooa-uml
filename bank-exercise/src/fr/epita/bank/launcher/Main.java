package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

public class Main {

    public static void main(String[] args) {
        // 1. create a customer named Quentin
        // 2. create a savings account and assign it to Quentin with initial balance set to 500€
        // 3. compute the interests gain (supposing we have had the same amount over a year)
        // 4. increase the balance of the account with the gains
        // 5. Quentin wants to withdraw 300€ then 500€, if the balance is negative a warning should be issued

        //1.
        Customer quentin = new Customer("Quentin", "Paris");

        //2.
        SavingsAccount savingsAccount = new SavingsAccount(500.0, quentin);

        //3.
        Double interestGains = savingsAccount.getInterestRate() * savingsAccount.getBalance();

        //4.
        savingsAccount.setBalance(savingsAccount.getBalance() + interestGains);

        //5.
        System.out.println();


    }
}
