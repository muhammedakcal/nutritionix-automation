package constants;

/**
 * Centralized constants for the Nutritionix automation framework.
 */
public final class FrameworkConstants {

    // --------------------------------------
    // Appium Server Configuration
    // --------------------------------------
    public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    // --------------------------------------
    // Android Application Under Test
    // --------------------------------------
    public static final String ANDROID_APP_PACKAGE = "com.nutritionix.app";
    public static final String ANDROID_APP_ACTIVITY = "com.nutritionix.app.MainActivity";

    // --------------------------------------
    // iOS Application Under Test
    // --------------------------------------
    public static final String IOS_BUNDLE_ID = "com.nutritionix.iosapp";

    // --------------------------------------
    // Selenium WebDriver Configuration
    // --------------------------------------
    public static final String BROWSER = "chrome";
    public static final String CHROME_DRIVER_PATH = "drivers/chromedriver";  // relative path under project root

    // --------------------------------------
    // Timeouts (in seconds)
    // --------------------------------------
    public static final long IMPLICIT_WAIT = 10L;
    public static final long EXPLICIT_WAIT = 20L;
    public static final long PAGE_LOAD_TIMEOUT = 30L;

    // --------------------------------------
    // Environment Files (under src/main/resources/environments)
    // --------------------------------------
    public static final String ENV_DEV = "src/main/resources/environments/dev.properties";
    public static final String ENV_QA = "src/main/resources/environments/qa.properties";
    public static final String ENV_STAGING = "src/main/resources/environments/staging.properties";
    public static final String ENV_PRODUCTION = "src/main/resources/environments/production.properties";
    public static final String CONFIG_PATH = "src/main/resources/config.properties";
    // Prevent instantiation

    private FrameworkConstants() {
        throw new UnsupportedOperationException("FrameworkConstants is a utility class and cannot be instantiated");
    }
}
