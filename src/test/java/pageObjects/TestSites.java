package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TestSites extends Basepage
{
  public TestSites(WebDriver driver) 
  {
	super(driver);
  }
  
  
  @FindBy(xpath = "(//select[@formcontrolname='DropdownControl'])[1]")
  WebElement client_dropdown;
  
  @FindBy(xpath = "//input[@placeholder='Enter Site Title']")
  WebElement title_textfield;
  
  
  
  
  public void selectParticularClientOnDropdown(String ClientName)
  {
//	  WaitHelper waiter=new WaitHelper(driver);
//	  waiter.waitforElement(client_dropdown, 30);
	  Select selectClient=new Select(client_dropdown);
	  selectClient.selectByVisibleText(ClientName);
  }
  												
  public void selectClientOnDropdownRandomly() throws InterruptedException
  {
	  Select selectClient=new Select(client_dropdown);
	  List<WebElement> options=selectClient.getOptions();
	  
	  int countOptions = options.size();
	  int randomIndex = (int) (Math.random() * (countOptions-1))+1;
      Thread.sleep(2000);
	  selectClient.selectByIndex(randomIndex);
	  
  }
  
  public void setTitle(String title)
  {
	 title_textfield.clear();
	 title_textfield.sendKeys(title);
  }
  
  
}
