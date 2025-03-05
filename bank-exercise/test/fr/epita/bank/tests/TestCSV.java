package fr.epita.bank.tests;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.services.ApplicationActivitiesService;
import fr.epita.bank.services.CSVService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestCSV {

    public static void main(String[] args) throws IOException {
        //testCSVContent();

        CSVService service = new CSVService();

        Customer customer1 = new Customer("a", "Paris");
        Customer customer2 = new Customer("b", "Marseille");
        Customer customer3 = new Customer("c", "Toulouse");
        Customer customer4 = new Customer("d", "Bordeaux");
        Customer customer5 = new Customer("e", "Lyon");

        List<Customer> customers = List.of(customer1, customer2, customer3, customer4, customer5);

        service.exportCustomerToCSV(customers);

    }

    private static void testCSVContent() {
        Customer customer1 = new Customer("a", "Paris");
        Customer customer2 = new Customer("b", "Marseille");
        Customer customer3 = new Customer("c", "Toulouse");
        Customer customer4 = new Customer("d", "Bordeaux");
        Customer customer5 = new Customer("e", "Lyon");

        List<Customer> customers = List.of(customer1, customer2, customer3, customer4, customer5);
        ApplicationActivitiesService activitiesService = new ApplicationActivitiesService(new Scanner(System.in));
        activitiesService.customersToCsv(customers);
    }


}
