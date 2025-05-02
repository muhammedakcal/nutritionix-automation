package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import constants.FrameworkConstants;
import exceptions.NutritionixException;

public class WebFactory {

    private WebFactory() {
        // prevent instantiation
    }

    public static WebDriver getDriver() {
        String browser = FrameworkConstants.BROWSER.toLowerCase();
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.CHROME_DRIVER_PATH);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                return new ChromeDriver(options);
            // You can add more browsers here (firefox, edge, etc.)
            default:
                throw new NutritionixException("Unsupported browser: " + browser);
        }
    }
}
