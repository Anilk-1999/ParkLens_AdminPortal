package stepDefinitions;

import java.awt.AWTException;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.TestAttributes;
import pageObjects.TestStalls;
import testBase.Baseclass;

public class StallsSteps extends Baseclass
{
	
	
	@When("Click on the stalls icon")
	public void click_on_the_stalls_icon() 
	{
	   stalls=new TestStalls(driver);
	   stalls.clickOnStallIcon();   
	}

	@Then("Verify that the stalls map page should be dispalyed")
	public void verify_that_the_stalls_map_page_should_be_dispalyed() throws InterruptedException 
	{
	    attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getHomePageHeaderLable(),"Stalls");
	}

	@When("Click On list icon")
	public void click_on_list_icon() 
	{
	    stalls.clickOnStallsListIcon();
	}

	@Then("Verify that the page should redirected to stalls details page")
	public void verify_that_the_page_should_redirected_to_stalls_details_page() throws InterruptedException 
	{
		Assert.assertEquals(attributes.getHomePageHeaderLable(),"Stalls");
	}

	@Then("Make sure that the edit stalls page should be displayed")
	public void make_sure_that_the_edit_stalls_page_should_be_displayed() throws InterruptedException 
	{
		Assert.assertEquals(attributes.getHomePageHeaderLable(),"Edit Stall");
	}

	@When("Select the camera")
	public void select_the_camera() 
	{
	    stalls.selectCameraRandomlyInDropDown();
	}

	@When("select the status")
	public void select_the_status() throws InterruptedException 
	{
	    stalls.clickOnStatusCheckBox("QA");
	}

	@When("Set Attribute and attribute value")
	public void Set_Attribute_and_attribute_value() throws AWTException, InterruptedException
	{
		stalls.setAttributesRandomlyInDropDown("Attributes");
		Thread.sleep(1000);
		stalls.clickOnReportButton();	
		Thread.sleep(1000);
		stalls.setAttributesValuesRandomlyInDropDown("Attributes values");
		
	}
	
	@When("Click on the update button")
	public void Click_on_the_update_button() throws InterruptedException, AWTException
	{
		stalls.clicksOnUpdateButton();
	}
	
	@Then("Verify that the stalls should be updated with the confirmation message")
	public void verify_that_the_stalls_should_be_updated_with_the_confirmation_message() throws InterruptedException 
	{
		Assert.assertEquals(attributes.ConfirmationMassageDisplayed(),true);
	}
	

}
