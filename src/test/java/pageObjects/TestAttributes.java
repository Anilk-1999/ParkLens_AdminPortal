package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TestAttributes extends Basepage
{ 
	public TestAttributes(WebDriver driver) 
	{
        super(driver);
    }
    @FindBy(xpath = "//div//h1")WebElement editPageLable;
    @FindBy(xpath = "(//div//h1)[1]")WebElement homePageLable;
    @FindBy(xpath = "//tbody/tr[1]/td[2]")WebElement nameInTable;
    @FindBy(xpath = "//tbody/tr[1]/td[1]")WebElement idInTable;
    @FindBy(xpath = "//input[@placeholder='Attribute Name']")WebElement attributeNametextfield;
    @FindBy(xpath = "//textarea[@placeholder='60 Characters only']")WebElement Description;
    @FindBy(xpath = "(//div[@class='page-content']//div)[2]/../h1")WebElement addPageLable;
    @FindBy(xpath = "//div[@class='swal2-html-container']")WebElement confirmMessage;
 // @FindBy(xpath = "//a[.='Attributes']") WebElement attributeTabText;
    

    public String getAttributeTabText()
    {
    	//return attributeTabText.getText();
    	
    	return driver.findElement(By.xpath("//a[.='Attributes']")).getText();
    }
    
  // common for every fatures
    public String getcurrectURL() throws InterruptedException
    {
    	Thread.sleep(2000);
    	return driver.getCurrentUrl();
    }
    
    public String getPageTitle()
    {   
    	return driver.getTitle();
    }
    
    public String getHomePageHeaderLable() throws InterruptedException
    {
    	Thread.sleep(1000);
    	return homePageLable.getText();
    }
    
    public String getNameInTable()
    {
    	return nameInTable.getText();
    }
    
    public String getID()
    {
    	return idInTable.getText();
    }
    
    public String getAddPageHeaderLable() throws InterruptedException
    {
    	Thread.sleep(1000);
    	return addPageLable.getText();
    }
    
    public String getConfirmationMassage()
    {
    	return confirmMessage.getText();
    }
    
    public boolean ConfirmationMassageDisplayed() throws InterruptedException
    {
    	//Thread.sleep(2000);
    	return confirmMessage.isDisplayed();
    }
    
    public String getEditPageHeaderLable() throws InterruptedException
    {
    	Thread.sleep(1000);
    	return editPageLable.getText();
    }
 // common for every fatures end
    
 /*---------------------------Add attributes-------------------------*/    
    
    public void setAttributeName(String AttributeName) throws InterruptedException
    {
    	Thread.sleep(1000);
    	attributeNametextfield.clear();
    	attributeNametextfield.sendKeys(AttributeName);
    }
    public void setDescription(String AttributeDesc)
    {
    	Description.clear();
    	Description.sendKeys(AttributeDesc);
    }
    

  
   
    
    
    
}
