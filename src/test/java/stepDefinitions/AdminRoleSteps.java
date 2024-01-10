package stepDefinitions;


import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributeValues;
import pageObjects.TestAttributes;
import pageObjects.TestClientRoles;
import testBase.Baseclass;

public class AdminRoleSteps extends Baseclass
{
   
	@When("Clicks the admin roles header tab")
	public void clicks_the_admin_roles_tab() throws InterruptedException 
	{
	    String tab="Admin Roles";
		
	    attributeValue=new TestAttributeValues(driver);
	    attributeValue.clickOnHeaderTab(tab);
	    Thread.sleep(2000);
	}

	@Then("Make sure that the admin roles information page should appears")
	public void make_sure_that_the_admin_roles_information_page_should_appears() throws InterruptedException 
	{
	    attributes=new TestAttributes(driver);
	    String expectedResult="Admin Roles";
	    Thread.sleep(1000);
	    String actualResult=attributes.getHomePageHeaderLable();
	    Assert.assertEquals(expectedResult,actualResult);
	}

	@Then("Verify i should navigate to the add admin roles page")
	public void verify_i_should_navigate_to_the_add_admin_roles_page() throws InterruptedException 
	{
	    String expectedResult="Add Admin Roles";
	    String actualResult=attributes.getAddPageHeaderLable();
	    Assert.assertEquals(expectedResult, actualResult);
	}

	@When("Enters the permission title")
	public void enters_the_permission_title() 
	{
	   clientRoles=new TestClientRoles(driver);
	   clientRoles.setPermissionTitle(randomName());
	}

	@When("Select all the permission")
	public void select_all_the_permission() throws InterruptedException 
	{
	  //clientRoles.selectAllPermissionsOnTableHeaderCheckboxes();
	  //clientRoles.clickOnPermissionCheckBoxColumnWise("add");
	    clientRoles.clickOnPermissionCheckboxRowWise("Myprofile");
	}

	@Then("The new admin role should be successfully created with confirmation message")
	public void the_new_admin_role_should_be_successfully_created_with_confirmation_message() throws InterruptedException 
	{
		 Thread.sleep(1000);
		 Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}

	@Then("The admin should be redirected to admin role details page")
	public void the_admin_should_be_redirected_to_admin_role_details_page() throws InterruptedException 
	{
		Assert.assertEquals(attributes.getcurrectURL(), "https://parklens-admin.tech-active.com/settings/admin-roles");
	}
	
	
/*------------------------------Admin role update-------------------------------------------------*/	
	
	@Then("Click on the edit icon")
	public void clicks_the_edit_icon() 
	{
	   clientRoles=new TestClientRoles(driver);
	   clientRoles.clicksOnFifthEditIcon();
	}
	
	@Then("Verify i should navigate to the edit admin roles page")
	public void verify_i_should_navigate_to_the_edit_admin_roles_page() throws InterruptedException 
	{
	    attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Admin Roles"); 
	}

	@When("Change all the required admin role informations:")
	public void change_all_the_required_admin_role_informations() 
	{
	    clientRoles=new TestClientRoles(driver);
	    clientRoles.setPermissionTitle(randomName());
	}

	@Then("The admin role should successfully updated with confirmation message")
	public void the_admin_role_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
	    Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());
	}
	

/*------------------------------Admin role Delete-------------------------------------------------*/	
    String getid;
	
	@When("Get the id in the table")
	public void Get_the_id_in_the_table()
	{
	      WebElement records=driver.findElement(By.xpath("((//tbody/tr)[5]/td)[1]"));
	      getid=records.getText();
	}

	@When("Clicks the delete button")
	public void clicks_the_delete_button() throws InterruptedException 
	{
		
	    adminUser=new TestAddAdminUsers(driver);
	    adminUser.scrollIntoView(driver, driver.findElement(By.xpath("//button[.=' Delete']")));
	    Thread.sleep(1000);
	    adminUser.clicksOnDeleteButton();
	}

	@Then("The admin role should successfully deleted with confirmation message")
	public void the_admin_role_should_successfully_deleted_with_confirmation_message() throws InterruptedException 
	{
	    attributes=new TestAttributes(driver);
	    Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}

	@Then("Verify that the deleted record should not be visible in the table")
	public void verify_that_the_deleted_record_should_not_be_visible_in_the_table() throws InterruptedException, AWTException 
	{
	    adminUser.searchDeletedRecord(getid);
	}
	
	

}
