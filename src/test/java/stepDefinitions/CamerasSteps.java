package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributes;
import pageObjects.TestCameras;
import pageObjects.TestLots;
import pageObjects.TestSites;
import testBase.Baseclass;

public class CamerasSteps extends Baseclass
{

	@When("Clicks the cameras side menu")
	public void clicks_the_cameras_side_menu() throws InterruptedException 
	{
        String sideMenuName="Camera";
		
	    adminUser=new TestAddAdminUsers(driver);
	    adminUser.clicksSideMenu(sideMenuName); 
	   
	}

	@Then("Make sure that the camera information page should appears")
	public void make_sure_that_the_camera_information_page_should_appears() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.getHomePageHeaderLable(), "Cameras");
	}

	@Then("Verify i should navigate to the add camera page")
	public void verify_i_should_navigate_to_the_add_camera_page() throws InterruptedException 
	{
		Assert.assertEquals(attributes.getAddPageHeaderLable(), "New Camera");
	}

	@When("Fill all the required camera informations:")
	public void fill_all_the_required_camera_informations() throws InterruptedException 
	{
		System.out.println("1-------anil-------");
		   sites=new TestSites(driver);
		   Thread.sleep(2000);
		   sites.selectParticularClientOnDropdown("Anil-Client");
		   
		   lots=new TestLots(driver);
		   Thread.sleep(2000);
		   lots.selectParticularSiteOnDropdown("Anil-Site");
//		   lots.selectSiteOnDropdownRandomly();
		   	System.out.println("2-------anil-------");
		   cameras=new TestCameras(driver);
		   Thread.sleep(2000);
		   try {
		   cameras.setLotRandomlyOnDropdown();
		   System.out.println("-------anil kumar-------");
//		   cameras.setParticularLotOnDropdown("lotA");
		   System.out.println("3-------anil-------");
		   cameras.setCameraName("Camera A");
		   Thread.sleep(1000);
		   cameras.setAllStallsOnDropdown();
		   Thread.sleep(1000);
		   cameras.setCameraURL("https://www.cameras.in");
		   Thread.sleep(500);
		   }catch(Exception e) {
			   System.out.println("anil : "+e);
		   }
		   
	}

	@Then("The new camera should be successfully created with confirmation message")
	public void the_new_camera_should_be_successfully_created_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	}

	@Then("The admin should be redirected to camera details page")
	public void the_admin_should_be_redirected_to_camera_details_page() throws InterruptedException 
	{
		Assert.assertEquals(attributes.getcurrectURL(), "https://parklens-admin.tech-active.com/camera");
	}
	
	
/*--------------------------------Camera update-----------------------------------------------------*/	
	
	
	@Then("Verify i should navigate to the edit camera page")
	public void verify_i_should_navigate_to_the_edit_camera_page() throws InterruptedException 
	{
//		attributes=new TestAttributes(driver);
//		System.out.println("anil : "+attributes.getEditPageHeaderLable());
//	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Camera Camera A Stalls");
//	    System.out.println("anil");
	}

	@When("Change all the required camera informations:")
	public void change_all_the_required_camera_informations() 
	{
		System.out.println("anil kumar1");
	   cameras=new TestCameras(driver);
	   cameras.setCameraName("Camera B");
	   System.out.println("anil kumar2");
	}

	@Then("The camera should successfully updated with confirmation message")
	public void the_camera_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());
	}
	
	
	/*--------------------------------Camera update-----------------------------------------------------*/		
	
	@Then("The camera should successfully deleted with confirmation message")
	public void The_camera_should_successfully_deleted_with_confirmation_message() throws InterruptedException
	{
		attributes=new TestAttributes(driver);
		Assert.assertEquals(true, attributes.ConfirmationMassageDisplayed());
	}
	
}
