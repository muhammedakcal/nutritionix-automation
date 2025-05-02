package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.mobile.web.LoginPageMobile;
import pages.mobile.web.HomePageMobile;
import org.testng.Assert;

/**
 * Step definitions for mobile (iOS) Nutritionix app scenarios.
 */
public class LoginStepDefinitions {

    private final LoginPageMobile loginPage = new LoginPageMobile();
    private final HomePageMobile homePage = new HomePageMobile();

    @Given("the Nutritionix mobile app is launched")
    public void theNutritionixMobileAppIsLaunched() {
        // App launch is handled by Hooks; optionally, verify app is on home screen
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
     /**
      *
      * Note: On a real device the user is often auto-logged in,
              so these steps may be skipped in a live demo.

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.tapLogin();

        Kept here for framework completeness.

        */
    }

    @When("I search for {string} on mobile")
    public void iSearchForOnMobile(String query) {
        homePage.searchFood(query);
    }

    @When("I create a custom meal")
    public void iCreateACustomMeal() {
        homePage.openCustomMeal();
    }

    @Then("I see the daily summary")
    public void iSeeTheDailySummary() {
        String summary = homePage.getDailySummary();
        Assert.assertNotNull(summary, "Daily summary should be displayed");
    }

    @Then("I should see the Track page")
    public void iShouldSeeTheTrackPage() {
        Assert.assertTrue(loginPage.isTrackPageVisible(), "Track page should be displayed: " + loginPage.getHeaderText());
    }
}
