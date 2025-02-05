package fr.epita.bank.datamodel;

public class SavingsAccount extends Account {
    Double interestRate;

    public SavingsAccount(Double balance, Customer customer) {
        super(balance, customer);
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
