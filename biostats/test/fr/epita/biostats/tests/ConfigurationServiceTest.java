package fr.epita.biostats.tests;

import fr.epita.biostats.services.ConfigurationService;

public class ConfigurationServiceTest {

    public static void main(String[] args) {
        // Get the singleton instance
        ConfigurationService configService = ConfigurationService.getInstance();

        // Test retrieving a known property
        String testKey = "db.url";
        String testValue = configService.getProperty(testKey);
        System.out.println("Value for key '" + testKey + "': " + testValue);

        // Test retrieving a property with a default value
        String defaultKey = "non.existing.key";
        String defaultValue = "default_value";
        String retrievedValue = configService.getPropertyOrDefault(defaultKey, defaultValue);
        System.out.println("Value for key '" + defaultKey + "' (with default): " + retrievedValue);
    }
}

