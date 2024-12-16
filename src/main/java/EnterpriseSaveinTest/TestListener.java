package EnterpriseSaveinTest;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListener implements ITestListener {
	ExtentReports extentReports;
    ExtentTest test;
	 WebDriver driver;
	

	@Override
    public void onTestStart(ITestResult result) 
	{
        System.out.println("Test Started: " + result.getMethod().getMethodName());
     // Create a new test entry in the Extent Report for each test
        test = extentReports.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    
   
        
         
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getMethod().getMethodName());
     // Log success in the report
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getMethod().getMethodName());
        System.out.println("Error: " + result.getThrowable());
        
     // Log failure in the report
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Error: " + result.getThrowable());
     
        WebDriver driver = null;

        // Get the test instance and extract the WebDriver instance
        Object testInstance = result.getInstance();

        try {
            // Try to access the WebDriver field using reflection (check if it's accessible)
            Field driverField = result.getTestClass().getRealClass().getDeclaredField("driver");
            driverField.setAccessible(true); // Allow access to private/protected fields
            driver = (WebDriver) driverField.get(testInstance);
            }
        catch (Exception e) 
        {
            System.out.println("Failed to retrieve the WebDriver instance: " + e.getMessage());
        }

        // Check if the driver is not null before taking a screenshot
        if (driver != null) 
        {
            // Capture screenshot and attach it to the Extent Report
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } 
        else 
        {
            System.out.println("Driver is null. Cannot take screenshot.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
    {
    	//System.out.println(result.SUCCESS_PERCENTAGE_FAILURE +"++"+ result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) 
    {
        System.out.println("Test Context Started: " + context.getName());
     // Initialise ExtentReports when the test suite starts
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
       
   
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Context Finished: " + context.getName());
        extentReports.flush();
    }
}
