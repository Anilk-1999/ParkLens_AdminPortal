package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.TestHomePage;

public class Login 
{
	WebDriver driver;
	//SearchAdminUsers searchByName=new SearchAdminUsers(driver);
	@Test
	public void launchChromeBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://parklens-admin.tech-active.com/auth");
		driver.findElement(By.xpath("(//input[@min='undefined'])[1]")).sendKeys("devops@active.agency");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Devops@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		driver.findElement(By.xpath("//span[text()=' Settings']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Admin Users']")).click();
		Thread.sleep(3000);
		int size = driver.findElements(By.xpath("//ngb-pagination/ul/li")).size();
		System.out.println(size);
//		String getpaginationText=driver.findElement(By.xpath("//ngb-pagination/ul/li")).getText();
		   		
//		int getsize = driver.findElements(By.xpath("//ngb-pagination/ul/li")).size();
//		  for(int i=1;i<=getsize;i++)
//		  {
//			  List<WebElement> getpaginationText=driver.findElements(By.xpath("//ngb-pagination/ul/li"));
//			  System.out.println("---------"+getpaginationText+"------------");
//		  }
		
		//driver.findElement(By.xpath("//button[text()=' New']")).click();
		//driver.findElement(By.xpath("//ul/li/a[@aria-label='Last']")).click();
	}
	
	@Test
	public int getrow()
	{
		List<WebElement> tableRows=driver.findElements(By.xpath("//table[@class='table']//tbody/tr"));
	    return tableRows.size();
	}
	@Test
	public void getlist(WebDriver driver)
	{
		this.driver=driver;
       WebElement table=driver.findElement(By.xpath("//table[@class='table']"));
		
		for(int i=1;i<=getrow();i++)
		{
		String getid=table.findElement(By.xpath("//table[@class='table']/tbody/tr/td[1]")).getText();
		System.out.println("-----------"+getid);
		}
	}
//	@Test
//	public void test1() throws InterruptedException
//	{
//     WebElement admin_role=driver.findElement(By.xpath("//select[@formcontrolname='DropdownControl']"));
//     admin_role.click();
//     Thread.sleep(3000);
//     Select sel=new Select(admin_role);
//     
//	 String role="ADMIN";
//	 
//	 if(role.equals("MANAGER"))
//	 {
//		System.out.println("This is not a ADMIN Role");
//	 }
//	 else if(role.equals("ASSOCIATE"))
//	 {
//		 System.out.println("This is not a ADMIN Role");
//	 }
//	 else if(role.equals("REVIEW ONLY"))
//	 {
//		 System.out.println("This is not a ADMIN Role");
//	 }
//	 else if(role.equals("ADMIN")) 
//	 {
//		 Thread.sleep(3000);
//		 sel.selectByVisibleText("ADMIN"); 
//	 }
//	 else
//	 {
//		 System.out.println("ADMIN role is not there please select the other one....");
//	 }
//    }
//  @Test
//  public void test() throws InterruptedException, AWTException
//  {
//	  String getName=driver.findElement(By.xpath("(//table[@class='table']/tbody/tr/td[2])[1]")).getText();
//	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("(//div/input)[2]")).sendKeys(getName);
//	  Robot rob=new Robot();
//	  rob.keyPress(KeyEvent.VK_ENTER);
//  	  rob.keyRelease(KeyEvent.VK_ENTER);
//  }
  
  @Test
  public int getPerPageOptions()
  {
	  List<WebElement> perpageOptions = driver.findElements(By.xpath("(//select)/option"));
	  return perpageOptions.size();
	  
  }
//  @Test
//  public void selectPerPage() throws InterruptedException
//  {
//	  WebElement selectperpage = driver.findElement(By.xpath("//select[@class='form-select form-select ms-2 me-2']"));
//	  
//	  Select select=new Select(selectperpage);
//	  for(int i=1;i<getPerPageOptions();i++)
//	  {		
//		  String gettext=select.getOptions().get(i).getText();
//		  if(gettext.equals("40"))
//		  {
//			 select.selectByIndex(3);
//		  }
//	  }
//       
//  }
//  String selectPage="»»";
//  
//  @Test
//  public void setPagination()
//  {  
//	  String getpaginationText1=driver.findElement(By.xpath("//ngb-pagination/ul/li")).getText();
//	  System.out.println("----------"+getpaginationText1+"-----------");
//	  
//	  int getsize = driver.findElements(By.xpath("//ngb-pagination/ul/li")).size();
//	  for(int i=1;i<=getsize;i++)
//	  {
//		  String getpaginationText=driver.findElement(By.xpath("//ngb-pagination/ul/li")).getText();
//		  if(getpaginationText.equals(selectPage))
//		  {
//			  driver.findElement(By.xpath("//ul/li/a[@aria-label='First']")).click();
//		  }
//		  else if(getpaginationText.equals(selectPage))
//		  {
//			driver.findElement(By.xpath("//ul/li/a[@aria-label='Previous']")).click();  
//		  }
//		  else if(getpaginationText.equals(selectPage))
//		  {
//			  driver.findElement(By.xpath("//ul/li/a[@aria-label='Next']")).click();
//		  }
//		  else if(getpaginationText.equals(selectPage))
//		  {
//			  driver.findElement(By.xpath("//ul/li/a[@aria-label='Last']")).click();
//		  }
//		  else
//		  {
//			  System.out.println("please select the valid pagination!.....");
//		  }
//	  }
 // }
}
