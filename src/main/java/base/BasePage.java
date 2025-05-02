package base;

import io.appium.java_client.AppiumDriver;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.enums.PlatformType;
import platform.PlatformManager;
import constants.FrameworkConstants;
import exceptions.NutritionixException;
import java.time.Duration;


public class BasePage {

    protected WebDriver webDriver;
    protected AppiumDriver mobileDriver;
    protected PlatformType platformType;

    public BasePage() {
        this.platformType = PlatformManager.getPlatform();
        try {
            Object driver = DriverManager.getDriver();
            switch (platformType) {
                case WEB:
                    this.webDriver = (WebDriver) driver;
                    break;
                case ANDROID:
                case IOS:
                    this.mobileDriver = (AppiumDriver) driver;
                    break;
                default:
                    throw new NutritionixException("Unsupported platform: " + platformType);
            }
        } catch (Exception e) {
            throw new NutritionixException("Failed to initialize driver: " + e.getMessage(), e);
        }
    }

    protected WebElement findElement(By locator) {
        switch (platformType) {
            case WEB:
                return webDriver.findElement(locator);
            case ANDROID:
            case IOS:
                return mobileDriver.findElement(locator);
            default:
                throw new NutritionixException("Unsupported platform for finding element: " + platformType);
        }
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected WebElement waitForVisibility(By locator) {
        WebDriverWait wait;
        switch (platformType) {
            case WEB:
                wait = new WebDriverWait(webDriver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
                break;
            case ANDROID:
            case IOS:
                wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
                break;
            default:
                throw new NutritionixException("Unsupported platform for wait operation: " + platformType);
        }
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until the element located by the given locator is clickable.
     *
     * @param locator element locator
     * @return the clickable WebElement
     */
    protected WebElement waitForClickable(By locator) {
        WebDriverWait wait;
        switch (platformType) {
            case WEB:
                wait = new WebDriverWait(webDriver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
                break;
            case ANDROID:
            case IOS:
                wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
                break;
            default:
                throw new NutritionixException("Unsupported platform for wait operation: " + platformType);
        }
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
