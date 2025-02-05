package fr.epita.bank.datamodel;

public class Account {
    Double balance;
    Customer customer;

    public Account(Double balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
