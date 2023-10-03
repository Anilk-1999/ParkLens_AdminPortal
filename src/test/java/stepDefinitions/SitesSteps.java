package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributes;
import pageObjects.TestSites;
import testBase.Baseclass;

public class SitesSteps extends Baseclass
{

	
	@When("Clicks the sites side menu")
	public void clicks_the_sites_side_menu() throws InterruptedException 
	{
	    adminUser=new TestAddAdminUsers(driver);
	    adminUser.clicksSideMenu("Sites");
	    Thread.sleep(2000);
	}

	@Then("Make sure that the sites information page should appears")
	public void make_sure_that_the_sites_information_page_should_appears() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	   Assert.assertEquals(attributes.getHomePageHeaderLable(), "Sites");
	}

	@Then("Verify i should navigate to the add site page")
	public void verify_i_should_navigate_to_the_add_site_page() throws InterruptedException 
	{
	    Assert.assertEquals(attributes.getAddPageHeaderLable(),"New Site");
	    System.out.println("anil "+attributes.getAddPageHeaderLable()); 
	}

	@When("Fill all the required site informations:")
	public void fill_all_the_required_site_informations() throws InterruptedException 
	{
		try 
		{
			sites = new TestSites(driver);
			Thread.sleep(3000);
//			sites.selectClientOnDropdownRandomly();
		  sites.selectParticularClientOnDropdown("parklens");
			adminUser.setName("Site A");
			sites.setTitle("site title");
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	
	}

	@Then("The new site should be successfully created with confirmation message")
	public void the_new_site_should_be_successfully_created_with_confirmation_message() throws InterruptedException 
	{
	   Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	   System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());
	}

	@Then("The admin should be redirected to site details page")
	public void the_admin_should_be_redirected_to_site_details_page() throws InterruptedException 
	{
	    Assert.assertEquals(attributes.getcurrectURL(),"https://parklens-admin.tech-active.com/sites");
	}
	
	
/*-------------------------------Sites update-------------------------------------------------------*/	
	
	
	@Then("Verify i should navigate to the edit site page")
	public void verify_i_should_navigate_to_the_edit_site_page() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Site");
	}

	@When("Change all the required site informations:")
	public void change_all_the_required_site_informations() 
	{
		sites = new TestSites(driver);
		sites.setTitle("site title");
	}

	@Then("The site should successfully updated with confirmation message")
	public void the_site_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());

	}
	
	
/*-------------------------------Sites deletion-------------------------------------------------*/	
	
	@Then("The site should successfully deleted with confirmation message")
	public void The_site_should_successfully_deleted_with_confirmation_message() throws InterruptedException
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}
	
}
