package fr.epita.bank.services;

import fr.epita.bank.datamodel.Customer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CSVService {

    public List<Customer> readCustomersFromCSV() throws IOException {
        List<String> lines = Files.readAllLines(new File("export.csv").toPath());
        lines.remove(0); //do not deal with the headers
        List<Customer> customers = new ArrayList<>();
        for (String line : lines){
            //split over ","
            String[] parts = line.split(",");

            //create a customer instance
            //first element will be stored in the instance name
            //second element will be stored in the instance address
            Customer customer = new Customer(parts[0], parts[1]);
            customers.add(customer);
        }
        return customers;
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
