package pageObjects;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class TestAddAdminUsers extends Basepage
{
  // public WebDriver driver;
   
	
   public TestAddAdminUsers(WebDriver driver)
   {
	  super(driver);   
   }

/*----------**** Creating a new admin user	***--------------*/
 private By side_menus              = By.xpath("//a[@class='nav-link nav-link-ref']/../../li");
 private By settings_menu           = By.xpath("//span[text()=' Settings']");
 private By admin_user_tab          = By.xpath("//a[text()='Admin Users']"); 
 private By new_button              = By.xpath("//button[text()=' New']"); 
 private By get_add_admin_user_label= By.xpath("//h1[.='Add Admin Users']"); 
 private By name_textfield          = By.xpath("//input[@placeholder='Enter full name']");
 private By mobile_textfield        = By.xpath("//input[@placeholder='Mobile']"); 
 private By email_textfield         = By.xpath("//input[@placeholder='Email']");
 private By password_textfield      = By.xpath("//input[@placeholder='Password']"); 
 private By retype_pwd_textfield    = By.xpath("//input[@placeholder='Enter at least 8+ characters']"); 
 private By role_dropdown           = By.xpath("//select[@formcontrolname='DropdownControl']"); 
 private By active_radio_btn        = By.xpath("(//div/input)[6]");
 private By inactive_radio_btn      = By.xpath("(//div/input)[7]");
 private By cancel_btn              = By.xpath("//button[.='Cancel']");
 private By save_btn                = By.xpath("//button[.='Save']");
 private By ok_btn_inconfm_popup    = By.xpath("//button[.='OK']");
 private By cancel_btn_inconfm_popup= By.xpath("(//button[.='Cancel'])[2]");
 

 /*----------**** edit admin user	***--------------*/
 By edit_icon            = By.xpath("(//span[@class='btn-sm-gray3 edit']/img)[1]");
 By edit_admin_user_label= By.xpath("//h1[.='Edit Admin Users']");
 By delete_btn           = By.xpath("//button[.=' Delete']");
 By pwd_eye_icon         = By.xpath("(//img[@class='imageplaceholder'])[1]"); 
 By retype_pwd_eye_icon  = By.xpath("(//img[@class='imageplaceholder'])[2]");
 
 
 /*----------**** Creating a new admin user	***--------------*/
 
 public void clicksSideMenu(String sideMenuName)
 {
	 List<WebElement> sidemenuitems =driver.findElements(side_menus);
	 
	 for(WebElement sidemenu:sidemenuitems)
     {
     	String gettext=sidemenu.getText();
     	
     	if(gettext.equalsIgnoreCase(sideMenuName))
     	{
     		sidemenu.click();
     		break;
     	}
     }
 }
 
 
 public void clicksSettingMenu() 
 {
	 driver.findElement(settings_menu).click();
 }
 
 public void clicksAdminUserTab() throws InterruptedException
 {
	 Thread.sleep(1000);
	 driver.findElement(admin_user_tab).click();
 }
 
 public String getAttributesTabText()
 {
	 search=new TestHomePage(driver);
	 return driver.findElement(search.attribute_tab).getText();
 }
 
 public String getAttributeValuesTabText()
 {
	 return driver.findElement(search.attribute_values_tab).getText();
	 
 }
 
 public String getClientRolesTabText()
 {
	 return driver.findElement(search.client_roles_tab).getText();
 }
 
 public String getAdminRolesTabText()
 {
	 return driver.findElement(search.admin_roles_tab).getText();
 }
 
 public String getAdminUsersTabText()
 {
	 return driver.findElement(admin_user_tab).getText();
 } 
 
 public void clicksNewButton() throws InterruptedException
 {
	 Thread.sleep(1000);
	 driver.findElement(new_button).click();
 }
 
 public String getAddAdminUserText()
 {
	return driver.findElement(get_add_admin_user_label).getText();
 }
 
 public String getAddAdminUserTextFamily()
 {
	return driver.findElement(get_add_admin_user_label).getCssValue("font-family");
 }
 
 public void setName(String name) throws InterruptedException
 {
	 Thread.sleep(1000);
	 driver.findElement(name_textfield).clear();
	 driver.findElement(name_textfield).sendKeys(name);
 }
 
 public void setMobileNumber(String mobile) throws InterruptedException
 {
	 Thread.sleep(1000);
	 driver.findElement(mobile_textfield).clear();
	 driver.findElement(mobile_textfield).sendKeys(mobile);
 }
 
 public void setEmail(String email)
 {
	
	 driver.findElement(email_textfield).clear();
	 driver.findElement(email_textfield).sendKeys(email);
 }
 
 public void setPassword(String newPassword)
 {
	 driver.findElement(password_textfield).clear();
	 driver.findElement(password_textfield).sendKeys(newPassword);
 }
 
 public void setRetypePassword(String retypePassword)
 {
	 driver.findElement(retype_pwd_textfield).clear();
	 driver.findElement(retype_pwd_textfield).sendKeys(retypePassword);
 }
 
 public void clicksPasswordEyeIcon()
 {
	 driver.findElement(pwd_eye_icon).click();
 }
 
 public void clicksRetypePasswordEyeIcon()
 {
	 driver.findElement(retype_pwd_eye_icon).click();
 }
 
 public void setAdminRole(String role) throws InterruptedException
 {
	 WebElement admin_role = driver.findElement(role_dropdown);

	 Select sel=new Select(admin_role);
     
	 if(role.equals("MANAGER"))
	 {
		System.out.println("This is not a ADMIN Role");
	 }
	 else if(role.equals("ASSOCIATE"))
	 {
		 System.out.println("This is not a ADMIN Role");
	 }
	 else if(role.equals("REVIEW ONLY"))
	 {
		 System.out.println("This is not a ADMIN Role");
	 }
	 else if(role.equals("ADMIN")) 
	 {
		 sel.selectByVisibleText("ADMIN"); 
	 }
	 else
	 {
		 System.out.println("ADMIN role is not there please select the other one....");
	 }
    }
	
 public void setActiveStatus()
 {
	 driver.findElement(active_radio_btn).click();
 }
 
 public void setInactiveStatus()
 {
	 driver.findElement(inactive_radio_btn).click();
 }
 
 public void clicksCancelButton()
 {
	 String exp="https://parklens-admin.tech-active.com/settings/admin-user";
     String act=driver.getCurrentUrl();
   
     if(exp.equals(act))
     {
     	Assert.assertEquals(act, exp);
        System.out.println("-------: "+act);
     }
     else
     {
     	driver.findElement(cancel_btn).click();
     } 
	 
 }
 
 public boolean saveButtonIsDisplayed() throws InterruptedException
 {
	 Thread.sleep(1000);
	 return driver.findElement(save_btn).isDisplayed();
 }
 
 public void clicksSaveButton() throws InterruptedException
 {
	 if(saveButtonIsDisplayed())
	 {
	   driver.findElement(save_btn).click();
	 }
	 else
	 {
		 System.out.println("save button is not found........");
	 }
 }
 public boolean OkButtonInConfirmPopupIsDisplayed()
 {
	 return driver.findElement(ok_btn_inconfm_popup).isDisplayed();
 }
 
 public void clicksOkButtonInConfirmPopup()
 {
	 if(OkButtonInConfirmPopupIsDisplayed())
	 {
	    driver.findElement(ok_btn_inconfm_popup).click();
	 }
	 else
	 {
		 System.out.println("Ok button is not found");
	 }
 }
 public void clicksCancelButtonInConfirmPopup()
 {
	 driver.findElement(cancel_btn_inconfm_popup).click();
 }
 
 //scrollIntoView method
 
 public void scrollIntoView(WebDriver driver, WebElement element)
 {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
 }
 
 
 /*------------------------------delete page-------------------------------*/
 
 public void clicksOnEditIcon()
 {
	 waitHelper(edit_icon);
	 driver.findElement(edit_icon).click();
 }
 
 public void clicksOnDeleteButton() throws InterruptedException
 {
//	 JavascriptExecutor js = (JavascriptExecutor) driver;
//     js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", delete_btn);
     Thread.sleep(1000);
     driver.findElement(delete_btn).click();
 }
 
 public void searchDeletedRecord(String getid) throws InterruptedException, AWTException
 {
	
     driver.findElement(By.xpath("//app-table/div/div/div[1]/input")).sendKeys(getid);
     Thread.sleep(2000);
     Robot rob=new Robot();
     rob.keyPress(KeyEvent.VK_ENTER);
     rob.keyRelease(KeyEvent.VK_ENTER);
     
     String recordnotFound=driver.findElement(By.xpath("//p[.='No Records Found']")).getText();
     System.out.println(recordnotFound);
     
//     Thread.sleep(3000);
//     WebElement record = driver.findElement(By.xpath("(//table/tbody/tr/td[1]/container-element/div)[1]"));
//     boolean displayed=record.isDisplayed();
//     System.out.println(displayed);
     
//     if(displayed)
//     {
//     	System.out.println("this record has not deleted...");
//     }
//     else
//     {
//     	System.out.println("this record has deleted...");
//     } 
     
 
 }
 
 
 
}
  
