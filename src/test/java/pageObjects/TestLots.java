package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TestLots extends Basepage 
{
	TestAddAdminUsers adminUsers;
	
    public TestLots(WebDriver driver)
    {
    	super(driver);
    }
    
    
    @FindBy(xpath = "(//select[@formcontrolname='DropdownControl'])[2]")
    WebElement site_dropdown;
    
    @FindBy(xpath = "//input[@placeholder='Enter Lot Name']")
    WebElement lot_name_textfield;
    
    @FindBy(xpath = "//input[@placeholder='Enter Lot Title (Display Name)']")
    WebElement lot_title_textfield;
    
    @FindBy(xpath = "//input[@placeholder='Enter parking duration']")
    WebElement parking_duration_textfield;
    
    @FindBy(xpath = "(//input[@formcontrolname='radio'])[1]")
    WebElement indoor_radio_buttons;
    
    @FindBy(xpath = "(//input[@formcontrolname='radio'])[2]")
    WebElement outdoor_radio_buttons;
        
    @FindBy(xpath = "//label[.=' Indoor ']")
    WebElement indoor_text;
    
    @FindBy(xpath = "//label[.=' Outdoor ']")
    WebElement outdoor_text;
    
    @FindBy(xpath = "(//span/img)[1]")
    WebElement lotoverlay_fileuploadfield;
    
    @FindBy(xpath = "(//span/img)[2]")
    WebElement kml_fileuploadfield;
    
    @FindBy(xpath = "//input[@placeholder='Latitude']")
    WebElement latitude_textfield;
    
    @FindBy(xpath = "//input[@placeholder='Longitude']")
    WebElement longitude_textfield;
    
    @FindBy(xpath = "//input[@placeholder='SW']")
    WebElement sw_textfield;
    
    @FindBy(xpath = "//input[@placeholder='NE']")
    WebElement ne_textfield;
    
    @FindBy(xpath = "//span[.='Edit Overlay']")
    WebElement editoverlay_link;
    
    @FindBy(xpath = "//button[.='Update']")
    WebElement update_btn;
    
    @FindBy(xpath = "//a[.='General']")
    WebElement general_link;
    
    @FindBy(xpath = "//a[.='Violation']")
    WebElement violation_link;
    
 /*----------------------------violation fines page-----------------------------------*/
    
    @FindBy(xpath = "(//button[@class='btn-sm-wide-gray3-d']/img)[1]")
    WebElement edit_icon;
    
    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-valid ng-touched'])[1]")
    WebElement exempted_durationTextfield;
    
    @FindBy(xpath = "(//input[@class='form-control ng-pristine ng-valid ng-touched'])[2]")
    WebElement flatFee_textfield;
    
    
    public void selectParticularSiteOnDropdown(String siteName)
    {
    	Select selectsite=new Select(site_dropdown);
    	selectsite.selectByVisibleText(siteName);
    }
    
    public void selectSiteOnDropdownRandomly()
    {
    	Select selectsite=new Select(site_dropdown);
    	List<WebElement> options=selectsite.getOptions();
    	
    	int countoptions=options.size();
    	int randomsite=(int)(Math.random()*(countoptions-1))+1;
    	
    	selectsite.selectByIndex(randomsite);
    	
    }
    
    public void setLotName(String lotName)
    {
    	lot_name_textfield.sendKeys(lotName);
    }
    
    public void setLotTitle(String lotTitle)
    {
    	lot_title_textfield.sendKeys(lotTitle);
    }
    
    public void setParkingDuration(String parkingDuration)
    {
    	parking_duration_textfield.sendKeys(parkingDuration);
    }
    
    public String getIndoorText()
    {
    	return indoor_text.getText();
    }
    
    public String getOutdoorText()
    {
    	return outdoor_text.getText();
    }
    
    public void setLocation(String location)
    {
    	try 
    	{	
    	  if(getIndoorText().equals(location))
    	  {
    		 indoor_radio_buttons.click();
    	  }
    	  else if(getOutdoorText().equals(location))
    	  {
    		 outdoor_radio_buttons.click();
    	  }
    	  else
    	  {
    		 System.out.println("Please select the valid radio button..........");
    	  }
    	} 
    	catch (Exception e)
    	{
		    System.out.println("The exception is : "+e);	
		}
    }
    
    public void setEntranceCoordinates(String latitude,String longitude) throws InterruptedException
    {
    	latitude_textfield.clear();
    	latitude_textfield.sendKeys(latitude);
    	Thread.sleep(1000);
    	longitude_textfield.clear();
    	longitude_textfield.sendKeys(longitude);
    }
    
    public void uploadLotOverlayImage(String imagePath) throws AWTException, InterruptedException
    {
        adminUsers=new TestAddAdminUsers(driver);
    	adminUsers.scrollIntoView(driver, lotoverlay_fileuploadfield);
    	Thread.sleep(1000);
    	lotoverlay_fileuploadfield.click();
    	
    	Robot rob=new Robot();
    	rob.delay(2000);
    	
    	StringSelection copyPath=new StringSelection(imagePath);
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copyPath, null);
    	
    	rob.keyPress(KeyEvent.VK_CONTROL);
    	rob.keyPress(KeyEvent.VK_V);
    	rob.keyRelease(KeyEvent.VK_CONTROL);
    	rob.keyRelease(KeyEvent.VK_V);
    	
    	rob.keyPress(KeyEvent.VK_ENTER);
    	rob.keyRelease(KeyEvent.VK_ENTER);
    	
    }
    
    public void uploadKmlMap(String kmlmapfilePath) throws AWTException
    {
    	kml_fileuploadfield.click();
    	
    	Robot rob=new Robot();
    	rob.delay(2000);
    	
    	StringSelection copyPath=new StringSelection(kmlmapfilePath);
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copyPath, null);
    	
    	rob.keyPress(KeyEvent.VK_CONTROL);
    	rob.keyPress(KeyEvent.VK_V);
    	rob.keyRelease(KeyEvent.VK_CONTROL);
    	rob.keyRelease(KeyEvent.VK_V);
    	
    	rob.keyPress(KeyEvent.VK_ENTER);
    	rob.keyRelease(KeyEvent.VK_ENTER);
    	
    }
    
    public void setLotOverlayCoordinates(String sw,String ne) throws InterruptedException
    {
    	sw_textfield.clear();
    	sw_textfield.sendKeys(sw);
    	
    	Thread.sleep(1000);
    	
    	ne_textfield.clear();
    	ne_textfield.sendKeys(ne);
    }
    
    public void clicksEditOverlayLink() throws InterruptedException
    {
    	Thread.sleep(1000);
    	editoverlay_link.click();
    }
    
    public void clicksOnUpdateButton() throws InterruptedException
    {
    	adminUsers.scrollIntoView(driver, update_btn);
    	Thread.sleep(500);
    	update_btn.click();
    }
    
    public void clicksOnGeneralLink() throws InterruptedException
    {
    	adminUsers.scrollIntoView(driver, general_link);
    	Thread.sleep(500);
    	general_link.click();
    }
    
    public void clicksOnViolationLink() throws InterruptedException
    {
    	Thread.sleep(2000);
    	adminUsers.scrollIntoView(driver, violation_link);
    	Thread.sleep(500);
    	violation_link.click();
    }
    
    public void setExemptedDuration(String exempted_duration) throws InterruptedException
    {
//    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//    	WebElement popup = edit_icon;
//    	jsExecutor.executeScript("arguments[0].style.display = 'block';", popup);
    	

    	Thread.sleep(500);
    	exempted_durationTextfield.clear();
    	exempted_durationTextfield.sendKeys(exempted_duration);
    }
    
    public void setFlatFees(String flatFee) throws InterruptedException
    {
//    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//    	WebElement popup = flatFee_textfield;
//    	jsExecutor.executeScript("arguments[0].style.display = 'block';", popup);
    	Thread.sleep(500);
    	flatFee_textfield.clear();
    	flatFee_textfield.sendKeys(flatFee);
    }
    
    public void clicksOnEditIcon() throws InterruptedException
    {
    	Thread.sleep(500);
    	edit_icon.click();
    }
    	
}
