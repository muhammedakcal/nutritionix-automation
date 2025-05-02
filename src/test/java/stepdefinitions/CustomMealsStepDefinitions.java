package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pages.mobile.web.CustomFoodPage;
import java.util.Map;


public class CustomMealsStepDefinitions {
    private final CustomFoodPage customFoodPage = new CustomFoodPage();

    @Given("I open the {string} screen")
    public void iOpenScreenByTappingButtonAndSelectingOption(String screenName) {
        customFoodPage.openScreen(screenName);
    }

    @When("I click on + button")
    public void iClickOnPlusButton() {
        customFoodPage.tapPlusButton();
    }

    @And("I enter the following fields:")
    public void iEnterTheFollowingFields(Map<String, String> fieldValues) {
        fieldValues.forEach(customFoodPage::fillCustomField);
    }

    @And("I tap the \"Submit\" button")
    public void iTapTheSubmitButton() {
        customFoodPage.tapSubmitButton();
    }

    @And("I confirm adding the custom meal {string}")
    public void iConfirmAddingTheCustomMeal(String mealName) {
        customFoodPage.confirmCustomMeal(mealName);
    }


}
