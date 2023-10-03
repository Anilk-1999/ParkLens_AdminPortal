package pageObjects;

import java.awt.AWTException;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TestStalls extends Basepage
{
   WebDriver  driver;
   
	public TestStalls(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "(//span[@title='Stalls']/img)[1]")
	private WebElement stalls_firsticon;
	
	@FindBy(xpath = "//button[@class='btn-i-gray3']")
	private WebElement list_icon;
	
	@FindBy(xpath = "//select[@formcontrolname='DropdownControl']")
	private WebElement camera_dropdown;
	
	@FindBy(xpath = "//div[@class='d-flex flex-wrap']//label")
	private List<WebElement> status_text;
	
    @FindBy(xpath = "//div[@class='d-flex flex-wrap']//input")
    private List<WebElement> status_checkbox;
	
    @FindBy(xpath = "//button[@class='btn-i-secondary']")
    private WebElement map_icon;
    
	@FindBy(xpath = "//span/input")
    private List<WebElement> bulk_checkBoxs;
	
	@FindBy(xpath = "//button[.='Apply']")
	private WebElement apply_button;
	
    @FindBy(xpath = "//button[.='Report Error']")
	private WebElement report_button;
	
	@FindBy(xpath = "//div[@class='ng-value-container']")
	private List<WebElement> attribute_attributevalue_fields;
    
	@FindBy(xpath = "//div[@class='ng-untouched ng-pristine ng-invalid']/label")
	private List<WebElement> attribute_attributevalue_lables;
    
	@FindBy(xpath = "(//div[@class='ng-dropdown-panel-items scroll-host']//div[2])/div")
	private List<WebElement> dropdown_options;
	
	@FindBy(xpath = "//button[.='Update']")
    private WebElement update_btn;
	
	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper']/span)[1]")
	private WebElement attributedropdown;
	
	@FindBy(xpath = "(//div[@class='ng-placeholder'])[2]")
	private WebElement attributeValuedropdown;
	
	
	public void clickOnStallsListIcon()
	{
	    waitHelper(list_icon);
		list_icon.click();
	}
	
	public void selectCameraRandomlyInDropDown()
	{
		try
		{
		  waitHelper(camera_dropdown);
          Select selectcamera=new Select(camera_dropdown);
          List<WebElement> getoptions = selectcamera.getOptions();
          
          int getsize=getoptions.size();
          int randomOptions=(int)(Math.random()* (getsize-1))+1;
          selectcamera.selectByIndex(randomOptions);
          System.out.println("The selected camera is : "+randomOptions);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void selectPerticulerCameraInDropDown(String cameraName)
	{
		try 
		{
		  waitHelper(camera_dropdown);
          Select selectcamera=new Select(camera_dropdown);
          selectcamera.selectByVisibleText(cameraName);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
          
	}
	
	public void clickOnStatusCheckBox(String statusName) throws InterruptedException
	{
		try 
		{
		waitHelper(status_text);
		int statusTextSize=status_text.size();
		
		for(int s=0;s<statusTextSize;s++)
		{
			WebElement getstatuscount=status_text.get(s);
			waitHelper(status_checkbox);
			WebElement countCheckBox=status_checkbox.get(s);
			
			String getstatusText=getstatuscount.getText();
			System.out.println("The status is : "+getstatusText);
			
			if(getstatusText.equalsIgnoreCase(statusName))
			{
				waitHelper(countCheckBox);
				scrollDownUsingRobot();
				countCheckBox.click();
				break;
			}
			else
			{
				System.out.println("This is not a valid status check another.....");
			}
		}
		}
		catch(Exception e)
		{
		   System.out.println(e);
		}
	}
	
	
	
	public void setAttributesRandomlyInDropDown(String name)
	{
		try
		{
			scrollDownUsingRobot();
		    int getsize=attribute_attributevalue_lables.size();
		    System.out.println(getsize);
		  
		for(int a=0;a<getsize;a++)
		{
			WebElement countlable=attribute_attributevalue_lables.get(a);
			WebElement countfield=attribute_attributevalue_fields.get(a);
			
			String getlabelText=countlable.getText();
			System.out.println("-----"+getlabelText);
			
			if(getlabelText.equals(name))
			{
				waitHelper(countfield);
				countfield.click();
				Thread.sleep(1000);
				
				int optionsize=dropdown_options.size();
				int randomOptions=(int)(Math.random()*optionsize);
				WebElement countOptions=dropdown_options.get(randomOptions);
				countOptions.click();
			}
			else
			{
				System.out.println("Please select the valid Option......");
			}
		 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void setAttributesValuesRandomlyInDropDown(String name)
	{
		try
		{
			scrollDownUsingRobot();
		    int getsize=attribute_attributevalue_lables.size();
		    System.out.println(getsize);
		  
		for(int a=0;a<getsize;a++)
		{
			WebElement countlable=attribute_attributevalue_lables.get(a);
			WebElement countfield=attribute_attributevalue_fields.get(a+1);
			
			String getlabelText=countlable.getText();
			System.out.println("-----"+getlabelText);
			
			if(getlabelText.equals(name))
			{
				waitHelper(countfield);
				countfield.click();
				Thread.sleep(1000);
				
				int optionsize=dropdown_options.size();
				int randomOptions=(int)(Math.random()*optionsize);
				WebElement countOptions=dropdown_options.get(randomOptions);
				countOptions.click();
			}
			else
			{
				System.out.println("Please select the valid Option......");
			}
		 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	public void clickOnMapIcon()
	{
		waitHelper(map_icon);
		map_icon.click();
	}
	
	public void clickOnApplyButton()
	{
		waitHelper(apply_button);
		apply_button.click();
	}
	
	public void BulkCheckboxSelection()
	{
		for(WebElement checkBox:bulk_checkBoxs)
		{
			waitHelper(checkBox);
			checkBox.click();
			break;
		}
	}
	
	public void clickOnReportButton()
	{
		waitHelper(report_button);
		report_button.click();
	}
	
	public void clicksOnUpdateButton() throws InterruptedException, AWTException
    {
		waitHelper(update_btn);
		scrollDownUsingRobot();
    	update_btn.click();
    }
	
	public void clickOnStallIcon()
	{	
		waitHelper(stalls_firsticon);
		System.out.println("1.stall icon");
		stalls_firsticon.click();
		System.out.println("2.stall icon");
	}
}
