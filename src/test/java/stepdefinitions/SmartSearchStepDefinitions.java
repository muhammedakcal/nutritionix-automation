package stepdefinitions;


import io.cucumber.java.en.*;
import pages.mobile.web.SmartSearchPage;

public class SmartSearchStepDefinitions {

    private final SmartSearchPage smartSearchPage = new SmartSearchPage();

    @Given("The user is on the Home Page")
    public void userOnTrackPage() {
        smartSearchPage.verifyHomePage();
    }

    @When("I type {string} into the search bar")
    public void iTypeIntoTheSearchBar(String query) {
        smartSearchPage.enterQuery(query);
    }

    @When("I switch to the {string} section")
    public void iSwitchToSection(String section) {
        smartSearchPage.switchToSection(section);
    }

    @When("I select Free Form: {string}")
    public void selectFreeForm(String name) {
        smartSearchPage.selectFreeForm(name);
    }

    @Then("the {string} item should appear under the {string} section with quantity {int}")
    public void theItemShouldAppearUnderTheSectionWithQuantity(String food, String section, int qty) {
        smartSearchPage.verifyLoggedItem(food, section, qty);
    }

    @When("I click on: {string}")
    public void logOneFood(String name) {
        smartSearchPage.logOneFood();
    }
}
