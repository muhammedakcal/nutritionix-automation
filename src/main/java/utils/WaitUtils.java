package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.FrameworkConstants;
import java.time.Duration;
import exceptions.NutritionixException;

/**
 * Utility class for explicit wait operations.
 */
public final class WaitUtils {

    private WaitUtils() {
        // Prevent instantiation
    }

    /**
     * Waits until the element located by the given locator is visible.
     *
     * @param driver  WebDriver instance (can be AppiumDriver or WebDriver)
     * @param locator element locator
     * @return the visible WebElement
     */
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new NutritionixException("Timeout waiting for visibility of locator: " + locator, e);
        }
    }
}
