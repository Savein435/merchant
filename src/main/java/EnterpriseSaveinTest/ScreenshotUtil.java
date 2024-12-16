package EnterpriseSaveinTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil  
{
	WebDriver driver;

    public ScreenshotUtil(WebDriver driver) 
    {
        this.driver = driver;
    }
 // This method captures a screenshot and returns the path where it is saved
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        // Format the current date and time to add to the screenshot file name
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        
        // Capture the screenshot and store it in a temporary file
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination path for the screenshot
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        
        try {
            // Copy the screenshot file to the destination path
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Return the destination path of the screenshot
        return destination;
    }
}

