package fr.epita.bank.datamodel;

public class Customer {
    String name;
    String address;

    public Customer(String custName, String custAddress) {
        this.name = custName;
        this.address = custAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null){
            return;
        }else {
            this.name = name;
        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
