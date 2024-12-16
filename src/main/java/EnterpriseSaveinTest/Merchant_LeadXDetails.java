package EnterpriseSaveinTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Merchant_LeadXDetails 
{
   WebDriver driver;
 //WebDriver instance
   
   
   // Constructor to initialise PageFactory
   
   public Merchant_LeadXDetails(WebDriver driver) {
	   
	   this.driver=driver;
	// Initialise web elements using PageFactory
	   
	   PageFactory.initElements(driver, this);
	   
   }
   
// Web elements identified using @FindBy annotation
   
   @FindBy(xpath="(//div[contains(@class,'flex flex-row font-[900] tracking-wide text-[#6B1AA6]')])[2]")
   WebElement LeadXBTN;
   @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(7) > div:nth-child(2)")
   WebElement LeadXDashBoard;
   @FindBy(xpath="//p[normalize-space()='Customers via']")
   WebElement CustomersviaLeadXText;
   @FindBy(css="div[class='ml-8 my-3'] div[class='text-sm px-1']")
   WebElement ViewCustomersButton;
   @FindBy(xpath="//p[normalize-space()='Converted Customers via']")
   WebElement ConvertedCustomersviaLeadXText;
   @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > button:nth-child(3) > div:nth-child(1)")
   WebElement ConvertedViewCustomersButton;
   
   @FindBy (xpath="//select[@id='center']")
   WebElement SelectConvertionYesNoOption;
   
// for click Merchant  leadX details Click method
   public void leadXDetailsClick() throws InterruptedException 
   {
	   
	   LeadXBTN.click();
	   LeadXDashBoard.click();
	   String ActualCustomersviaLeadXText=CustomersviaLeadXText.getText();
	   String ExpectedCustomersviaLeadXText="Customers via";
	   assertEquals(ActualCustomersviaLeadXText, ExpectedCustomersviaLeadXText);
	   
	   ViewCustomersButton.click();
	   Thread.sleep(3000);
	   Select selectCenter = new Select(SelectConvertionYesNoOption);

	   // To select an option by visible text
	   selectCenter.selectByVisibleText("No");
	   Thread.sleep(3000);
	   selectCenter.selectByVisibleText("Yes");
	   Thread.sleep(3000);
	   selectCenter.selectByVisibleText("Converted?");
	   Thread.sleep(3000);
	   
	   LeadXDashBoard.click();
	   Thread.sleep(3000);
	   
	   String ActualConvertedCustomersviaLeadXText=ConvertedCustomersviaLeadXText.getText();
	   String ExpectdConvertedCustomersviaLeadXText="Converted Customers via";
	   assertEquals(ActualConvertedCustomersviaLeadXText, ExpectdConvertedCustomersviaLeadXText);
	   ConvertedViewCustomersButton.click();
	   Thread.sleep(3000);
	// To select an option by visible text
	   selectCenter.selectByVisibleText("No");
	   Thread.sleep(3000);
	   selectCenter.selectByVisibleText("Yes");
	   Thread.sleep(3000);
	   selectCenter.selectByVisibleText("Converted?");
	   Thread.sleep(3000);
   }
   
   

   // Method to perform Start Merchant leadX details Activity
   public void leadXDeatailsPage() throws InterruptedException
   {
	   leadXDetailsClick();
   }
   
   
   
}
