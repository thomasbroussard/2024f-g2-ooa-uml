package fr.epita.biostats.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationService {

    Properties properties = new Properties();

    public ConfigurationService()  {
        try {
            FileInputStream inStream = new FileInputStream("biostats/configuration.properties");
            properties.load(inStream);
            inStream.close();
        } catch (IOException e){
            throw new IllegalStateException(e);
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }


}
