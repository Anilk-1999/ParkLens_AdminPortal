package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class TestAttributeValues extends Basepage
{
	
	public TestAttributeValues(WebDriver driver)
	{
		super(driver);
	}
	 
	private By header_tabs           =By.xpath("//div[@class='container-fluid']/ul/li");
	private By attributeDropdown     =By.tagName("select");
	private By clientDropdown        =By.xpath("//span[@class='ng-arrow-wrapper']");
	private By clientDropdownoptions =By.xpath("(//div[@class='ng-dropdown-panel-items scroll-host']/div)[2]/div");
	private By attributeValueName    =By.xpath("//input[@placeholder='Attribute Value Name']");

	
	public void clickOnHeaderTab(String headertabName)
	{
	     List<WebElement> headertabs = driver.findElements(header_tabs);
	     int countheaderTabs = headertabs.size();
	     
		for(int t=0;t<countheaderTabs;t++)
		{
			WebElement tabs = headertabs.get(t);
			String gettabText=tabs.getText();
	       if(gettabText.equals(headertabName))
	       {
	    	   tabs.click();
	       }
	       else
	       {
	    	   System.out.println("please select the valid header tab!!!");
	       }
	       
		}
	}
	
	public void setAttributeDropdown(String attributeName)
	{
		WebElement attributeOptions=driver.findElement(attributeDropdown);
	    
		Select selectAttribute=new Select(attributeOptions);
		selectAttribute.selectByVisibleText(attributeName);
	}
	 
	public void setAttributeDropdownRandomly() throws InterruptedException
	{
		WebElement attributeOptions = driver.findElement(attributeDropdown);

         Thread.sleep(2000);
		
		Select selectAttribute = new Select(attributeOptions);
		List<WebElement> options = selectAttribute.getOptions();

		int countOptions = options.size();
		int randomIndex = (int) (Math.random() * (countOptions - 1)) + 1;
   
		selectAttribute.selectByIndex(randomIndex);

	}
	
	public void setClientDropdown(String clientName)
	{
		List<WebElement> clientOptions=driver.findElements(clientDropdownoptions);
		int countClients=clientOptions.size();
		
	       for(int c=0;c<countClients;c++)
	       {
	    	   driver.findElement(clientDropdown).click();
	    	   WebElement dropdownOptions = clientOptions.get(c);
	    	   String getClientText=dropdownOptions.getText();
	    	   
	    	   if(getClientText.equals(clientName))
	    	   {
	    		   dropdownOptions.click();
	    		   break;
	    	   }
	       }   
	}
	
	public void clickOnClientDropdown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(clientDropdown).click();
	}
	
	public void setClientDropdownRandomly() throws InterruptedException
	{
		clickOnClientDropdown();
		List<WebElement> clientOptions = driver.findElements(clientDropdownoptions);
	    int countClients = clientOptions.size();
	    
	    int randomIndex = (int) (Math.random() * countClients);
	    WebElement dropdownOption = clientOptions.get(randomIndex);
	    dropdownOption.click();
	}

	public void setAttributeValueName(String valueName) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(attributeValueName).clear();
		driver.findElement(attributeValueName).sendKeys(valueName);
	}
	 	 
}
