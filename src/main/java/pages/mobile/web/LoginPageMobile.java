package pages.mobile.web;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;

/**
 * Mobile (iOS) login page object.
 */
public class LoginPageMobile extends BasePage {

    // Locator definitions
    private static final By USERNAME_FIELD = By.id("usernameInput");
    private static final By PASSWORD_FIELD = By.id("passwordInput");
    private static final By LOGIN_BUTTON   = By.id("loginButton");

    // Locator for Track page title
    private static final By TRACK_TITLE = AppiumBy.xpath("//XCUIElementTypeApplication[@name='Track']");

    /**
     * Enter username into the username field.
     */
    public void enterUsername(String username) {
        sendKeys(USERNAME_FIELD, username);
    }

    /**
     * Enter password into the password field.
     */
    public void enterPassword(String password) {
        sendKeys(PASSWORD_FIELD, password);
    }

    /**
     * Tap the login button to submit credentials.
     */
    public void tapLogin() {
        click(LOGIN_BUTTON);
    }

    public String getHeaderText() {
        return findElement(TRACK_TITLE).getText();
    }
    /**
     * Verifies that the Track page is visible by checking the Track title element.
     *
     * @return true if the Track title is displayed, false otherwise
     */
    public boolean isTrackPageVisible() {
        try {
            WebElement el = findElement(TRACK_TITLE);
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
