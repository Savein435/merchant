package EnterpriseSaveinTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Merchant_Customers 
{
 WebDriver driver;
 //WebDriver instance
 
 
     // Constructor to initialise PageFactory
 
	public Merchant_Customers(WebDriver driver) 
	{
		this.driver=driver;
		
		// Initialise web elements using PageFactory
		PageFactory.initElements( driver,this);
	}
	

    // Web elements identified using @FindBy annotation
	@FindBy(xpath="(//div[normalize-space()='Customers'])[2]")
	WebElement customer_details;
	
	@FindBy(xpath="//input[contains(@placeholder,'Search customers')]")
	WebElement CustomersurchBox;
	@FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
    WebElement DetailedCustomerClick;
	 // for click Merchant  customer details Click method
	public void customerDetailsClick() throws InterruptedException {
		customer_details.click();
		
		Thread.sleep(4000);
		CustomersurchBox.click();
		CustomersurchBox.sendKeys("9984206284");
		Thread.sleep(4000);
		DetailedCustomerClick.click();
		Thread.sleep(4000);
		
	}
	

  // Method to perform Start Merchant customer details Activity
	public void merchantCustomerDetails() throws InterruptedException {
		customerDetailsClick();
	}
	
}
