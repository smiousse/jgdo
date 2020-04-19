package io.github.smiousse.jgdo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author smiousse
 * @version $Rev$ $Date$
 */
public class ApplicationPropertyManager {

    public static final String ENV_HOME_LOCATION = "jgdo.home.path";
    public static final String ENV_PROPERTY_FILE_LOCATION = "jgdo.env.application.property.file";

    // private static final Logger log = LoggerFactory.getLogger(ApplicationPropertyManager.class);
    private static final String DEFAULT_APP_PROPERTIES_FILENAME = "default.properties";
    private static Properties appProperties;

    /**
     * Reads the default.properties and application.properties files and stores
     * the values in a static variable. Use
     * ApplicationPropertyManager.getApplicationProperties to get the
     * properties.
     * 
     * @throws Exception
     */
    public static void loadApplicationProperties() throws Exception {

        // load default properties
        InputStream in = ApplicationPropertyManager.class.getResourceAsStream(DEFAULT_APP_PROPERTIES_FILENAME);

        // Reset variable with default values
        Properties defaultProperties = new Properties();
        defaultProperties.load(in);

        // Check for overrides in application.properties
        File applicationPropertiesFile = new File(System.getProperty(ENV_PROPERTY_FILE_LOCATION));
        if (applicationPropertiesFile != null && applicationPropertiesFile.exists()) {
            System.out.println("Loading properties from file '" + System.getProperty(ENV_PROPERTY_FILE_LOCATION) + "'");

            Properties overrideProps = new Properties(defaultProperties);
            overrideProps.load(new FileInputStream(applicationPropertiesFile));
            appProperties = overrideProps;
        } else {
            appProperties = defaultProperties;
        }

    }

    /**
     * Get the properties for the application.
     * 
     * @return
     * @throws Exception
     */
    public static Properties getApplicationProperties() throws Exception {
        if (appProperties == null) {
            loadApplicationProperties();
        }
        return appProperties;
    }

    /**
     * @param propertyName
     * @return
     */
    public static String getApplicationPropertyValue(String propertyName) {
        return getApplicationPropertyValue(propertyName, "");
    }

    /**
     * Read a property from the application properties.
     * 
     * @param propertyName
     * @return
     */
    public static String getApplicationPropertyValue(String propertyName, String defaultValue) {
        try {
            Properties properties = getApplicationProperties();
            return properties.getProperty(propertyName, defaultValue);
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

}
