package stepDefinitions;

import java.awt.AWTException;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributes;
import pageObjects.TestLots;
import pageObjects.TestSites;
import testBase.Baseclass;

public class LotsSteps extends Baseclass
{

	@When("Clicks the lots side menu")
	public void clicks_the_lots_side_menu() throws InterruptedException 
	{
	   adminUser=new TestAddAdminUsers(driver);
	   adminUser.clicksSideMenu("Lots");
	   Thread.sleep(2000);
	}

	@Then("Make sure that the lots information page should appears")
	public void make_sure_that_the_lots_information_page_should_appears() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getHomePageHeaderLable(), "Lots");
	    System.out.println(attributes.getHomePageHeaderLable());
	}

	@Then("Verify i should navigate to the add lot page")
	public void verify_i_should_navigate_to_the_add_lot_page() throws InterruptedException 
	{
	   Assert.assertEquals(attributes.getAddPageHeaderLable(), "New Lot");
	}

	@When("Fill all the required lot informations:")
	public void fill_all_the_required_lot_informations() throws InterruptedException 
	{
	   sites=new TestSites(driver);
	   Thread.sleep(2000);
	   sites.selectParticularClientOnDropdown("parklens");
	   
	   lots=new TestLots(driver);
	 //lots.selectParticularSiteOnDropdown("");
	   Thread.sleep(2000);
	   lots.selectSiteOnDropdownRandomly();
	   
	   lots.setLotName("Lot A");
	   lots.setLotTitle("Lot title");
	   lots.setParkingDuration("50");
	   lots.setLocation("Outdoor");
	   
	}

	@Then("The new lot should be successfully created with confirmation message")
	public void the_new_lot_should_be_successfully_created_with_confirmation_message() throws InterruptedException 
	{
	   Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	}

	@Then("The admin should be redirected to lot details page")
	public void the_admin_should_be_redirected_to_lot_details_page() throws InterruptedException 
	{
	    Assert.assertEquals(attributes.getcurrectURL(), "https://parklens-admin.tech-active.com/lots");
	}
	
	
/*-------------------------------Lots update-------------------------------------------------------------*/	
	
	
	@Then("Verify i should navigate to the edit lot page")
	public void verify_i_should_navigate_to_the_edit_lot_page() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Lot");
	}

	@When("Change all the required lot informations:")
	public void change_all_the_required_lot_informations() throws AWTException, InterruptedException 
	{
		lots=new TestLots(driver);	
		lots.setEntranceCoordinates("32.600648", "-85.490336");
		lots.setLotOverlayCoordinates("32.60057146638318,-85.49040206994057", "32.60094514429818,-85.48985804662705");
		lots.uploadLotOverlayImage("/home/active30/Desktop/Parklens files/96au-plainsman-park.png");
		Thread.sleep(2000);
        lots.uploadKmlMap("/home/active30/Desktop/Parklens files/Plainsman park.kml");
	}

	@Then("The lot should successfully updated with confirmation message")
	public void the_lot_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());

	}
	
/*------------------------------------Violation fines-----------------------------------*/	
	
	@When("Clicks the violation link")
	public void clicks_the_violation_link() throws InterruptedException 
	{
		System.out.println("violation link1");
	    lots.clicksOnViolationLink();
	    System.out.println("violation link2");
	}

	@When("Clicks on edit icon")
	public void clicks_on_edit_icon() throws InterruptedException 
	{
	   lots.clicksOnEditIcon();
	}

	@When("Enter the Exempted Duration")
	public void enter_the_exempted_duration() throws InterruptedException 
	{
	    lots.setExemptedDuration("50");
	}

	@When("Enter the flat fee")
	public void enter_the_flat_fee() throws InterruptedException 
	{
	    lots.setFlatFees("5000");
	}

	@Then("The fees should successfully updated with confirmation message")
	public void the_fees_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());
	}

	@When("Clicks the general link")
	public void clicks_the_general_link() throws InterruptedException 
	{
	    lots.clicksOnGeneralLink();
	}
	
	@When("Clicks the edit overlay link")
	public void clicks_the_edit_overlay_link() throws InterruptedException 
	{
	    lots.clicksEditOverlayLink();
	}

	@When("Clicks the update button")
	public void clicks_the_update_button() throws InterruptedException 
	{
	    lots.clicksOnUpdateButton();
	}

	
/*------------------------------------Lot deletion-----------------------------------*/	
	
	@Then("The lot should successfully deleted with confirmation message")
	public void The_lot_should_successfully_deleted_with_confirmation_message() throws InterruptedException
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}
	
	
	
	
}
