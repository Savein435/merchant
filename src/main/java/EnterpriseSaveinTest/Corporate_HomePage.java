package EnterpriseSaveinTest;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Corporate_HomePage 
{
	// WebDriver instance
    WebDriver driver;
   
    public Corporate_HomePage(WebDriver driver) {
        this.driver = driver;
        
        // Initialise web elements using PageFactory
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)") 
     WebElement merchantUserNmae;
    @FindBy(xpath="//p[normalize-space()='Applications Initiated']")
    WebElement InitiatApplicaton;
    @FindBy(xpath="//p[normalize-space()='Applications Approved']")
    WebElement ApprovedApplication;
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > p:nth-child(1)")
    WebElement CreatedLoans;
    
    @FindBys(@FindBy(xpath="//p[normalize-space()]"))
    List<WebElement> arry;
    
    @FindBy(xpath="//select[@id='sort']")

    WebElement Monthdropdown;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2) > svg:nth-child(1)")
    WebElement Applications_in_Progress_worthHint;
    
    @FindBy(xpath="//div[contains(text(),'Total amount of application in which customer is y')]")
    WebElement ApplicationWorthHintGetText;
    
    @FindBy(css="div[class='flex items-center justify-between px-[20px]'] button[class='text-gray-600'] svg")
    WebElement Approval_RateHint;
    
    @FindBy(xpath="//div[contains(text(),'It is the proportion of customers who were approve')]")
    WebElement Approval_RateHintGetText;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2) > svg:nth-child(1)")
    WebElement Amount_creditedHint;
    
    @FindBy(xpath="//div[contains(text(),'Total amount credited to your linked bank account')]")
    WebElement Amount_creditedGetText;
    
    @FindBy(css="div[class='flex flex-1'] p[class='ml-2']")
    WebElement DashBordExportCsv;
    
    @FindBy(css="div[class='flex justify-between items-center'] div p[class='ml-2']")
    WebElement ApprovedButNotDisbursedExportCsv;
    
    @FindBy(xpath="//button[normalize-space()='Download']")
    WebElement DownloadQrBtn;
    @FindBy(css="p[class='text-[12px] ml-[4px]']")
    WebElement CopyQrBtn;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(4) > p:nth-child(1)")
    WebElement AmountCreditViewdetails;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > button:nth-child(4) > p:nth-child(1)")
    WebElement ApplicationsinProgresViewdetails;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
    WebElement Homekbtn;
    
    
    public void getAllHintDetails() throws InterruptedException {
    	
    	Approval_RateHint.click();
    	System.out.println(Approval_RateHintGetText.getText());
    	Thread.sleep(2000);
    	
    	String ActualApproval_RateHintGetText= Approval_RateHintGetText.getText();
    	String ExpectedApproval_RateHintGetText="It is the proportion of customers who were approved after completing all the steps of the application.";
    	Approval_RateHint.click();
    	assertEquals(ActualApproval_RateHintGetText, ExpectedApproval_RateHintGetText);

        Thread.sleep(2000);
    	Applications_in_Progress_worthHint.click();
    	System.out.println(Amount_creditedGetText.getText());
    	Thread.sleep(2000);
    	
    	String ActualApplicationWorthHintText= ApplicationWorthHintGetText.getText();
    	String ExpectedApplicationWorthHintText="Total amount of application in which customer is yet to complete all steps";
    	Applications_in_Progress_worthHint.click();
    	assertEquals(ActualApplicationWorthHintText, ExpectedApplicationWorthHintText);
    	
    	Thread.sleep(2000);
    	

    	Amount_creditedHint.click();
    	System.out.println(Amount_creditedGetText.getText());
    	Thread.sleep(2000);
    	
    	String ActualAmount_creditedHintText= Amount_creditedGetText.getText();
    	String ExpectedAmount_creditedHintText="Total amount credited to your linked bank account";
    	Amount_creditedHint.click();
    	assertEquals(ActualAmount_creditedHintText, ExpectedAmount_creditedHintText);
    	
    	Thread.sleep(1000);
    	
    }
    
    public void DashBordExportCsvMethod() throws InterruptedException 
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
    	
    	String ActualDashBordExportCsv= DashBordExportCsv.getText();
    	String ExpectedDashBordExportCsv="Export";
    	//js.executeScript("arguments[0].scrollIntoView(true);", DashBordExportCsv);
    	assertEquals(ActualDashBordExportCsv, ExpectedDashBordExportCsv);
    	DashBordExportCsv.click();
    	Thread.sleep(2000);
    	
    	driver.navigate().refresh();
    	Thread.sleep(2000);
    	
    	js.executeScript("arguments[0].scrollIntoView(true);", ApprovedButNotDisbursedExportCsv);
    	String ActualApprovedButNotDisbursedExportCsvText= ApprovedButNotDisbursedExportCsv.getText();
    	String ExpectedApprovedButNotDisbursedExportCsvText="Export";
  
    	assertEquals(ActualApprovedButNotDisbursedExportCsvText, ExpectedApprovedButNotDisbursedExportCsvText);
    	
    	//ApprovedButNotDisbursedExportCsv.click();
    	Thread.sleep(2000);
    	
    	js.executeScript("arguments[0].click();", ApprovedButNotDisbursedExportCsv);
    	
    	
    }
    
    public void AmountsApplicationsVeiwDetails() throws InterruptedException {
    	
    	// Create Select instance
        Select select = new Select(Monthdropdown);
     // Select by value
        select.selectByValue("30");
        Thread.sleep(2000);
        select.selectByValue("90");
        Thread.sleep(2000);
        select.selectByValue("TILL_DATE");
        Thread.sleep(2000);
    	ApplicationsinProgresViewdetails.click();
    	Thread.sleep(2000);
    	Homekbtn.click();
    	Thread.sleep(2000);
    	AmountCreditViewdetails.click();
    	Thread.sleep(2000);
    	Homekbtn.click();
    	
    }
    
    public void DashboardQrCopyDownloadTest() throws InterruptedException
    {
    	DownloadQrBtn.click();
    	Thread.sleep(2000);
    	CopyQrBtn.click();
    	Thread.sleep(4000);
    	// Open a new tab using JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open()");
        
        // Get window handles to switch between tabs
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        
        // Switch to the newly opened tab
        driver.switchTo().window(tabs.get(1));
        
        Actions actions = new Actions(driver);
        
       
        
     // Open a generic page (any initial URL)
        driver.get("https://www.google.com");
        
        // Find an input field (for example, a search input or any text area)
        WebElement searchBox = driver.findElement(By.name("q"));
        
        // Click to focus the input field
        searchBox.click();
        // Open a URL in the new tab
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
        
        
        // Perform actions in the new tab (optional)
        searchBox.submit();
       
        
        Thread.sleep(10000);  // wait for 2 seconds to observe
        
        // Close the newly opened tab
        driver.close();
        
        // Switch back to the original tab
        driver.switchTo().window(tabs.get(0));
    }
    
    public void HomeDetailsDashboard() throws InterruptedException    
    {
    	// Create Select instance
        Select select = new Select(Monthdropdown);
     // Select by value
        select.selectByValue("30");
        Thread.sleep(2000);
        select.selectByValue("90");
        Thread.sleep(2000);
        select.selectByValue("TILL_DATE");
        Thread.sleep(2000);
        
       String mName=merchantUserNmae.getText();
       String ActualInitiatAppText=InitiatApplicaton.getText();
       String ExpectedIniatAppText="Applications Initiated";
       
       String ActualApprovedAppText=ApprovedApplication.getText();
       String ExpectedApprovedAppText="Applications Approved";
       
       String ActualCreatedLoansText=CreatedLoans.getText();
       String ExpectedCreatedLoansText ="Loans Created";
       
       System.out.println(mName+"\n "+ActualInitiatAppText +" \n"+ActualApprovedAppText +"\n"+ActualCreatedLoansText);
       assertEquals(ActualInitiatAppText, ExpectedIniatAppText);
       assertEquals(ActualApprovedAppText, ExpectedApprovedAppText);
       assertEquals(ActualCreatedLoansText, ExpectedCreatedLoansText);
       
       
       
       System.out.println("-----+++++++++++------------");
       String text;
       if (arry != null && !arry.isEmpty()) 
       {
           for (WebElement element : arry) 
        {
        	   
        	    
        	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	    	text = element.getText();
           System.out.println("Found text: " + text);
           
           // Check if the text equals "export" (ignoring case, if needed)
           if (text.equalsIgnoreCase("Copy"))
           {
               // Perform the click action
        	   
               element.click();
               
               Thread.sleep(4000);
               System.out.println("Clicked on "+text);
               
               continue;
             //  break;  Break the loop if you want to click only the first matching element
           }
           
          }
           }
    }
    
    // Method to perform Start Merchant home DashBoard Activity
    public void HomeDashbord() throws InterruptedException
    {
    	//getAllHintDetails();
    	AmountsApplicationsVeiwDetails();
    	DashboardQrCopyDownloadTest();
    	DashBordExportCsvMethod();
    	//HomeDetailsDashboard();
    }
}
