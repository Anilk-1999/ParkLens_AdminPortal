package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class Basepage
{
	
	public TestHomePage search;
	public WebDriver driver;
	
	public Basepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void waitHelper(WebElement element)
	{
		WaitHelper wait = new WaitHelper(driver); 
		wait.waitforElement(element,30);
	}
	
	public void waitHelper(List<WebElement> element)
	{
		WaitHelper wait = new WaitHelper(driver); 
		wait.waitforElement(element,30);
	}
	
	public void waitHelper(By element)
	{
		WaitHelper wait = new WaitHelper(driver); 
		wait.waitforElement(element,30);
	}
	
	public void scrollIntoView(WebDriver driver, WebElement element)
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
//		 js.executeScript("window.scrollBy(0, 5000);");
	 }
	
	public void scrollDownUsingRobot() throws AWTException, InterruptedException
	{
		Thread.sleep(2000);
		Robot rt=new Robot();
		rt.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		rt.keyRelease(KeyEvent.VK_DOWN);
	}
	
}
