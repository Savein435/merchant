package enterpriseSaveinTest;

import org.testng.annotations.Test;

import EnterpriseSaveinTest.CreateNewApplicaton;
import EnterpriseSaveinTest.Corporate_LoginPage;
import EnterpriseSaveinTest.CorporateUserDashBord_AccountUser;
import EnterpriseSaveinTest.MerchantContactusDetails;
import EnterpriseSaveinTest.MerchantLogOut;
import EnterpriseSaveinTest.Merchant_Customers;
import EnterpriseSaveinTest.CorporateMerchant_GST;
import EnterpriseSaveinTest.Corporate_HomePage;
import EnterpriseSaveinTest.Merchant_LeadXDetails;
import EnterpriseSaveinTest.Merchant_MyProfile;
import EnterpriseSaveinTest.Merchant_Transactions;
import EnterpriseSaveinTest.TestListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(TestListener.class)
public class CorporateTest_Merchant  
{ 
	 
	    WebDriver driver;
	    Properties prop;
	    Corporate_LoginPage loginPage;
	    CreateNewApplicaton newApplication ;
	    CorporateUserDashBord_AccountUser merchantAccount;
	    Merchant_Transactions merchantTransaction;
	    CorporateMerchant_GST Gst;
	    Merchant_Customers merchantCustomer;
	    Merchant_MyProfile my_profile;
	    Merchant_LeadXDetails leadx;
	    MerchantContactusDetails contact_Us;
	    MerchantLogOut logout;
	    Corporate_HomePage mHome;
	   
	        @BeforeTest
	        @Parameters("browser")
	        public void setup(String browser) throws IOException {
	            // Initialize WebDriver based on the browser parameter
	            if (browser.equalsIgnoreCase("chrome")) {
	                
	                driver = new ChromeDriver();
	            } else if (browser.equalsIgnoreCase("firefox")) {
	               
	                driver = new FirefoxDriver(); 
	            } else if (browser.equalsIgnoreCase("edge")) {
	               
	                driver = new EdgeDriver();
	            }

	        driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            // Initialise the confige file
			 prop = new Properties();
			
			FileInputStream fis = new FileInputStream("data.properties");
			
			prop.load(fis);
	        // Navigate to the login page
			driver.get(prop.getProperty("qaurl"));

	        // Initialise the LoginPage object
	        loginPage = new Corporate_LoginPage(driver);
	        
	        // Initialise the HomePage object
	         newApplication = new CreateNewApplicaton(driver);
	         
	         // Initialise the MerchanDashBord_AccountUser object 
	         merchantAccount = new CorporateUserDashBord_AccountUser(driver);
	         
	         // Initialise the Merchant_Transactions object
	         merchantTransaction = new Merchant_Transactions(driver);
	         
	      // Initialise the Merchant_GST object
	         Gst = new CorporateMerchant_GST(driver);
	         
	      // Initialise the Merchant_Customer object 
	         merchantCustomer = new Merchant_Customers(driver);
	         
	         // Initialise the merchant profile object
	         my_profile = new Merchant_MyProfile(driver);
	         
	          leadx = new Merchant_LeadXDetails(driver);
	          
	          contact_Us = new MerchantContactusDetails(driver);
	          
	          logout = new MerchantLogOut(driver);
	          
	          mHome = new Corporate_HomePage(driver);
	         
	          
	          
	    } 

	    @Test(priority = 0)
	    public void LoginTest() throws InterruptedException 
	    {
	        // Use the loginPage object to perform actions
	        loginPage.login(prop.getProperty("qaMerchantEmail"), prop.getProperty("QaLoginpass"));
	        
	        // Add assertions here to verify the login was successful
	    }
	    @Test(priority = 1)
	    public void homeTest() throws InterruptedException {
	    	mHome.HomeDashbord();
	    }
	    
	    @Test(priority = 2)
	    public void newApplicationTest() throws InterruptedException
	    {
	    	// Use the newApplication object to perform actions
	    	newApplication.newApplication(prop.getProperty("applicantMobile"),prop.getProperty("applicantName"),
	    			prop.getProperty("amount"));
	    	
	    } 
	   
	    @Test(priority = 3)
	   public void MerchantAccountMangementTest() throws InterruptedException 
	    {
	    	
	    	merchantAccount.MerchantAccountMangement();
	    	Thread.sleep(1000);
	   }
	    
	    @Test(priority = 4)
	    public void MerchantTransctionDetailViewTest() throws InterruptedException
	    {
	    	
	    	merchantTransaction.MerchantTransactionDetails();
	    	Thread.sleep(1000);
	    }
	    
	    @Test(priority = 5)
	    public void MerchantGSTinvoiceTest() throws InterruptedException {
	    	Gst.MerchantGSTDetails();
	    	Thread.sleep(1000);
	    }
	    
	    @Test(priority = 6)
	    public void merchantCustomerTest() throws InterruptedException {
	    	merchantCustomer.merchantCustomerDetails();
	    	Thread.sleep(1000);
	    }
	    
	    @Test(priority=7)
	    
	    public void merchantMyProfileTest() throws InterruptedException {
	    	
	    	my_profile.merchantMyProfileDetails();
	    	Thread.sleep(1000);
	    }
	    @Test(priority=8)
	    public void MerchantLeadXDetailsTest() throws InterruptedException {
	    	leadx.leadXDeatailsPage();
	    	Thread.sleep(1000);
	    }
	    
	    @Test(priority=9)
	    
	    public void MerchantContactusDetailsTest() throws InterruptedException {
	    	
	    	contact_Us.merchantContactUsDetailspage();
	    	Thread.sleep(1000);
	    }
	    
	    @Test(priority=10)
	    public void merchantLogoutTest() throws InterruptedException {
	    	
	    	logout.merchantLogoutpage();
	    	Thread.sleep(1000);
	    }
	    
	  

	    @AfterTest()
	    public void teardown() throws InterruptedException 
	    {
	        // Close the browser after test
	    	Thread.sleep(1000);	    
	    	if (driver != null) {
	            driver.quit();
	        }
	    }
	
	
	 
}
