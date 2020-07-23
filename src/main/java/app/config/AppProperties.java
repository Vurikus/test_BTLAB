package app.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppProperties {

    private static Properties properties = new Properties();
    private final static Logger logger = Logger.getLogger(AppProperties.class.getName());

    public AppProperties() {
    }

    public static Properties getProperties(){
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, null, e);
        }
        return properties;

    }

    public static void setProperties(Properties properties) {
        AppProperties.properties = properties;
    }
}
