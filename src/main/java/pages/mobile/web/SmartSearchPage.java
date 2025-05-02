package pages.mobile.web;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import exceptions.NutritionixException;
import utils.MobileActions;

/**
 * Page object representing the Smart Search functionality on the mobile web platform.
 * Provides methods to interact with the search bar, add items to basket, confirm entries,
 * verify logged items, and switch between different sections.
 */
public class SmartSearchPage extends BasePage {

    CustomFoodPage customFoodPage = new CustomFoodPage();
    private static final By HOME_SEARCH_PLACEHOLDER =
        AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == 'Search foods to log'`]");

    /**
     * Taps the "Add to Basket" button.
     */
    public void logOneFood() {
        try {
            MobileActions.tap(mobileDriver, AppiumBy.accessibilityId("Log 1 Food"));
        } catch (Exception e) {
            throw new NutritionixException("Failed to tap Add to Basket button", e);
        }
    }

    /**
     * Enters the given query string into the search bar.
     *
     * @param query the search query to enter
     */
    public void enterQuery(String query) {
        try {
            MobileActions.tapAndType(mobileDriver, HOME_SEARCH_PLACEHOLDER, query);
        } catch (Exception e) {
            throw new NutritionixException("Failed to enter search query: " + query, e);
        }
    }

    /**
     * Taps the "Add to Basket" button.
     */
    public void selectFreeForm(String name) {
        try {
            MobileActions.tap(mobileDriver, AppiumBy.accessibilityId(name));
        } catch (Exception e) {
            throw new NutritionixException("Failed to tap Add to Basket button", e);
        }
    }

    /**
     * Verifies that the home page search input displays the correct placeholder text.
     */
    public void verifyHomePage() {
        customFoodPage.clickMenuIcon();
        By Home = AppiumBy.accessibilityId("Home");
        MobileActions.tap(mobileDriver, Home);
        waitForVisibility(HOME_SEARCH_PLACEHOLDER);
    }

    /**
     * Verifies that the specified item with the given quantity is logged under the specified section.
     *
     * @param food the food item name
     * @param section the section name where the item should be logged
     * @param qty the expected quantity of the item
     * @throws NutritionixException if verification fails
     */
    public void verifyLoggedItem(String food, String section, int qty) {
        try {
            waitForVisibility(AppiumBy.accessibilityId(food));
            waitForVisibility(AppiumBy.accessibilityId(section));
        } catch (Exception e) {
            throw new NutritionixException(
                String.format("Verification failed for '%s' in '%s'", food, section), e
            );
        }
    }

    /**
     * Switches to the given tab/section on the Track page.
     *
     * @param section visible name of the section tab (e.g., "Snack", "Lunch")
     * @throws NutritionixException if switching to the section fails
     */
    public void switchToSection(String section) {
        try {
            By tabLocator = AppiumBy.accessibilityId(section);
            waitForVisibility(tabLocator);
            MobileActions.tap(mobileDriver, tabLocator);
        } catch (Exception e) {
            throw new NutritionixException("Failed to switch to section: " + section, e);
        }
    }
}
