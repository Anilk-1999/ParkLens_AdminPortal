package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

public class TestClients extends Basepage 
{
	WaitHelper wait;
	
	public TestClients(WebDriver driver)
	{
		super(driver);
	}
	

	private @FindBy(xpath = "//input[@placeholder='Client Name']")WebElement client_name;
	private @FindBy(xpath = "//input[@placeholder='Address 1']")WebElement address_one;
	private @FindBy(xpath = "//input[@placeholder='Address 2']")WebElement address_two;
	private @FindBy(xpath = "//input[@placeholder='Address 3']")WebElement address_three;
	private @FindBy(xpath = "(//app-dropdown/div/select)[1]")WebElement country_dropdown;
	private @FindBy(xpath = "(//app-dropdown/div/select)[2]")WebElement state_dropdown;
	private @FindBy(xpath = "(//app-dropdown/div/select)[3]")WebElement city_dropdown;
	private @FindBy(xpath = "(//app-dropdown/div/select)[4]")WebElement client_type;
	private @FindBy(xpath = "(//button/i)[1]")WebElement start_date_picker;
	private @FindBy(xpath = "(//button/i)[2]")WebElement end_date_picker;
	private @FindBy(xpath = "//select[@title='Select year']")WebElement year_dropdown;
	private @FindBy(xpath = "//select[@title='Select month']")WebElement month_dropdown;
	private @FindBy(xpath = "//div[@role='gridcell']/div")List<WebElement> days_picker;
	
	 By get_table_row        = By.xpath("//table[@class='table']//tbody/tr");
	 By get_table_column     = By.xpath("//table[@class='table']//tbody/tr/td");
	 By table_header         = By.xpath("//table/thead/tr/th");
	 By table_firstrow_data  = By.xpath("//table[@class='table']//tbody/tr[1]/td");
	 By table_secondrow_data = By.xpath("//table[@class='table']//tbody/tr[2]/td");
	
	public void setClientName(String clientName)
	{
		wait=new WaitHelper(driver);
		wait.waitforElement(client_name, 30);
		client_name.clear();
		client_name.sendKeys(clientName);
	}	
	
	public void setAddressOne(String addressOne)
	{
		wait.waitforElement(address_one, 30);
		address_one.clear();
		address_one.sendKeys(addressOne);
	}
	
	public void setAddressTwo(String addressTwo)
	{
		wait.waitforElement(address_two, 30);
		address_two.clear();
		address_two.sendKeys(addressTwo);
	}
	
	public void setAddressThree(String addressThree)
	{
		wait.waitforElement(address_three, 30);
		address_three.clear();
		address_three.sendKeys(addressThree);
	}

	public void selectCountryDropdown(String country)
	{
		   wait.waitforElement(country_dropdown, 30);
           Select selectcountry=new Select(country_dropdown);
           selectcountry.selectByVisibleText(country);
	}
	
	public void selectStateDropdown(String state)
	{
		wait.waitforElement(state_dropdown, 30);
		Select selectstate=new Select(state_dropdown);
		selectstate.selectByVisibleText(state);
	}
	
	public void selectCityDropdown(String city)
	{
		wait.waitforElement(city_dropdown, 30);
		Select selectcity=new Select(city_dropdown);
		selectcity.selectByVisibleText(city);
	}
	
	public void selectClientType(String clientType)
	{
		wait.waitforElement(client_type, 30);
		Select selectclientType=new Select(client_type);
	    selectclientType.selectByVisibleText(clientType);
	}
	
	public void clickOnStartDatePicker()
	{
		wait.waitforElement(start_date_picker, 30);
		start_date_picker.click();
	}
	
	public void clickOnEndDatePicker()
	{
		wait.waitforElement(end_date_picker, 30);
		end_date_picker.click();
	}
	
	public void DatePicker(String desiredDate)
	{
		//String desiredDate = "2024/Oct/5";
	     String[] dateParts = desiredDate.split("/");
	     String year = dateParts[0];
	     String month = dateParts[1];
	     String day = dateParts[2];
	     wait.waitforElement(year_dropdown, 30);
	     year_dropdown.sendKeys(year);
	     wait.waitforElement(month_dropdown, 30);
	     month_dropdown.sendKeys(month);
	     
	     wait.waitforElement(days_picker, 30);
	     int daysize=days_picker.size();
	     for(int d=0;d<daysize-1;d++)
	     {
	    	 WebElement days=days_picker.get(d);
	    	 String getdaytext=days.getText();
	    	
	    	 if(getdaytext.equals(day))
	    	 {
	             days.click(); 
	             break;
	    	 }
	     }
	}
	
	
	
	 
	
	
}
