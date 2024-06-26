package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import report.ExtentReportManager;
import utils.ScreenshotUtil;

public class Hooks {
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;
    private static Scenario scenario;
    static String currentStep = "";

    @Before
    public void setUp(Scenario scenario) {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            extent = ExtentReportManager.getInstance();
        }
        Hooks.scenario = scenario;
        test = extent.createTest(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Step Failed: " + currentStep);
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName());
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {
            test.log(Status.PASS, "Step Passed: " + currentStep);
        } else if (scenario.getStatus().toString().equalsIgnoreCase("SKIPPED")) {
            test.log(Status.SKIP, "Step Skipped: " + currentStep);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            extent.flush();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static String getCurrentStep() {
        return currentStep;
    }
}
