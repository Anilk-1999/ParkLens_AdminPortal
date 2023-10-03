package testBase;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributeValues;
import pageObjects.TestAttributes;
import pageObjects.TestCameras;
import pageObjects.TestClientRoles;
import pageObjects.TestClientUsers;
import pageObjects.TestClients;
import pageObjects.TestLogin;
import pageObjects.TestLots;
import pageObjects.TestHomePage;
import pageObjects.TestSites;
import pageObjects.TestStalls;
import utilities.WaitHelper;
import utilities.Xlxutility;

public class Baseclass {

	
	public TestAttributeValues attributeValue;
	public TestAddAdminUsers adminUser;
	public TestHomePage homePage;
	public TestClientRoles clientRoles;
	public TestAttributes attributes;
	public static WebDriver driver;
	public Xlxutility utilitydata;
	public WaitHelper waithelper;
	public TestClientUsers users;
	public TestClients clients;
	public TestCameras cameras;
	public TestStalls stalls;
	public TestSites sites;
	public TestLots lots;
	public TestLogin log;
	
	
	@BeforeMethod
	public void launchChromeBrowser()
	{
		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	 
   @AfterMethod
   public void closeapp()
   {
	   driver.quit();
   }
   
   public String randomName()
   {
	 String randomstring=RandomStringUtils.random(4,"abcdefghijklmnopqrstuvwxyz");
	 return "Anil User"+randomstring;
   }
   public String randomEmail()
   {
	 String randomstring=RandomStringUtils.random(2,"abcdefghijklmnopqrstuvwxyz");
	 return "aniluser"+randomstring+"@gmail.com";
   }
   public String randomMobileNumber()
   {
	  String randomnumeric=RandomStringUtils.randomNumeric(6);
	  return "9620"+randomnumeric ;
   }
   
   public String randomalphanumber()
   {
	  String randomalphanumeric=RandomStringUtils.randomAlphanumeric(5);
	  return randomalphanumeric;
   }
  
   public void robotClickAction() throws AWTException
	{
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
	}
   
   public static WebDriver getDriver() 
   {
	   return driver;
   } 
   
//   public static WebDriver getDriver() {
//	   return driver;
//   }

}