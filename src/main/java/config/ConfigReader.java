
package config;

import constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Reads framework configuration and environment-specific properties.
 */
public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private ConfigReader() {
        // Prevent instantiation
    }

    private static void loadProperties() {
        try {
            // Load main config
            FileInputStream configStream = new FileInputStream(FrameworkConstants.CONFIG_PATH);
            properties.load(configStream);
            configStream.close();

            // Determine environment
            String env = properties.getProperty("environment", "dev").toLowerCase();

            // Load environment-specific properties
            String envPath;
            switch (env) {
                case "dev":
                    envPath = FrameworkConstants.ENV_DEV;
                    break;
                case "qa":
                    envPath = FrameworkConstants.ENV_QA;
                    break;
                case "staging":
                    envPath = FrameworkConstants.ENV_STAGING;
                    break;
                case "production":
                    envPath = FrameworkConstants.ENV_PRODUCTION;
                    break;
                default:
                    throw new RuntimeException("Unsupported environment: " + env);
            }
            FileInputStream envStream = new FileInputStream(envPath);
            properties.load(envStream);
            envStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration files: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieve a property value by key.
     *
     * @param key property name
     * @return property value or null if not found
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
