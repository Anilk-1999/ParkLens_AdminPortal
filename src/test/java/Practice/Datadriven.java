package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.Xlxutility;

public class Datadriven 
{
  public  WebDriver driver;
   
   Xlxutility xlx;
   @BeforeMethod
   public void setup() throws InterruptedException
   {
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://parklens-admin.tech-active.com/auth");
   }
   @Test(dataProvider = "admin user")
   public void createuser(String name, String email, String mobilenum,String role ,String pwd,String retypePwd ) throws InterruptedException, AWTException
   {
	    driver.findElement(By.xpath("(//input[@min='undefined'])[1]")).sendKeys("devops@active.agency");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Devops@1234");
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[.='Sign In']")).click();
	    driver.findElement(By.xpath("//span[text()=' Settings']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Admin Users']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).sendKeys(name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Mobile']")).sendKeys(mobilenum);
		driver.findElement(By.xpath("//select[@formcontrolname='DropdownControl']")).sendKeys(role);
	    Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
	    rob.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter at least 8+ characters']")).sendKeys(retypePwd);
		Thread.sleep(2000);	
	    driver.findElement(By.xpath("//button[.='Save']")).click();
	    driver.findElement(By.xpath("//button[.='OK']")).click();
   }
   
   @DataProvider(name="admin user")
   public String[][] addAdminUsers() throws AWTException, IOException, InterruptedException
   {
	    String path="./excel-datas/Datadriver.xlsx";   
	    
	xlx=new Xlxutility(path);
	int totalrow=xlx.getRowCount("Admin User");
	int totalcell=xlx.getCellCount("Admin User", 1);
	 
	String addadminUser[][]=new String[totalrow][totalcell];
	 for(int r=1;r<=totalrow;r++)
	 {
		 for(int c=0;c<totalcell;c++)
		 {
			    addadminUser[r-1][c] =xlx.getCellData("Admin User", r, c);
		 }
	 }
	   return addadminUser;
   }
   @AfterMethod
   public void close()
   {
	   driver.quit();
   }
}
