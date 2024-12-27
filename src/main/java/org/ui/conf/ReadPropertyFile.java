package org.ui.conf;

import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

    Properties properties = new Properties();

    public String getPropertyByValue(String key) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
