package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper 
{
  WebDriver driver;
  
  public WaitHelper(WebDriver driver)
  {
	  this.driver=driver;
  }
  
  public void waitforElement(WebElement element,Duration timeforSecond)
  {
	 WebDriverWait wait=new WebDriverWait(driver, timeforSecond);
	 wait.until(ExpectedConditions.visibilityOf(element));
  }

public void waitforElement(WebElement element, int i) {
	// TODO Auto-generated method stub
	
}

public void waitforElement(By get_add_admin_user_label, int i) {
	// TODO Auto-generated method stub
	
}

public void waitforElement(List<WebElement> days_picker, int i) {
	// TODO Auto-generated method stub
	
}


  	
}
