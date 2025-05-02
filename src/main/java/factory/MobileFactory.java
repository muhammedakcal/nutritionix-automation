package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import platform.PlatformManager;
import platform.enums.PlatformType;
import constants.FrameworkConstants;
import exceptions.NutritionixException;

import java.io.File;
import java.net.URL;
import java.util.Map;

public class MobileFactory {
    public static AppiumDriver getDriver() {
        PlatformType platformType = PlatformManager.getPlatform();
        try {
            switch (platformType) {
                case ANDROID:
                    ObjectMapper androidMapper = new ObjectMapper();
                    Map<String, Object> androidCaps = androidMapper.readValue(
                            new File("src/main/resources/capabilities/android_caps.json"),
                            Map.class
                    );
                    UiAutomator2Options androidOptions = new UiAutomator2Options();
                    androidCaps.forEach(androidOptions::setCapability);

                    return new AndroidDriver(
                            new URL(FrameworkConstants.APPIUM_SERVER_URL),
                            androidOptions
                    );
                case IOS:
                    ObjectMapper iosMapper = new ObjectMapper();
                    Map<String, Object> iosCaps = iosMapper.readValue(
                            new File("src/main/resources/capabilities/ios_caps.json"),
                            Map.class
                    );
                    XCUITestOptions iosOptions = new XCUITestOptions();
                    iosCaps.forEach(iosOptions::setCapability);

                    return new IOSDriver(
                            new URL(FrameworkConstants.APPIUM_SERVER_URL),
                            iosOptions
                    );
                default:
                    throw new NutritionixException("Unsupported platform: " + platformType);
            }
        } catch (Exception e) {
            throw new NutritionixException("Driver init error: " + e.getMessage(), e);
        }
    }
}