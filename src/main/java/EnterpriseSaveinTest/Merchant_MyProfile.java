package EnterpriseSaveinTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Merchant_MyProfile 
{
	
	WebDriver driver;
	 //WebDriver instance
	 
	 
	     // Constructor to initialise PageFactory
	 
		public Merchant_MyProfile(WebDriver driver) 
		{
			this.driver=driver;
			
			// Initialise web elements using PageFactory
			PageFactory.initElements( driver,this);
		}
		

	    // Web elements identified using @FindBy annotation
		@FindBy(xpath="(//div[normalize-space()='My Profile'])[2]")
		WebElement merchantProfile;
		
		@FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(8) > button:nth-child(1) > p:nth-child(2)")
		WebElement DeleteMerchantAccountBtn;
		
		@FindBy(xpath="//button[normalize-space()='Cancel']")
		WebElement DeleteMerchantAccountNOconfirmation;

		 // for click Merchant  profile details Click method
		public void merchantMyProfile() throws InterruptedException {
			merchantProfile.click();
			
			Thread.sleep(4000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DeleteMerchantAccountBtn);
			Thread.sleep(1000);
			DeleteMerchantAccountBtn.click();
			Thread.sleep(4000);
			DeleteMerchantAccountNOconfirmation.click();
			Thread.sleep(4000);
		}
		

	  // Method to perform Start Merchant profile details Activity
		public void merchantMyProfileDetails() throws InterruptedException {
			merchantMyProfile();
		}
		


}
