package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Xlxutility;

public class DummyDRiven 
{
	WebDriver driver;
	
   @BeforeMethod
   public void setup()
   {
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
   }
   @Test
   public void test1() throws InterruptedException, IOException, AWTException  
   {
     driver.get("https://parklens-admin.tech-active.com/auth");
     driver.findElement(By.xpath("(//input[@min='undefined'])[1]")).sendKeys("devops@active.agency");
     driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Devops@1234");
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//button[.='Sign In']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[text()=' Settings']")).click();
     Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[text()='Admin Users']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[text()=' New']")).click();
	 Thread.sleep(2000); 
	 
	 String path="./excel-datas/Datadriver.xlsx";
	
	 Xlxutility xlx=new Xlxutility(path);
	 int totalrow=xlx.getRowCount("Sheet1");
	 int totalcell=xlx.getCellCount("Sheet1", 1);
	 
	 for(int r=1;r<=totalrow;r++)
	 {
		 
	     XSSFRow celldata=xlx.getsheet.getRow(r);
	     
	     String name=celldata.getCell(0).getStringCellValue();
	     String email=celldata.getCell(1).getStringCellValue();
	     String mobilenum = String.valueOf((long) celldata.getCell(2).getNumericCellValue());
	     String password=celldata.getCell(3).getStringCellValue();
	     String retypePassword=celldata.getCell(4).getStringCellValue();
	     String role=celldata.getCell(5).getStringCellValue();
	     
	        driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).sendKeys(name);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Mobile']")).sendKeys(mobilenum);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Enter at least 8+ characters']")).sendKeys(retypePassword);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@formcontrolname='DropdownControl']")).sendKeys(role);
		    Robot rob=new Robot();
			rob.keyPress(KeyEvent.VK_ENTER);
		    rob.keyRelease(KeyEvent.VK_ENTER);
		    driver.findElement(By.xpath("//button[.='Save']")).click();
		    driver.findElement(By.xpath("//button[.='OK']")).click();
	     
     }
   }
   @Test
   public void close()
   {
	   driver.quit();
   }
}
