package utils;

import exceptions.NutritionixException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import constants.FrameworkConstants;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility methods for common mobile gestures and interactions using Appium.
 */
public final class MobileActions {

    private MobileActions() {
        // Prevent instantiation
    }

    /**
     * Performs a tap on the element located by the given locator.
     */
    public static void tap(AppiumDriver driver, By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        } catch (Exception e) {
            throw new NutritionixException("Failed to tap element: " + locator, e);
        }
    }

    /**
     * Taps the given element, clears and types text.
     */
    public static void tapAndType(AppiumDriver driver, By locator, String text) {
        try {
            WebElement element = driver.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new NutritionixException("Failed to tap and type into element: " + locator, e);
        }
    }

    /**
     * Hides the on-screen keyboard if it is present.
     */
    public static void hideKeyboard(AppiumDriver driver) {
        try {
            ((HidesKeyboard) driver).hideKeyboard();
        } catch (Exception e) {
            throw new NutritionixException("Failed to hide keyboard", e);
        }
    }

    /**
     * Performs a long press on the element for the specified duration.
     */
    public static void longPress(AppiumDriver driver, By locator, Duration duration) {
        try {
            WebElement element = driver.findElement(locator);
            new TouchAction((PerformsTouchActions) driver)
                    .longPress(LongPressOptions.longPressOptions()
                            .withElement(ElementOption.element(element))
                            .withDuration(duration))
                    .release()
                    .perform();
        } catch (Exception e) {
            throw new NutritionixException("Failed to long press element: " + locator, e);
        }
    }

    /**
     * Swipes vertically from startY to endY at the given x coordinate.
     */
    public static void swipeVertical(AppiumDriver driver, int startY, int endY, int x) {
        try {
            new TouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(x, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(x, endY))
                    .release()
                    .perform();
        } catch (Exception e) {
            throw new NutritionixException(
                    "Failed to swipe vertically from " + startY + " to " + endY + " at x=" + x, e);
        }
    }

    /**
     * Scrolls until an element with the given visible text is found.
     */
    public static void scrollToText(AppiumDriver driver, String visibleText) {
        try {
            Map<String, Object> args = new HashMap<>();
            args.put("direction", "down");
            args.put("name", visibleText);
            driver.executeScript("mobile: scroll", args);
        } catch (Exception e) {
            throw new NutritionixException("Failed to scroll to text: " + visibleText, e);
        }
    }

    public static void scrollDown(AppiumDriver driver) {
        try {
            Map<String, Object> args = new HashMap<>();
            args.put("direction", "up");
            driver.executeScript("mobile: swipe", args);
        } catch (Exception e) {
            throw new NutritionixException("Failed to scroll down on iOS", e);
        }
    }
}
