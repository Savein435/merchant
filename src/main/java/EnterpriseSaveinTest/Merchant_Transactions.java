package EnterpriseSaveinTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Merchant_Transactions
{

	// WebDriver instance
    WebDriver driver;
    
    
    
    // Constructor to initialize PageFactory
    
    public Merchant_Transactions(WebDriver driver) {
        this.driver = driver;
        
        // Initialize web elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Web elements identified using @FindBy annotation
    @FindBy(xpath = "(//div[normalize-space()='Transactions'])[2]") 
     WebElement transactionsBTN;
    
    @FindBy(xpath = "//div[normalize-space()='Credited']") 
    WebElement transactionsCreditedBtn;
    
    @FindBy(xpath = "//div[normalize-space()='Incomplete']") 
    WebElement transactionsIncompleteBtn;
    
    @FindBy(xpath = "//div[normalize-space()='Rejected']") 
    WebElement transactionsRejectedBtn;
    
    @FindBy(xpath = "//div[normalize-space()='Overdue']") 
    WebElement transactionsOverdueBtn;
    
    @FindBy(xpath = "//div[normalize-space()='All']") 
    WebElement transactionsAllBtn;
    
    @FindBy(xpath="//body[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    WebElement CustomerNameFromTran;
    
    @FindBy(xpath="//body[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")
    WebElement CustomerRefranceId;
    
    @FindBy(xpath="//input[@placeholder='Search by Applicant Name / Reference ID']")
    WebElement SearchbyApplicantName;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > select:nth-child(1)")

    WebElement TransMonthdropdown;
    
    @FindBy(css="div[class='h-4 w-4 md:mr-3 mr-2 flex-shrink-0 bg-white cursor-pointer rounded-sm border flex justify-center items-center']")
    WebElement CustomerViaLeadXCheckBox;
    
    @FindBy(css="svg[stroke='currentColor'][fill='currentColor'][stroke-width='0'][viewBox='0 0 448 512']")
    WebElement CustomerViaLeadXCheckBoxDeslect;
    
    @FindBy(css="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > select:nth-child(1)")
 	WebElement SlectedOlderNewTrans;
    // for click Merchant  DashBoard Transaction Click method
 	    public void MerchantTransactionDashBoardClick() throws InterruptedException
 	    {
 	    	transactionsBTN.click();
 	    	Thread.sleep(2000);
 	    	String CustomerName=CustomerNameFromTran.getText();
 	    	String CustomerRefranceNo=CustomerRefranceId.getText();
 	    	SearchbyApplicantName.sendKeys(CustomerName);
 	    	Thread.sleep(5000);
 	    	SearchbyApplicantName.clear();
 	    	driver.navigate().refresh();
 	    	Thread.sleep(5000);
 	    	
 	    	SearchbyApplicantName.sendKeys(CustomerRefranceNo);
 	    	Thread.sleep(5000);
 	    	SearchbyApplicantName.clear();
 	    	driver.navigate().refresh();
 	    	
 	    	Thread.sleep(5000);
 	    	transactionsCreditedBtn.click();
 	    	Thread.sleep(5000);
 	    	
 	    	transactionsIncompleteBtn.click();
 	    	Thread.sleep(5000);
 	    	
 	    	transactionsRejectedBtn.click();
 	    	Thread.sleep(5000);
 	    	
 	    	transactionsOverdueBtn.click();
 	    	Thread.sleep(1000);
 	    	
 	    	transactionsAllBtn.click();
 	    	Thread.sleep(1000);
 	    // Create Select instance
 	        Select select1 = new Select(SlectedOlderNewTrans);
 	        select1.selectByValue("ASC");
	        Thread.sleep(2000);
	        select1.selectByValue("DESC");
	        Thread.sleep(2000);
	        
 	    // Create Select instance
 	        Select select = new Select(TransMonthdropdown);
 	     // Select by value
 	        select.selectByValue("30");
 	        Thread.sleep(2000);
 	        select.selectByValue("90");
 	        Thread.sleep(2000);
 	        select.selectByValue("TILL_DATE");
 	        Thread.sleep(2000);
 	        
 	       CustomerViaLeadXCheckBox.click();
 	       
 	        select.selectByValue("30");
	        Thread.sleep(2000);
	        select.selectByValue("90");
	        Thread.sleep(2000);
	        select.selectByValue("TILL_DATE");
	        Thread.sleep(2000);
	        
	        
	        select1.selectByValue("ASC");
	        Thread.sleep(2000);
	        select1.selectByValue("DESC");
	        Thread.sleep(2000);
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CustomerViaLeadXCheckBoxDeslect);
//	        //CustomerViaLeadXCheckBoxDeslect.click();
	        
 	    }
 	    
 	    

 	    // Method to perform Start Merchant Account DashBoard Activity
 	    public void MerchantTransactionDetails() throws InterruptedException
 	    {
 	    	MerchantTransactionDashBoardClick();
 	    }
}
