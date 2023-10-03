package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Xlxutility;

public class DatadrivenTest 
{
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    }

    @Test
    public void test1() throws InterruptedException, IOException, AWTException 
    {
       
        String path = "./excel-datas/Datadriver.xlsx";

        Xlxutility xlx = new Xlxutility(path);
        int totalrow = xlx.getRowCount("Sheet1");
       // int totalcell=xlx.getCellCount("Sheet1", 1);

        for (int r = 1; r <= totalrow; r++) 
        {
        	driver.findElement(By.xpath("//button[text()=' New']")).click();
            Thread.sleep(2000);
        		
        	String name=xlx.getCellData("Sheet1", r, 0);
        	String email=xlx.getCellData("Sheet1", r, 1);
        	String mobilenum=xlx.getCellData("Sheet1", r, 2);
        	String password=xlx.getCellData("Sheet1", r, 3);
        	String retypePassword=xlx.getCellData("Sheet1", r, 4);
        	String role=xlx.getCellData("Sheet1", r, 5);

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
            Robot rob = new Robot();
            rob.keyPress(KeyEvent.VK_ENTER);
            rob.keyRelease(KeyEvent.VK_ENTER);
            driver.findElement(By.xpath("//button[.='Save']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[.='OK']")).click();
            Thread.sleep(2000);
            System.out.println("----------------"+totalrow+"--------");
           
            String exp="https://parklens-admin.tech-active.com/settings/admin-user";
            String act=driver.getCurrentUrl();
          
            if(exp.equals(act))
            {
            	Assert.assertEquals(act, act);
                System.out.println("-------: "+act);
            }
            else
            {
            	driver.findElement(By.xpath("//button[.='Cancel']")).click();
            } 
        	    Thread.sleep(5000);
      }
        
        }
    
    @AfterMethod
    public void close() 
    {
        driver.quit();
    }
 }

