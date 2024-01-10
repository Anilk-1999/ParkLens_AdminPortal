package stepDefinitions;


import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributes;
import pageObjects.TestSites;
import pageObjects.TestClientUsers;
import testBase.Baseclass;



public class ClientUsersSteps extends Baseclass
{
  
	@When("Clicks the users side menu")
	public void clicks_the_users_side_menu() throws InterruptedException 
	{
	    String sidemenuName="Users";
		
	    adminUser=new TestAddAdminUsers(driver);
	    adminUser.clicksSideMenu(sidemenuName);
            Thread.sleep(2000);
	}

	@Then("Make sure that the client users information page should appears")
	public void make_sure_that_the_client_users_information_page_should_appears() throws InterruptedException 
	{
	    attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getHomePageHeaderLable(), "Users");
	}

	@Then("Verify i should navigate to the add client user page")
	public void verify_i_should_navigate_to_the_add_client_user_page() throws InterruptedException 
	{
	    Assert.assertEquals(attributes.getAddPageHeaderLable(), "New Client User");
	   
	}

	@When("Fill all the required client user informations:")
	public void fill_all_the_required_client_user_informations() throws InterruptedException 
	{
		
		try 
		{
		        sites = new TestSites(driver);
			Thread.sleep(5000);
			sites.selectParticularClientOnDropdown("parklens");
			Thread.sleep(2000);
			adminUser.setMobileNumber("8754213690");
//			adminUser.setEmail("clientuser4@gmail.com");
			adminUser.setEmail(randomEmail());
			adminUser.setPassword("User123@#");

		        users = new TestClientUsers(driver);
			Thread.sleep(2000);
			users.setRetypePassword("User123@#");
			users.setName("Anil-user1");
			users.setFullName("Anil-user1");
			users.setClientRoleRandomlyOnDropdown();
			users.setLotsRandomlyOnDropdown();

		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	@Then("The new client user should be successfully created with confirmation message")
	public void the_new_client_user_should_be_successfully_created_with_confirmation_message() throws InterruptedException 
	{
	    Assert.assertTrue(attributes.ConfirmationMassageDisplayed());  
	}

	@Then("The admin should be redirected to client user details page")
	public void the_admin_should_be_redirected_to_client_user_details_page() throws InterruptedException 
	{
	    Assert.assertEquals(attributes.getcurrectURL(), "https://parklens-admin.tech-active.com/users");
	}
	
	
/*----------------------------------Client user update-------------------------------------------------------------*/	
	
	
	@Then("Verify i should navigate to the edit client user page")
	public void verify_i_should_navigate_to_the_edit_client_user_page() throws InterruptedException 
	{
	    attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Client User");

	}

	@When("Change all the required client user informations:")
	public void change_all_the_required_client_user_informations() throws InterruptedException 
	{
		users = new TestClientUsers(driver);
		Thread.sleep(2000);
		users.setName("Anil-user1");
		users.setFullName("Anil-user1");
		users.setClientRoleRandomlyOnDropdown();

	}

	@Then("The client user should successfully updated with confirmation message")
	public void the_client_user_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
	    Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());

	}
	
/*----------------------------------Client user deletion-------------------------------------------------------------*/	
	
	@Then("The client user should successfully deleted with confirmation message")
	public void The_client_user_should_successfully_deleted_with_confirmation_message() throws InterruptedException
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}
	
	
}
