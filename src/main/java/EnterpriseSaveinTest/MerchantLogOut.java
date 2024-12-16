package EnterpriseSaveinTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantLogOut 
{
	  WebDriver driver;
		 //WebDriver instance
		   
		   
		   // Constructor to initialise PageFactory
		   
		   public MerchantLogOut(WebDriver driver) {
			   
			   this.driver=driver;
			// Initialise web elements using PageFactory
			   
			   PageFactory.initElements(driver, this);
			   
		   }
		   
		// Web elements identified using @FindBy annotation
		   
		   @FindBy(xpath="(//div[contains(@class,'text-[14px] font-montserrat')][normalize-space()='Log out'])[2]")
		   WebElement Merchant_logOut;
		   
		   
		   @FindBy(xpath="(//button[normalize-space()='Yes'])[1]")
		   WebElement LogoutConfiremationBTN;
		// for click Merchant  log out  Click method
		   public void merchantLogoutClick() throws InterruptedException 
		   {
			   
			   Merchant_logOut.click();
			   Thread.sleep(1000);
			   LogoutConfiremationBTN.click();
		   }
		   
		   

		   // Method to perform Start Merchant logout  Activity
		   public void merchantLogoutpage() throws InterruptedException
		   {
			   merchantLogoutClick();
		   }

	
}
