package configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;
    private  static Logger logger = LogManager.getLogger(ReadProperties.class);

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }
    public static long getTimeout() {
        return Long.parseLong(properties.getProperty("timeout"));
    }
    public static String browserName() {
        return properties.getProperty("browser");
    }
    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
}
