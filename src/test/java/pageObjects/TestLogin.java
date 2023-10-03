package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitHelper;

public class TestLogin extends Basepage 
{
	public WebDriver driver;
	public WaitHelper wait;
	
    public TestLogin(WebDriver driver)
    {
    	super(driver);
    }
    @FindBy(xpath = "//input[@placeholder='Enter Email']")WebElement email_id;
    @FindBy(xpath = "//input[@placeholder='Enter Password']")WebElement password;
    @FindBy(id = "dropdownCheck")WebElement rememberme_checkbox;
    @FindBy(xpath = "//button[.='Sign In']")WebElement signin_btn;
    @FindBy(xpath = "//h1[.='Dashboard']")WebElement get_dash_text;
    @FindBy(xpath = "//h2[text()='Welcome !']")WebElement getwelcome_text;
    @FindBy(xpath = "//a[@id='profileDropdown']/img")WebElement profile_icon;
    @FindBy(xpath = "//img[@class='wd-80 ht-80 rounded-circle']")WebElement profile_logo;
    @FindBy(xpath = "//span[.='Log Out']")WebElement logout_link;
    @FindBy(xpath = "//a[.='Forgot your password?']")WebElement forgot_link;
    
    
    public void setEmail(String mail)
    {
    	email_id.clear();
    	email_id.sendKeys(mail);
    }
    
    public void setPassword(String pwd)
    {
    	password.clear();
    	password.sendKeys(pwd);
    }
    
    public void setRememberme()
    {
    	rememberme_checkbox.click();
    }
    
    public void clicksigninButton() throws InterruptedException
    {
    	signin_btn.click();
        wait=new WaitHelper(driver);
    	wait.waitforElement(get_dash_text, 30);
    }
    
    public String getDashboardText() throws InterruptedException
    {
    	wait.waitforElement(get_dash_text, 30);
    	return  get_dash_text.getText();
    	
    }
    
    public String getWelcomeText()
    {
    	wait.waitforElement(getwelcome_text, 30);
    	return getwelcome_text.getText();
    }
    
    public void clicksProfileIcon() throws InterruptedException
    {
    	Thread.sleep(3000);
    	profile_icon.click();
    }
    
    public boolean verifyProfileLogo() throws InterruptedException
    {
    	wait.waitforElement(profile_logo, 30);
    	Thread.sleep(1000);
    	return profile_logo.isDisplayed();
        
    }
    
    public void clicksLogout() throws InterruptedException
    {
    	wait.waitforElement(logout_link, 30);
    	logout_link.click();
    }
    
    public String getForgotlinktextcolour()
    {
    	wait.waitforElement(forgot_link, 30);
    	return forgot_link.getCssValue("color");
      
    }

}
