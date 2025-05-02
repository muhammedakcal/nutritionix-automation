package pages.mobile.web;

import base.BasePage;
import utils.MobileActions;
import org.openqa.selenium.By;
import exceptions.NutritionixException;
import io.appium.java_client.AppiumBy;
import java.util.Set;

/**
 * Page object for the Custom Foods screen, providing methods to interact
 * with custom meal creation and confirmation flow.
 */
public class CustomFoodPage extends BasePage {

    private final By MENU_ICON = AppiumBy.accessibilityId("");
    private final By CUSTOM_FOODS_MENU = AppiumBy.accessibilityId("Custom Foods");
    private final By SUBMIT_BUTTON = AppiumBy.accessibilityId("Submit");
    private final By PLUS_BUTTON = AppiumBy.accessibilityId("");

    private static final Set<String> SCROLL_FIELDS = Set.of("Sugars", "Vitamin D");

    public void clickMenuIcon() {
        try {
            waitForVisibility(MENU_ICON);
            click(MENU_ICON);
        } catch (Exception e) {
            throw new NutritionixException("Failed to tap plus button", e);
        }
    }

    /**
     * Taps the "+" button in the Custom Foods header.
     */
    public void tapPlusButton() {
        try {
            waitForVisibility(PLUS_BUTTON);
            MobileActions.tap(mobileDriver, PLUS_BUTTON);
        } catch (Exception e) {
            throw new NutritionixException("Failed to tap add icon", e);
        }
    }

    /**
     * Opens the Custom Foods screen by tapping the menu icon and selecting the option.
     * @param screenName the name of the screen to open
     */
    public void openScreen(String screenName) {
        try {
            clickMenuIcon();
            waitForClickable(CUSTOM_FOODS_MENU);
            MobileActions.tap(mobileDriver, CUSTOM_FOODS_MENU);
        } catch (Exception e) {
            throw new NutritionixException("Failed to open screen: " + screenName, e);
        }
    }

    /**
     * Fills a custom field by its label text.
     * @param fieldLabel the visible label of the field (e.g., "Food Name*", "Serving Info*", "Calories*")
     * @param value the text to enter
     */
    public void fillCustomField(String fieldLabel, String value) {
        try {
            if (SCROLL_FIELDS.contains(fieldLabel)) {
                MobileActions.scrollDown(mobileDriver);
            }
            By locator = AppiumBy.accessibilityId(fieldLabel);
            MobileActions.tapAndType(mobileDriver, locator, value);
        } catch (Exception e) {
            throw new NutritionixException("Failed to fill field " + fieldLabel + " with value " + value, e);
        }
    }

    /**
     * Taps the submit button to add the custom meal.
     */
    public void tapSubmitButton() {
        try {
            MobileActions.tap(mobileDriver, SUBMIT_BUTTON);
        } catch (Exception e) {
            throw new NutritionixException("Failed to tap submit button", e);
        }
    }

    /**
     * Verifies the custom meal appears in the list by its name.
     * @param mealName the name of the custom meal to confirm
     */
    public void confirmCustomMeal(String mealName) {
        try {
            waitForVisibility(AppiumBy.accessibilityId(mealName));
        } catch (Exception e) {
            throw new NutritionixException("Failed to confirm custom meal: " + mealName, e);
        }
    }
}
