package fr.epita.bank.services;

import fr.epita.bank.datamodel.SavingsAccount;

public class AccountService {

    public static void increaseBalance(SavingsAccount savingsAccount, Double interestGains) {
        savingsAccount.setBalance(savingsAccount.getBalance() + interestGains);
    }

    public static double computeInterestGains(SavingsAccount savingsAccount) {
        return savingsAccount.getInterestRate() * savingsAccount.getBalance();
    }

}
