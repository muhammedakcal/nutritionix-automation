
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Utility class for common web actions (scrolling, JS click, etc.).
 */
public final class WebActions {

    private WebActions() {
        // Prevent instantiation
    }

    /**
     * Scrolls the page until the given element is in view.
     *
     * @param driver  WebDriver instance
     * @param element WebElement to scroll into view
     */
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs a click on an element using JavaScript.
     *
     * @param driver  WebDriver instance
     * @param element WebElement to click
     */
    public static void jsClick(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", element);
    }
}
