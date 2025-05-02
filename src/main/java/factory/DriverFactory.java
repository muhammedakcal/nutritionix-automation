package factory;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;
import platform.PlatformManager;
import platform.enums.PlatformType;
import exceptions.NutritionixException;

public class DriverFactory {

    private DriverFactory() {
        // private constructor to prevent instantiation
    }

    public static Object createInstance() {
        PlatformType platformType = PlatformManager.getPlatform();

        switch (platformType) {
            case WEB:
                return WebFactory.getDriver();
            case ANDROID:
            case IOS:
                return MobileFactory.getDriver();
            default:
                throw new NutritionixException("Unsupported platform: " + platformType);
        }
    }
}
