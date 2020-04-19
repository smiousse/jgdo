package io.github.smiousse.jgdo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.smiousse.jgdo.utils.ApplicationPropertyManager;

/**
 * @author smiousse
 *
 */
public class Bootstrap {

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    public static String APP_HOME = "../";

    public static void main(String[] args) {

        intEnvProperties();
    }

    /**
     * 
     */
    private static void intEnvProperties() {

        try {
            if (System.getProperty(ApplicationPropertyManager.ENV_HOME_LOCATION) == null
                    || System.getProperty(ApplicationPropertyManager.ENV_HOME_LOCATION).isEmpty()) {
                System.setProperty(ApplicationPropertyManager.ENV_HOME_LOCATION, Bootstrap.class.getResource("../../../../").getFile());
            }
            System.setProperty(ApplicationPropertyManager.ENV_PROPERTY_FILE_LOCATION,
                    System.getProperty(ApplicationPropertyManager.ENV_HOME_LOCATION) + "application.properties");

            System.out.println("ENV_HOME_LOCATION = " + System.getProperty(ApplicationPropertyManager.ENV_HOME_LOCATION));
            System.out.println("ENV_PROPERTY_FILE_LOCATION = " + System.getProperty(ApplicationPropertyManager.ENV_PROPERTY_FILE_LOCATION));

            ApplicationPropertyManager.loadApplicationProperties();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
