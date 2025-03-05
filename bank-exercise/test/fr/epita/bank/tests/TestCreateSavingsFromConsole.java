package fr.epita.bank.tests;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.services.ApplicationActivitiesService;

import java.util.Scanner;

public class TestCreateSavingsFromConsole {


    public static void main(String[] args) {
        Customer customer = new Customer("test", "test");
        Scanner scanner = new Scanner(System.in);
        ApplicationActivitiesService activitiesService = new ApplicationActivitiesService(scanner);
        activitiesService.createSavingsFromUserInput(customer);

    }
}
