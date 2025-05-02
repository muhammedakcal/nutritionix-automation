package reporting;

import com.aventstack.extentreports.ExtentReports;
import org.testng.IExecutionListener;

public class ExtentTestNGListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        // nothing needed here
    }

    @Override
    public void onExecutionFinish() {
        // This will always run at the very end of the TestNG suite
        ExtentReports extent = ExtentReportManager.getReporter();
        extent.flush();
    }
}