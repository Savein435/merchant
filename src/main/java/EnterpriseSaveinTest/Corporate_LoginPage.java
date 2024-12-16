package EnterpriseSaveinTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



	public class Corporate_LoginPage {

	    // WebDriver instance
	    WebDriver driver;
	   
        
	    
	    // Constructor to initialise PageFactory
	    
	    public Corporate_LoginPage(WebDriver driver) {
	        this.driver = driver;
	        
	        // Initialise web elements using PageFactory
	        PageFactory.initElements(driver, this);
	    }
	    

	    // Web elements identified using @FindBy annotation
	    @FindBy(xpath="//button[normalize-space()='Enterprise']")
	    WebElement EnterpriseBtn;
	    
	    
	    @FindBy(xpath = "//input[@type='email']") 
	     WebElement userEmailInput;
	   
	    @FindBy(xpath = "//button[normalize-space()='Login']") 
	     WebElement UserLoginBtn;

	    @FindBy(xpath = "//input[@type='password']")
	    WebElement otpInput;

	    
	    

	    // Method to enter user name
	    public void MerchantUserLogin(String userEmail,String userPass) throws InterruptedException    
	    {
	    	EnterpriseBtn.click();
	    	Thread.sleep(1000);
	    	userEmailInput.sendKeys(userEmail); 
	    	Thread.sleep(1000);
	    	otpInput.sendKeys(userPass);
	    	Thread.sleep(1000);
	    	UserLoginBtn.click();
	    	Thread.sleep(2000);
	    }
	    
	    

	   

	 
	    
	    // Method to perform login
	    public void login(String userEmailInput, String password) throws InterruptedException {
	    	MerchantUserLogin(userEmailInput, password);
	       
	        
	        
	        
	    }
	}
	

