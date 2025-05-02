package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import reporting.ExtentReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import managers.DriverManager;
import java.util.Base64;

/**
 * Cucumber listener for ExtentReports integration.
 */
public class ExtentCucumberListener {

    private static final ExtentReports extent = ExtentReportManager.getReporter();
    private static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = extent.createTest(scenario.getName());
        testThread.set(test);
    }

    @After
    public void afterScenario(Scenario scenario) {
        ExtentTest test = testThread.get();
        if (scenario.isFailed()) {
            // capture screenshot
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
            String base64 = Base64.getEncoder().encodeToString(screenshot);
            test.fail("Scenario failed",
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "Failure Screenshot")
                    .build()
            );
        } else {
            test.pass("Scenario passed");
        }
        extent.flush();
    }
}
