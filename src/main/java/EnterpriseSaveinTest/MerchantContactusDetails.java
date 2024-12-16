package EnterpriseSaveinTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantContactusDetails {
	

	   WebDriver driver;
	 //WebDriver instance
	   
	   
	   // Constructor to initialise PageFactory
	   
	   public MerchantContactusDetails(WebDriver driver) {
		   
		   this.driver=driver;
		// Initialise web elements using PageFactory
		   
		   PageFactory.initElements(driver, this);
		   
	   }
	   
	// Web elements identified using @FindBy annotation
	   
	   @FindBy(xpath="(//div[contains(@class,'duration-300 text-[14px] font-montserrat')][normalize-space()='Contact us'])[2]")
	   WebElement ContactUs;
	   
	   @FindBy(xpath="//a[normalize-space()='+91 8448114703']")
	   WebElement callusNumber;
	   
	   @FindBy(xpath="//a[normalize-space()='support@savein.money']")
	   WebElement EmailIDText;
	   @FindBy(xpath="//a[normalize-space()='+91 8448114923']")
	   WebElement WhatsupNumber;
	// for click Merchant  contact us details Click method
	   public void merchantContactUsDetailsClick() throws InterruptedException 
	   {
		   
		   ContactUs.click();
		   Thread.sleep(3000);
		  String ActualcallusNumber =callusNumber.getText();
		  String expectedcallusNumber ="+91 8448114703";
		 assertEquals(ActualcallusNumber, expectedcallusNumber);
		  
		  String ActualEmailIDText= EmailIDText.getText();
		  String ExpectedEmailIDText="support@savein.money";
		  System.out.println(ActualEmailIDText);
		  assertEquals(ActualEmailIDText, ExpectedEmailIDText);
		  
		  String ActualWhatsupNumber=WhatsupNumber.getText();
		  String ExpectedWhatsupNumber="+91 8448114923";
		  assertEquals(ActualWhatsupNumber, ExpectedWhatsupNumber);
		  
		  Thread.sleep(3000);

	   }
	   
	   

	   // Method to perform Start Merchant contact us details Activity
	   public void merchantContactUsDetailspage() throws InterruptedException
	   {
		   merchantContactUsDetailsClick();
	   }

}
