package EnterpriseSaveinTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorporateUserDashBord_AccountUser 
{

	

	
		// WebDriver instance
	     WebDriver driver;
	    
	    
	    
	    // Constructor to initialise PageFactory
	    
	    public CorporateUserDashBord_AccountUser(WebDriver driver)
	    {
	        this.driver = driver;
	        
	        // Initialise web elements using PageFactory
	        PageFactory.initElements(driver, this);
	    }

	    // Web elements identified using @FindBy annotation
	    
	    @FindBy(xpath = "(//div[normalize-space()='Account Users'])[2]") 
	     WebElement MerchantAccountBtn;
	    
	    @FindBy(xpath = "//button[normalize-space()='Add a user']") 
	     WebElement AddUserBtn;
	    
	    @FindBy(xpath = "//div[normalize-space()='Assistant']") 
	     WebElement AssistantUserAdd;
	    
	    @FindBy(xpath = "//input[contains(@type,'name')]") 
	     WebElement AddUserNameInput;
	    
	    @FindBy(xpath = "//input[contains(@type,'text')]") 
	     WebElement AddUserMoblieInput;
	    
	    @FindBy(xpath = "//button[normalize-space()='Add User']") 
	     WebElement AddUserFinalSubmitBtn;
	  
	    @FindBy(xpath = "//button[normalize-space()='Ok']") 
	     WebElement AddedUserAceptBtn;
	    
	    @FindBy (xpath="//div//div//div//div[3]//div[1]//div[2]//div[2]//*[name()='svg']")
	    WebElement DeleteMerchantUserBtn;
	    
	    @FindBy(xpath="//button[normalize-space()='Yes']")
	    WebElement DeleteMerchantUserConfrimationBtn;
	 // for click Merchant Account DashBoard Click method
	    public void MerchantAccountDashBoardClick() throws InterruptedException
	    {
	    	MerchantAccountBtn.click(); 
	    	Thread.sleep(2000);	 
	    	String ActualAddUserBtnText=AddUserBtn.getText();
	    	String ExpectedAddUserBtnText="Add a user";
	    	assertEquals(ActualAddUserBtnText, ExpectedAddUserBtnText);
	    	AddUserBtn.click();
	    	Thread.sleep(2000);	 
	    	
	    }
	    
	    public void addMerchantUsers() throws InterruptedException 
	    {
	    	
	    	AssistantUserAdd.click();
	    	
	    	Thread.sleep(2000);	 
	    	AddUserNameInput.click();
	    	AddUserNameInput.sendKeys("Test user");
	    	
	    	Thread.sleep(2000);	 
	    	AddUserMoblieInput.click();
	    	AddUserMoblieInput.sendKeys("9956565560");
	    	
	    	Thread.sleep(2000);	 
	    	AddUserFinalSubmitBtn.click();
	    	
	    	
	    	
	    	Thread.sleep(2000);	 
	    	AddedUserAceptBtn.click();
	    	
	    	
	    	
	    }
	    
	    public void DeleteMerchantUserTest() throws InterruptedException 
	    {
	    	Thread.sleep(2000);	
	    	DeleteMerchantUserBtn.click();
	    	
	    	Thread.sleep(2000);	
	    	DeleteMerchantUserConfrimationBtn.click();
	    	Thread.sleep(2000);
	    	
	    }
	    
	    

	    // Method to perform Start Merchant Account DashBoard Activity
	    public void MerchantAccountMangement() throws InterruptedException
	    {
	    	MerchantAccountDashBoardClick();
	    	addMerchantUsers();
	    	DeleteMerchantUserTest();
	    }
}
