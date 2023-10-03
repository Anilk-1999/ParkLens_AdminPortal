package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pageObjects.TestAttributeValues;
import pageObjects.TestAttributes;
import testBase.Baseclass;

public class AttributeValueSteps extends Baseclass
{
   String tab="Attribute Values";
	
	@When("Clicks the attribute values header tab")
	public void clicks_the_attribute_values_headertab() throws InterruptedException 
	{	
	     attributeValue=new TestAttributeValues(driver);
	     attributeValue.clickOnHeaderTab(tab);
	     Thread.sleep(2000);
	}											

	@Then("Make sure that the attribute values information page should appears")
	public void make_sure_that_the_attribute_values_information_page_should_appears() throws InterruptedException 
	{
	   attributes=new TestAttributes(driver);
	   assertTrue(true,attributes.getHomePageHeaderLable());
	}

	@Then("Verify i should navigate to the add\\/new attribute value page")
	public void verify_i_should_navigate_to_the_add_new_attribute_value_page() throws InterruptedException 
	{
	   Assert.assertEquals(attributes.getAddPageHeaderLable(), "New Attribute Value"); 
	}
//
//	@When("Fill all the required attribute value informations:")
//	public void fill_all_the_required_attribute_value_information() throws IOException, InterruptedException 
//	{
//	    
//	    String path="./excel-datas/Attribute values.xlsx";
//	    utilitydata=new Xlxutility(path);
//	    int totalRows=utilitydata.getRowCount("Sheet1");
//	    
//	    for(int r=1;r<=totalRows;r++)
//	    {
//	    	adminUser=new TestAddAdminUsers(driver);
//	    	
//	    	if(attributes.getcurrectURL().equals("https://parklens-admin.tech-active.com/settings/attribute-values"))
//	    	{                              
//	    		adminUser.clicksNewButton();	
//	    	}
//	    	String attributeValueName=utilitydata.getCellData("Sheet1", r, 0);	
//	    	String atributeValueDesc=utilitydata.getCellData("Sheet1", r, 1);
//	
//	    	attributeValue.setAttributeDropdownRandomly();
//	    	attributeValue.setAttributeValueName(attributeValueName);
//	    	attributes.setDescription(atributeValueDesc);
//	      //attributeValue.clickOnClientDropdown();
//	    	attributeValue.setClientDropdownRandomly();
//	    	
//	        adminUser.clicksSaveButton();
//	        Thread.sleep(1000);
//	        adminUser.clicksOkButtonInConfirmPopup();
//	        Thread.sleep(1000);
//	    	
//	    }  
//	    
//	}
	
	@When("Fill all the required attribute value informations:")
	public void fill_all_the_required_attribute_value_information() throws IOException, InterruptedException 
	{
		attributeValue.setAttributeDropdownRandomly();
    	attributeValue.setAttributeValueName("EV");
    	attributes.setDescription("this is Ev ");
      //attributeValue.clickOnClientDropdown();
    	attributeValue.setClientDropdownRandomly();
    	
	}

	@Then("The new attribute value should be successfully created with confirmation message")
	public void the_new_attribute_value_should_be_successfully_created_with_confirmation_message() throws InterruptedException 
	{
	    Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}

	@Then("The admin should be redirected to attribute values details page")
	public void the_admin_should_be_redirected_to_attribute_values_details_page() throws InterruptedException 
	{
		Thread.sleep(1000);
		assertEquals(attributes.getHomePageHeaderLable(),"Attribute Values");
	}
	
	
/*---------------------------------Attribute values update---------------------------------*/	
	
	
	@Then("Verify i should navigate to the edit attribute values page")
	public void verify_i_should_navigate_to_the_edit_attribute_values_page() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Attribute Value");
	}

	@When("Change all the required attribute value informations:")
	public void change_all_the_required_attribute_value_informations() throws InterruptedException 
	{
	    	attributeValue=new TestAttributeValues(driver);
	    	attributeValue.setAttributeValueName("ADA");
	}

	@Then("The attribute value should successfully updated with confirmation message")
	public void the_attribute_value_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());

	}
	
	
	/*---------------------------------Attribute values deletion---------------------------------*/		
	
	@Then("The attribute value should successfully deleted with confirmation message")
	public void The_attribute_value_should_successfully_deleted_with_confirmation_message() throws InterruptedException
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}
	
}
