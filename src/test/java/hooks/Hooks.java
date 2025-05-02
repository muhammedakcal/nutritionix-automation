package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.Base64;
import config.ConfigReader;
import managers.DriverManager;
import platform.PlatformManager;
import platform.enums.PlatformType;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;

/**
 * Cucumber hooks to manage driver setup and teardown per scenario.
 */
public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Read desired platform from config (e.g., "ios", "android", "web")
        String platformName = ConfigReader.getProperty("platform");
        PlatformManager.setPlatform(PlatformType.valueOf(platformName.toUpperCase()));

        // Initialize the driver for the selected platform
        driver = (WebDriver) DriverFactory.createInstance();
        DriverManager.setDriver(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        if (driver != null) {
            driver.quit();
        }
        PlatformManager.unloadPlatform();
        DriverManager.unload();
    }
}
