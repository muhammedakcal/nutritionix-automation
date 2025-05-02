package pages.mobile.web;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Mobile (iOS) home page object for Nutritionix.
 */
public class HomePageMobile extends BasePage {

    // Locator definitions (replace with actual IDs)
    private static final By SMART_SEARCH_FIELD = By.id("smartSearchInput");
    private static final By CUSTOM_MEAL_BUTTON = By.id("customMealButton");
    private static final By DAILY_SUMMARY_VIEW  = By.id("dailySummaryView");

    /**
     * Search for a food item using smart search.
     */
    public void searchFood(String query) {
        sendKeys(SMART_SEARCH_FIELD, query);
        click(By.id("searchButton"));
    }

    /**
     * Tap to create a custom meal.
     */
    public void openCustomMeal() {
        click(CUSTOM_MEAL_BUTTON);
    }

    /**
     * Get the daily summary text.
     */
    public String getDailySummary() {
        return getText(DAILY_SUMMARY_VIEW);
    }
}
