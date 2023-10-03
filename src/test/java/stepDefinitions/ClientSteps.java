package stepDefinitions;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributes;
import pageObjects.TestClients;
import pageObjects.TestHomePage;
import testBase.Baseclass;


public class ClientSteps extends Baseclass
{

//  -----------------------	Client creation ----------------------------
	
	@When("Clicks the client side menu")
	public void clicks_the_client_side_menu() throws InterruptedException 
	{
	    String sideMenuName="clients";
		
	    adminUser=new TestAddAdminUsers(driver);
	    adminUser.clicksSideMenu(sideMenuName); 
	    Thread.sleep(2000);
	}

	@Then("Make sure that the client information page should appears")
	public void make_sure_that_the_client_information_page_should_appears() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    String actualResult=attributes.getHomePageHeaderLable();
	    Assert.assertEquals(actualResult, "Clients");
	}

	@Then("Verify i should navigate to the add client page")
	public void verify_i_should_navigate_to_the_add_client_page() throws InterruptedException 
	{
	    Assert.assertTrue(true, attributes.getAddPageHeaderLable());
	}

	@When("Fill all the required client informations:")
	public void fill_all_the_required_client_informations() throws InterruptedException 
	{
		try
		{
		String clientName="client1";
		String mobileNumber="9865321470";
		String emailID="client@gmail.com";
		String address1="bogadi 1st stage";
		String address2="bogadi 2nd stage";
		String address3="bogadi 3rd stage";
		String country="INDIA";
		String state="KARNATAKA";
		String city="MYSURU";
		String startdate="2023/Oct/5";
		String enddate="2024/Oct/5";
		String clientType="Live";
		clients=new TestClients(driver);
	    clients.setClientName(clientName);
	    adminUser.setMobileNumber(mobileNumber);
	    adminUser.setEmail(emailID);
	    clients.setAddressOne(address1);
	    clients.setAddressTwo(address2);
	    clients.setAddressThree(address3);
	    Thread.sleep(1000);
	    clients.selectCountryDropdown(country);
	    Thread.sleep(1000);
	    clients.selectStateDropdown(state);
	    Thread.sleep(1000);
	    clients.selectCityDropdown(city);
	    Thread.sleep(1000);
	    clients.selectClientType(clientType);
	    Thread.sleep(1000);
	    clients.clickOnStartDatePicker();
	    clients.DatePicker(startdate);
	    Thread.sleep(1000);
	    clients.clickOnEndDatePicker();
	    clients.DatePicker(enddate);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	@Then("The new client should be successfully created with confirmation message")
	public void the_new_client_should_be_successfully_created_with_confirmation_message() throws InterruptedException 
	{
		Thread.sleep(1000);
        Assert.assertTrue(attributes.ConfirmationMassageDisplayed());     
	}

	@Then("The admin should be redirected to client details page")
	public void the_admin_should_be_redirected_to_client_details_page() throws InterruptedException 
	{
		System.out.println("URL");
		 Thread.sleep(2000);
	     Assert.assertEquals(attributes.getcurrectURL(), "https://parklens-admin.tech-active.com/clients");
	}
	
//  -----------------------	Client update ----------------------------
	
	@Then("Clicks the edit icon")
	public void clicks_the_edit_icon() 
	{
	   adminUser=new TestAddAdminUsers(driver);
	   adminUser.clicksOnEditIcon();
	}

	@Then("Verify i should navigate to the edit client page")
	public void verify_i_should_navigate_to_the_edit_client_page() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Client");
	}

	@When("Change all the required client informations:")
	public void change_all_the_required_client_informations() throws InterruptedException 
	{
		Thread.sleep(2000);
		clients=new TestClients(driver);
	    clients.setClientName("Client A");
	    adminUser.setMobileNumber("8795412300");
	    adminUser.setEmail("clientg@gmail.com");
	    clients.setAddressOne("bogadi 1st stage");
	    clients.setAddressTwo("bogadi 2st stage");
	    clients.setAddressThree("bogadi 3st stage");
	    Thread.sleep(1000);
	    clients.selectCountryDropdown("INDIA");
	    Thread.sleep(1000);
	    clients.selectStateDropdown("KARNATAKA");
	    Thread.sleep(1000);
	    clients.selectCityDropdown("MYSURU");
	    Thread.sleep(1000);
	    clients.selectClientType("Live");
	    Thread.sleep(1000);
	    clients.clickOnStartDatePicker();
	    clients.DatePicker("2023/Oct/5");
	    Thread.sleep(1000);
	    clients.clickOnEndDatePicker();
	    clients.DatePicker("2024/Oct/5");
	    System.out.println("anil kumar");
	}

	@Then("The client should successfully updated with confirmation message")
	public void the_client_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
	    Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());
	}
	
/*  ------------------------------	Client update -----------------------------------------------------*/
	
	@When("Click on kebab menu icon")
	public void click_on_kebab_menu_icon() throws InterruptedException 
	{
		homePage=new TestHomePage(driver);
	    homePage.clickOnKebabMenuIcon();
	}

	@When("Click on lots in the kebab menu popup")
	public void click_on_lots_in_the_kebab_menu_popup() throws InterruptedException 
	{
	    homePage.selectKebabMenuOption("lots");
	}

	@Then("Verify that the lots details page should be displayed")
	public void verify_that_the_lots_details_page_should_be_displayed() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
		System.out.println("lot option :"+attributes.getHomePageHeaderLable());
	    Assert.assertEquals(attributes.getHomePageHeaderLable(),"Lots");
	}

	@When("Click on cameras in the kebab menu popup")
	public void click_on_cameras_in_the_kebab_menu_popup() throws InterruptedException 
	{
		homePage.selectKebabMenuOption("cameras");
	}

	@Then("Verify that the cameras details page should be displayed")
	public void verify_that_the_cameras_details_page_should_be_displayed() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(attributes.getHomePageHeaderLable(),"Cameras");
	}

	@When("Click on users in the kebab menu popup")
	public void click_on_users_in_the_kebab_menu_popup() throws InterruptedException 
	{
		homePage.selectKebabMenuOption("users");
	}

	@Then("Verify that the users details page should be displayed")
	public void verify_that_the_users_details_page_should_be_displayed() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(attributes.getHomePageHeaderLable(),"Users");
	}

	@When("Click on violations in the kebab menu popup")
	public void click_on_violations_in_the_kebab_menu_popup() throws InterruptedException 
	{
		homePage.selectKebabMenuOption("Violations");
	}

	@Then("Verify that the violation dashboard page should be displayed")
	public void verify_that_the_violation_dashboard_page_should_be_displayed() throws InterruptedException 
	{
		Thread.sleep(5000);
		
		Set<String> windowsCount = driver.getWindowHandles();
		
		List<String> wid=new ArrayList(windowsCount);
		String parentWindow=wid.get(0);
		Thread.sleep(5000);
		String childparent=wid.get(1);
		System.out.println(parentWindow);
		System.out.println(childparent);
		driver.switchTo().window(parentWindow);
		System.out.println("parentWindow : "+driver.getTitle());
		
		driver.switchTo().window(childparent);
		System.out.println("ChildWindow : "+driver.getTitle());

        attributes=new TestAttributes(driver);
		Assert.assertEquals(attributes.getHomePageHeaderLable(),"Dashboard");
		
		}
		
	
	
	
}
