package EnterpriseSaveinTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorporateMerchant_GST 
{

	

	// WebDriver instance
    WebDriver driver;
    
    
    
    // Constructor to initialise PageFactory
    
    public CorporateMerchant_GST(WebDriver driver) {
        this.driver = driver;
        
        // Initialise web elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Web elements identified using @FindBy annotation
    @FindBy(xpath = "(//div[normalize-space()='GST Invoices'])[2]") 
     WebElement GST_InvoicesBTN;
    
    
    
 	 // for click Merchant  DashBoard Transaction Click method
 	    public void MerchantGSTInvoicesDashBoardClick()
 	    {
 	    	GST_InvoicesBTN.click();
 	    }
 	    
 	    

 	    // Method to perform Start Merchant Account DashBoard Activity
 	    public void MerchantGSTDetails()
 	    {
 	    	MerchantGSTInvoicesDashBoardClick();
 	    }
}
