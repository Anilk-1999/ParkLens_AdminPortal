package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TestClientUsers extends Basepage
{
  public TestClientUsers(WebDriver driver)
   {
	   super(driver);
   }
   
   @FindBy(xpath = "(//input[@placeholder='Enter full name'])[1]")
   WebElement enter_name;
   
   @FindBy(xpath = "(//input[@placeholder='Enter full name'])[2]")
   WebElement enter_fullname;
  
   @FindBy(xpath = "//input[@placeholder='Retype Password']")
   WebElement retype_password;
   
   @FindBy(xpath = "(//select[@formcontrolname='DropdownControl'])[2]")
   WebElement role_dropdown;
   
   @FindBy(xpath = "//span[@class='ng-arrow-wrapper']")
   WebElement lot_dropdown;
   
   @FindBy(xpath = "(//div[@class='ng-dropdown-panel-items scroll-host']//div[2])/div")
   List<WebElement> lotdropdown_options; 
 
   
   public void setName(String userName)
   {
	   enter_name.clear();
	   enter_name.sendKeys(userName);
   }
   
   public void setFullName(String userFullName)
   {
	   enter_fullname.clear();
	   enter_fullname.sendKeys(userFullName);
   }
   
   public void setRetypePassword(String retypePassword)
   {
	   retype_password.clear();
	   retype_password.sendKeys(retypePassword);
   }
   
   public void setParticularClientRoleOnDropdown(String roleName)
   {
	   Select selectRole=new Select(role_dropdown);
	   selectRole.selectByVisibleText(roleName);
   }
   
   public void setClientRoleRandomlyOnDropdown()
   {
	   Select selectRole=new Select(role_dropdown);
	   List<WebElement> options = selectRole.getOptions();
	   
	   int optionsSize=options.size();
	   int randomOPtions=(int)(Math.random()*(optionsSize-1))+1;
	   
	   selectRole.selectByIndex(randomOPtions);
   }
   
   public void setLotsRandomlyOnDropdown()
   {
	   lot_dropdown.click();
	
	   int optionsSize=lotdropdown_options.size();
	   int optionsRandomly=(int)(Math.random()*optionsSize);
	   
	   WebElement lotoptions=lotdropdown_options.get(optionsRandomly);
	   lotoptions.click();
   }
   
   
}

 
