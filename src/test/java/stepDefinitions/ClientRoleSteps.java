package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.TestAttributeValues;
import pageObjects.TestAttributes;
import pageObjects.TestClientRoles;
import testBase.Baseclass;

public class ClientRoleSteps extends Baseclass
{
   String tab="Client Roles";
	
	@When("Clicks the client roles header tab")
	public void clicks_the_client_roles_tab() throws InterruptedException 
	{
		attributeValue=new TestAttributeValues(driver);
		attributeValue.clickOnHeaderTab(tab);
		Thread.sleep(2000);
	}

	@Then("Make sure that the client roles information page should appears")
	public void make_sure_that_the_client_roles_information_page_should_appears() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    String expectedResult="Clients Roles";
	    Thread.sleep(1000);
		String actualResult=attributes.getHomePageHeaderLable();
		Assert.assertEquals(expectedResult,actualResult);
	}

	@Then("Verify i should navigate to the add client roles page")
	public void verify_i_should_navigate_to_the_add_client_roles_page() throws InterruptedException 
	{
		String expectedResult="Add Client Roles";
		String actualResult=attributes.getAddPageHeaderLable();
	    Assert.assertEquals(expectedResult, actualResult);
	}

	@When("Enter the permission title")
	public void enter_the_permission_title() 
	{
	   clientRoles=new TestClientRoles(driver);
	   clientRoles.setPermissionTitle(randomName());
	}

	@When("Select the clients")
	public void select_the_clients() throws InterruptedException 
	{
		attributeValue.setClientDropdownRandomly();
	}

	@When("Select all the permissions")
	public void select_all_the_permissions() throws InterruptedException 
	{
		//clientRoles.selectAllPermissionsOnTableHeaderCheckboxes();
		//clientRoles.clickOnPermissionCheckBoxColumnWise("delete");
		clientRoles.clickOnPermissionCheckboxRowWise("violations_myprofile");
	}

	@Then("The new client role should be successfully created with confirmation message")
	public void the_new_client_role_should_be_successfully_created_with_confirmation_message() throws InterruptedException 
	{
	   Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}

	@Then("The admin should be redirected to client role details page")
	public void the_admin_should_be_redirected_to_client_role_details_page() throws InterruptedException
	{
	   Assert.assertEquals(attributes.getcurrectURL(), "https://parklens-admin.tech-active.com/settings/client-roles");           
 	}
	
	
/*-------------------------------Client role update---------------------------------------*/	
	
	
	@Then("Verify i should navigate to the edit client roles page")
	public void verify_i_should_navigate_to_the_edit_client_roles_page() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Client Roles");
	}

	@When("Change all the required client role informations:")
	public void change_all_the_required_client_role_informations() 
	{
		 clientRoles=new TestClientRoles(driver);
		 clientRoles.setPermissionTitle(randomName());
	}

	@Then("The client role should successfully updated with confirmation message")
	public void the_client_role_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());
	}
	

	/*-------------------------------Client role deletion---------------------------------------*/	
	
	@Then("The client role should successfully deleted with confirmation message")
	public void The_client_role_should_successfully_deleted_with_confirmation_message() throws InterruptedException
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}
	
}
