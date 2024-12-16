package EnterpriseSaveinTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewApplicaton 

{
	// WebDriver instance
    WebDriver driver;
    
    
    
    // Constructor to initialise PageFactory
    
    public CreateNewApplicaton(WebDriver driver) {
        this.driver = driver;
        
        // Initialise web elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Web elements identified using @FindBy annotation
    @FindBy(xpath = "//button[normalize-space()='Start a new application']") 
     WebElement createNewApp;
    
    @FindBy(xpath="//div[contains(@class,'w-full flex justify-center mt-4')]//input[contains(@placeholder,'')]")
    WebElement applicantMobileNo;
    
    @FindBy(xpath="(//input[contains(@type,'name')])[1]")
    WebElement applicantName;
    
    @FindBy(xpath="//div[3]//div[1]//input[1]")
    WebElement applicantAmount;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1)")
    WebElement  CreditCardCheckBox;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(8) > button:nth-child(1)")
    WebElement  Selectprocedure;
    
    @FindBy(xpath="//div[normalize-space()='Dental fillings']")
    WebElement Dental;
    
    @FindBy(xpath="//button[normalize-space()='Submit']")
    WebElement  SubmitBTN;
    
    
    @FindBy(xpath="(//button[normalize-space()='Ok'])[1]")
    WebElement AcceptApplicationOKBTN;
    // for method create new application button click
    public void createNewApp() throws InterruptedException 
    {
    	driver.navigate().refresh();
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", createNewApp);
    	
    	createNewApp.click();
    	Thread.sleep(1000);
    }
    
    // for Enter mobile Number method
    public void enterApplicantMobileNo(String mobileNo)
    {
    	applicantMobileNo.sendKeys(mobileNo);
    }
    
    //for enter name method
    public void enterApplicantName(String Name)
    {
    	applicantName.click();
    	applicantName.sendKeys(Name);
    }
    
    // for Enter amount method
    
    public void enterAmount(String Amount) {
    	
    	applicantAmount.click();
    	applicantAmount.sendKeys(Amount);
    }
    // for Credit Card CheckBox Select method
    public void CreditCardCheckBoxSelect() throws InterruptedException {
    	
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", CreditCardCheckBox);
        
    	CreditCardCheckBox.click();
        // Wait for the scrolling to take effect
        Thread.sleep(2000);
    	}
    // for Select procedure  method 
    public void SelectProcedureDropDown() 
    {
    	Selectprocedure.click();
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", Dental);
    	
    
    }
    // for submit application method
    
    public void submitButtonClick() throws InterruptedException 
    {
    	Thread.sleep(1000);
    	if (SubmitBTN.isEnabled()) {
    		SubmitBTN.click();
    	} else {
    	    System.out.println("Button is disabled"); 
    	}
    }
    
    // After create application click on ok btn
    
    public void AfterCreatApplicationClickOk() throws InterruptedException {
    	AcceptApplicationOKBTN.click();
    	Thread.sleep(1000);
    }

    // Method to perform new application
    public void newApplication(String mobileNo, String Name , String Amount) throws InterruptedException  {
        createNewApp();
        enterApplicantMobileNo(mobileNo);
        enterApplicantName(Name);
        enterAmount(Amount);
        CreditCardCheckBoxSelect();
        SelectProcedureDropDown();
        submitButtonClick();
        AfterCreatApplicationClickOk();
        
}
}
