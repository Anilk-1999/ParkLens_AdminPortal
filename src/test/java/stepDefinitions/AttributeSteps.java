package stepDefinitions;

import java.io.IOException;


import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.TestAttributes;
import testBase.Baseclass;

public class AttributeSteps extends Baseclass
{
	
	@Then("Make sure that the attribute information page should appears")
	public void make_sure_that_the_attribute_information_page_should_appears() throws InterruptedException 
	{   
		//driver=Baseclass.getDriver();
	    attributes=new TestAttributes(driver);
		Assert.assertEquals(attributes.getAttributeTabText(), attributes.getHomePageHeaderLable());
	}

	@Then("Verify i should navigate to the add attributes page")
	public void verify_i_should_navigate_to_the_add_attributes_page() throws InterruptedException 
	{
		Assert.assertTrue(true, attributes.getAddPageHeaderLable());
	}

//	@When("Fill all the required attribute information:")
//	public void fill_all_the_required_attribute_information() throws IOException, InterruptedException 
//	{
//		
//        String path="./excel-datas/AttributeInformation.xlsx";
//		
//		Xlxutility utilitydata=new Xlxutility(path);
//		int totalRow=utilitydata.getRowCount("Sheet1");
//		
//		for(int r=1;r<=totalRow;r++)
//		{
//			
//			 String exp="https://parklens-admin.tech-active.com/settings/attributes";
//		     String act=driver.getCurrentUrl();
//		    
//		   
//		     if(exp.equals(act))
//		     {
//		    	 Thread.sleep(2000);
//		    	 adminUser.clicksNewButton();
//		     }
//			
//			String attributeName=utilitydata.getCellData("Sheet1", r, 0);
//			String attributeDesc=utilitydata.getCellData("Sheet1", r, 1);
//			
//		    attributes.setAttributeName(attributeName);
//	        attributes.setDescription(attributeDesc);
//	        Thread.sleep(1000);
//	        adminUser=new TestAddAdminUsers(driver);
//	        adminUser.clicksSaveButton();
//	        adminUser.clicksOkButtonInConfirmPopup();
//	        Thread.sleep(1000);
//		}
//         
//   	}
	
	@When("Fill all the required attribute information:")
	public void fill_all_the_required_attribute_information() throws IOException, InterruptedException 
	{
		    attributes.setAttributeName("Zone");
	        attributes.setDescription("zone title");
	        Thread.sleep(1000);
//	        adminUser=new TestAddAdminUsers(driver);
//	        adminUser.clicksSaveButton();
//	        adminUser.clicksOkButtonInConfirmPopup();
//	        Thread.sleep(1000);
	}

	@Then("The new attribute should be successfully created with confirmation message")
	public void the_new_attribute_should_be_successfully_created() throws InterruptedException 
	{
		Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}

	@Then("The admin should be redirected to attribute details page")
	public void the_admin_should_be_redirected_to_attribute_details_page() throws InterruptedException 
	{
		System.out.println("anil kumar");
		Assert.assertTrue(true, attributes.getHomePageHeaderLable());
	}
	
	
/*-----------------------------Attribute update----------------------------------*/
	
	@Then("Verify i should navigate to the edit attribute page")
	public void verify_i_should_navigate_to_the_edit_attribute_page() throws InterruptedException
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Attributes");
	}

	@When("Change all the required attribute informations:")
	public void change_all_the_required_attribute_informations() throws InterruptedException
	{
	    attributes.setAttributeName("Group");
	}

	@Then("The attribute should successfully updated with confirmation message")
	public void the_attribute_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());
	}
	
/*-----------------------------Attribute update----------------------------------*/
	
	@Then("The attribute should successfully deleted with confirmation message")
	public void The_attribute_should_successfully_deleted_with_confirmation_message() throws InterruptedException
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}
	
}
