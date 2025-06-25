package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
public class ConfigurationReader {
    private static final Properties CONFIG_FILE;
    private static final String PATH = System.getProperty("user.dir") + "/configuration.properties";

    static {
        try {
            FileInputStream input = new FileInputStream(PATH);
            CONFIG_FILE = new Properties();
            CONFIG_FILE.load(input);
            input.close();

        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     * This method returns property value from configuration.properties file
     *
     * @param keyName property name
     * @return property value
     */
    public  static String getProperty(String keyName) {
        return CONFIG_FILE.getProperty(keyName);
    }

    /**
     * Sets the value of a property in the configuration.properties file.
     *
     * @param key   The key of the property to set.
     * @param value The value to set for the property.
     */
    public static void setProperty(String key, String value) {
        try {
            FileOutputStream output = new FileOutputStream(PATH);
            CONFIG_FILE.setProperty(key, value);
            CONFIG_FILE.store(output, null);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to set property in properties file!");
        }
    }
}

