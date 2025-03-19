package fr.epita.biostats.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ConfigurationService {

    Properties properties = new Properties();

    private static ConfigurationService instance;


    public static ConfigurationService getInstance() {
        synchronized (ConfigurationService.class) {
            if (instance == null) {
                instance = new ConfigurationService();
            }
        }
        return instance;
    }

    private ConfigurationService()  {
        try {
            FileInputStream inStream = new FileInputStream("biostats/configuration.properties");
            properties.load(inStream);
            inStream.close();
        } catch (IOException e){
            throw new IllegalStateException(e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getPropertyOrDefault(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }




}
