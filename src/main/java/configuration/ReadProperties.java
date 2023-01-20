package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String browserName() {
        return properties.getProperty("browser");
    }

    public static String userName() {
        return properties.getProperty("username");
    }

    public static String firstName() {
        return properties.getProperty("firstname");
    }

    public static String secondName() {
        return properties.getProperty("secondname");
    }

    public static String zipCode() {
        return properties.getProperty("zipcode");
    }


    public static String password() {
        return properties.getProperty("password");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
}
