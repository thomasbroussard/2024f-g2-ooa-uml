package fr.epita.bank.services;

import fr.epita.bank.datamodel.Customer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CSVService {

    public List<Customer> readCustomersFromCSV(){
        List<String> lines = Files.readAllLines(new File("export.csv").toPath());
        //TODO implement
        return null;
    }

    public void exportCustomerToCSV(List<Customer> customersList) throws IOException {
        String csv = customersToCSVContent(customersList);
        Files.writeString(new File("export.csv").toPath(), csv);
    }

    public String customersToCSVContent(List<Customer> customers) {
        String result = "name,address";
        for (Customer customer: customers){
            result = result + System.lineSeparator() + customer.toString();
        }
        return result;
    }

}
