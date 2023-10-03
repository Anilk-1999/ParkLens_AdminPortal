package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TestCameras extends Basepage 
{
   public TestCameras(WebDriver driver)
   {
	   super(driver);
   }
   
   
   @FindBy(xpath = "//input[@placeholder='Enter Camera Name']")
   WebElement camera_name_field;
   
   @FindBy(xpath = "//input[@placeholder='Enter the Camera Access URL']")
   WebElement camera_url_field;
   
   @FindBy(xpath = "(//select[@formcontrolname='DropdownControl'])[3]")
   WebElement lot_dropdown;
   
   @FindBy(xpath = "//span[@class='ng-arrow-wrapper']")
   WebElement stalls_dropdown;
   
   @FindBy(xpath = "//input[@type='checkbox']")
   List<WebElement> indropdown_stallscheckboxs;
                    
   @FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']/div/div")
   List<WebElement> indropdown_stallsoptiontexts;
   
   
   public void setCameraName(String cameraName)
   {
	   camera_name_field.clear();
	   camera_name_field.sendKeys(cameraName);
   }
   
   public void setCameraURL(String cameraURL)
   {
	   camera_url_field.click();
	   camera_url_field.clear();
	   camera_url_field.sendKeys(cameraURL);
   }
   
   public void setParticularLotOnDropdown(String lotName)
   {
	   Select selectlot=new Select(lot_dropdown);
	   selectlot.selectByVisibleText(lotName);
   }
   
   public void setLotRandomlyOnDropdown()
   {
	   Select selectlot=new Select(lot_dropdown);
	   List<WebElement> lotOptions=selectlot.getOptions();
	   
	   int lotcounts=lotOptions.size();
	   int randomOptions=(int)(Math.random()*(lotcounts-1))+1;
	   
	   selectlot.selectByIndex(randomOptions);
   }
   
   public void setAllStallsOnDropdown()
   {
	  stalls_dropdown.click();
	 
		int countoptions=indropdown_stallsoptiontexts.size();
		for(int i=0; i<countoptions-1;i++)
		{
			WebElement allcheckboxs=indropdown_stallscheckboxs.get(i);
			WebElement totalOptions=indropdown_stallsoptiontexts.get(i);
			String getoptiontexts=totalOptions.getText();
			
			if(getoptiontexts.equalsIgnoreCase("select all"))
			{
				allcheckboxs.click();
				break;
			}
			
		}
		
	  
   }
   
}
