package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNG runner for mobile (Android/iOS) Cucumber scenarios.
 */
@CucumberOptions(
    features = "src/test/resources/mobile",
    glue = {"hooks", "stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/mobile-html",
        "json:target/cucumber-reports/mobile.json"
    },
    tags = "@ios",
    monochrome = true
)
public class MobileTestRunner extends AbstractTestNGCucumberTests {
    // Inherits test execution logic from AbstractTestNGCucumberTests
}
