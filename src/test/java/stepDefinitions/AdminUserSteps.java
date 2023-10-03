package stepDefinitions;


import java.awt.AWTException;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributeValues;
import pageObjects.TestAttributes;
import pageObjects.TestLogin;
import pageObjects.TestHomePage;
import testBase.Baseclass;


public class AdminUserSteps extends Baseclass
{
/*----------**** Login into ParkLens Admin portal	***--------------*/
	
	
	@Given("The admin launches the Chrome browser")
	public void the_admin_launch_the_chrome_browser()
	{
		launchChromeBrowser();
		log=new TestLogin(driver);
	    adminUser=new TestAddAdminUsers(driver);
	    homePage=new TestHomePage(driver);
	}
  
	@Then("Close the chrome browser")
	public void Close_the_chrome_browser()
	{
//		driver.close();
		closeapp();
	}
	@When("The admin enters the URL as {string}")
	public void the_admin_enter_the_url(String URL) 
	{
	    driver.get(URL);
	}

	@And("The admin enters valid email as {string} and password as {string}")
	public void the_admin_enters_valid_credentials(String Email,String Password) 
	{
	    log.setEmail(Email);
	    log.setPassword(Password);
	}

	@When("Clicks the login button")
	public void clicks_the_login_button() throws InterruptedException 
	{
	   log.clicksigninButton();
	}

	@Then("The admin should be redirected to the dashboard page")
	public void the_admin_should_be_redirected_to_the_dashboard_page() throws InterruptedException 
	{		
		attributes=new TestAttributes(driver);
		System.out.println("The admin dashboard header is :"+attributes.getHomePageHeaderLable());
		Assert.assertEquals(attributes.getHomePageHeaderLable(), "Dashboard");
	}
	@When("Clicks the profile icon")
	public void clicks_the_profile_icon() throws InterruptedException 
	{
	    log.clicksProfileIcon();
	}

	@Then("Verify that the profile logo should be present")
	public void verify_that_the_profile_logo_should_be_present() throws InterruptedException 
	{
	    Assert.assertEquals(log.verifyProfileLogo(), true);
	}
	
	@When("Clicks the logout link")
	public void clicks_the_logout_link() throws InterruptedException 
	{
		System.out.println("save");
		Thread.sleep(2000);
	    log.clicksLogout();
	}

	@Then("Make sure the page should be redirected into the signin page")
	public void make_sure_the_page_should_redirected_into_the_signin_page() 
	{
		if(log.getForgotlinktextcolour().equals("#7e7e7e"))
		{
			System.out.println(log.getForgotlinktextcolour());
		}
		else
		{
			System.out.println("The forgot text colour is mismatch!!!");
		}
	}

	@When("The admin enters invalid email as {string} and password as {string}")
	public void the_admin_enters_invalid_credentials(String InvEmail,String InvPassword) 
	{
	    log.setEmail(InvEmail);
	    log.setPassword(InvPassword);
	}

	@Then("An error message should be displayed")
	public void an_error_message_should_be_displayed() throws InterruptedException 
	{
		if(log.getWelcomeText().equals("Welcome !"))
		{
			Assert.assertEquals(driver.getCurrentUrl(), "https://parklens-admin.tech-active.com/auth");
		}
		else
		{
			Assert.assertEquals(driver.getTitle(), "Parklense Admin-Portal");
		}
		
	}

	@When("The admin leaves the email field empty")
	public void the_admin_leaves_the_email_field_empty() 
	{
	   log.setEmail("");
	}

	@When("Enters a valid password as {string}")
	public void enters_a_valid_password(String Password) 
	{
	    log.setPassword(Password);
	}

	@When("Enter a valid email as {string}")
	public void enter_a_valid_email(String Email) 
	{
	    log.setEmail(Email);
	}

	@When("The admin leaves the password field empty")
	public void the_admin_leaves_the_password_field_empty()
	{
	    log.setPassword("");
	}
	
/*----------**** Creating a new admin user	***--------------*/

	@When("Clicks the setting side menu")
	public void clicks_the_settings_menu() throws InterruptedException 
	{
	     adminUser.clicksSettingMenu();	
	     Thread.sleep(2000);
	}

	@When("Clicks the admin users header tab")
	public void clicks_the_admin_user_tab() throws InterruptedException 
	{
		attributeValue=new TestAttributeValues(driver);
	    attributeValue.clickOnHeaderTab("Admin Users");
		Thread.sleep(2000);
	}

	@When("Clicks the new button")
	public void clicks_the_new_button() throws InterruptedException 
	{
	  adminUser.clicksNewButton();
	}

	@Then("Verify i navigate to the add admin user page")
	public void verify_i_navigate_to_the_add_admin_user_page() throws InterruptedException
	{
		System.out.println("1----add admin anil------");
		attributes=new TestAttributes(driver);
		Assert.assertEquals(attributes.getAddPageHeaderLable(),"Add Admin Users");
		System.out.println("2----add admin anil------"+attributes.getAddPageHeaderLable());
		
    }
	
//	@When("Enter the name as {string} and mobile number as {string}  and email as {string} password as {string} and retypepassword as {string}")
//	public void fill_all_the_required_user_information(String Name,String Mobile,String Email,String Password,String RetypePassword,DataTable dataTable ) throws InterruptedException {
	
//	@When("Fill all the required user information:")
//	public void fill_all_the_required_user_information(DataTable dataTable) throws InterruptedException {
//	    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//	    
//
//	    String name = data.get(0).get("Name");
//	    String mobile = data.get(0).get("Mobile");
//	    String email = data.get(0).get("Email");
//	    String password = data.get(0).get("Password");
//	    String retypePassword = data.get(0).get("RetypePassword");
//	    
//	      adminUser.setName(name);
//		  adminUser.setMobileNumber(mobile);
//		  adminUser.setEmail(email);
//		  adminUser.setPassword(password);
//		  adminUser.setRetypePassword(retypePassword);
//		  adminUser.setAdminRole("ADMIN");
//		  adminUser.setInactiveStatus();
//		  adminUser.setActiveStatus();
//	}
	
//	private String adminName;
//	@When("Fill all the required user information:")
//	public void fill_all_the_required_user_information() throws InterruptedException, IOException 
//	{
//	    
//		String path="./excel-datas/Datadriver.xlsx";
//	    utilitydata=new Xlxutility(path);
//		int totalRow=utilitydata.getRowCount("Sheet1");
//		
//		for(int r=1;r<=totalRow;r++)
//		{
//			 String exp="https://parklens-admin.tech-active.com/settings/admin-user";
//		     String act=driver.getCurrentUrl();
//		   
//		     if(exp.equals(act))
//		     {
//		    	 adminUser.clicksNewButton();
//		     }
//		
//		    	    adminName=utilitydata.getCellData("Sheet1", r, 0);
//					String emailId=utilitydata.getCellData("Sheet1", r, 1);
//					String mobileNum=utilitydata.getCellData("Sheet1", r, 2);
//					String password=utilitydata.getCellData("Sheet1", r, 3);
//					String retypePassword=utilitydata.getCellData("Sheet1", r, 4);
//					String role=utilitydata.getCellData("Sheet1", r, 5);
//					
//					  adminUser.setName(adminName);
//					  adminUser.setMobileNumber(mobileNum);
//					  adminUser.setEmail(emailId);
//					  adminUser.setPassword(password);
//					  adminUser.setRetypePassword(retypePassword);
//					  adminUser.setAdminRole(role);
//					  adminUser.setInactiveStatus();
//					  adminUser.setActiveStatus();
//					  adminUser.clicksSaveButton();
//					  Thread.sleep(1000);
//					  adminUser.clicksOkButtonInConfirmPopup();
//					  Thread.sleep(1000);
//					  adminUser.clicksCancelButton(); 
//					  
//		}
//     }
	@When("Fill all the required user information:")
	public void fill_all_the_required_user_information() throws InterruptedException, IOException 
	{
		System.out.println("-----anil-------");
		  adminUser.setName(randomName());
		  adminUser.setMobileNumber(randomMobileNumber());
		  adminUser.setEmail(randomEmail());
		  adminUser.setPassword("Adminuser123@#");
		  adminUser.setRetypePassword("Adminuser123@#");
		  adminUser.setAdminRole("ADMIN");
		  adminUser.setInactiveStatus();
		  adminUser.setActiveStatus();
		  System.out.println("3----add admin anil------");
		 
	}
	
	
	@When("Clicks the save button")
	public void clicks_the_save_button() throws InterruptedException 
	{
		try
		{
		  System.out.println("anil this is save ");
		  
		  WebElement savebutton=driver.findElement(By.xpath("//button[.='Save']"));
		  adminUser.scrollIntoView(driver, savebutton);
		  Thread.sleep(1000);
		  System.out.println("anil scrollIntoView");
	      adminUser.clicksSaveButton();
	      System.out.println("click on save btn");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@When("Clicks the ok button in the confirmation popup")
	public void clicks_the_ok_button_in_the_confirmation_popup() 
	{
		
	       adminUser.clicksOkButtonInConfirmPopup();
	}

	@Then("The new admin user should be successfully created")
	public void the_new_admin_user_should_be_successfully_created() throws InterruptedException 
	{
	  // Assert.assertEquals(searchAdminUser.getnewAddedUserName(driver),adminName);
	}

	@Then("The admin should be redirected to admin user details page")
	public void the_admin_should_be_redirected_to_admin_user_details_page() throws InterruptedException 
	{
		Assert.assertEquals(attributes.getcurrectURL(), "https://parklens-admin.tech-active.com/settings/admin-user");
	                               
	}
	
 /*----------------------Searching a admin user using name---------------------------------*/

    private String name;
	@When("Enter the name into search textfield")
	public void enter_the_admin_user_name_into_search_textfield() throws InterruptedException 
	{
		name=homePage.getnewAddedUserName(driver);
		Thread.sleep(2000);
		homePage.EnterdataIntoSearchField(name);
	}
	   
	@When("Click on enter")
	public void click_on_enter() throws AWTException 
	{
		homePage.clickOnEnter();
	}

	@Then("Make sure that the searched name should displayed in the table")
	public void make_sure_that_the_searched_admin_user_details_should_displayed_in_the_admin_users_table() 
	{
	  boolean NameStatus=homePage.searchAdminUserByName(name);
	  Assert.assertEquals(true, NameStatus);
	}
	
/*----------------------Searching a admin user using id-------------------------------*/	
	private String id;
	
	@When("Enter the id into search textfield")
	public void enter_the_admin_user_id_into_search_textfield() throws InterruptedException 
	{   
		Thread.sleep(2000);
	    id=homePage.getnewAddedUserId(driver);
	    Thread.sleep(2000);
	    homePage.EnterdataIntoSearchField(id);
	}

	@Then("Make sure that the searched id should displayed in the table")
	public void make_sure_that_the_searched_admin_user_id_should_displayed_in_the_admin_users_table() throws InterruptedException 
	{
	    boolean idStatus = homePage.searchAdminUserByID(id);
	    Thread.sleep(2000);
	    Assert.assertEquals(true, idStatus);
	    
	}

	
/*-------------------------------Admin user update------------------------------------------------------*/	
	
	
	@Then("Make sure that the admin users information page should appears")
	public void make_sure_that_the_admin_users_information_page_should_appears() throws InterruptedException 
	{  
	   Thread.sleep(1000);
	   attributes=new TestAttributes(driver);
	   Assert.assertEquals(attributes.getHomePageHeaderLable(), "Admin Users");
	}

	@Then("Verify i should navigate to the edit admin users page")
	public void verify_i_should_navigate_to_the_edit_admin_userss_page() throws InterruptedException 
	{
	    Assert.assertEquals(attributes.getEditPageHeaderLable(), "Edit Admin Users");
	}

	@When("Change all the required admin user informations:")
	public void change_all_the_required_admin_user_informations() throws InterruptedException 
	{
	    adminUser=new TestAddAdminUsers(driver);
	    adminUser.setName("Admin user9");
	    adminUser.setMobileNumber("3265987410");

	}

	@Then("The admin users should successfully updated with confirmation message")
	public void the_admin_users_should_successfully_updated_with_confirmation_message() throws InterruptedException 
	{
		Assert.assertTrue(attributes.ConfirmationMassageDisplayed());
	    System.out.println("anil : "+attributes.ConfirmationMassageDisplayed());
	}
	
	
/*-------------------------------Admin user deletion------------------------------------------------------*/		

	String getfirstid;
	
	@When("Get the first id in the table")
	public void get_the_first_id_in_the_table() 
	{
	    getfirstid=driver.findElement(By.xpath("((//tbody/tr)[1]/td)[1]")).getText();
		System.out.println("id : "+getfirstid);
	}

	@Then("The admin user should successfully deleted with confirmation message")
	public void the_admin_user_should_successfully_deleted_with_confirmation_message() throws InterruptedException 
	{
		attributes=new TestAttributes(driver);
	    Assert.assertEquals(attributes.ConfirmationMassageDisplayed(), true);
	}

	@Then("Verify that the deleted records should not be visible in the table")
	public void verify_that_the_deleted_records_should_not_be_visible_in_the_table() throws InterruptedException, AWTException 
	{
	    adminUser=new TestAddAdminUsers(driver);
	    adminUser.searchDeletedRecord(getfirstid);
	}
	
	
/*-------------------------------filter the active status------------------------------------------------------*/	

	@When("Click on status filter dropdown")
	public void click_on_status_filter_dropdown() throws InterruptedException 
	{
//		homePage=new TestHomePage(driver);
		homePage.clickOnStatusFilter();
	}

	@When("Select a active status")
	public void select_a_active_status() throws InterruptedException 
	{
		homePage.setStatusFilter("active"); 
	}

	@Then("Ensure that only the active records should displayed on the table")
	public void ensure_that_only_the_list_of_active_records_should_displayed_on_the_table() throws InterruptedException 
	{
	    homePage.verifyStatusOnTable("active");
	}

	@When("Click on reset button")
	public void click_on_reset_button() throws InterruptedException 
	{
		homePage.clickOnResetButton();
	}

	@Then("Verify that all the records should displayed on the table")
	public void verify_that_the_list_of_active_and_inactive_records_should_displayed_on_the_table() throws InterruptedException 
	{
	    homePage.VerifyAllRecordsPresentInTable();
	}
	
/*-------------------------------filter the Inactive status------------------------------------------------------*/		
	
	@When("Select a inactive status")
	public void select_a_inactive_status() throws InterruptedException 
	{
		homePage.setStatusFilter("inactive"); 
	}

	@Then("Ensure that only the inactive records should displayed on the table")
	public void ensure_that_only_the_inactive_records_should_displayed_on_the_table() throws InterruptedException 
	{
		 homePage.verifyStatusOnTable("inactive");
	}
	
	
/*-------------------------------filter the Inactive status------------------------------------------------------*/		
		
	
	@When("Select a all status")
	public void Select_a_all_status() throws InterruptedException
	{
		homePage.setStatusFilter("all status");
	}
		
	
/*-------------------------------Perpage functionalities------------------------------------------------------*/		
	
	@When("Select a forty record")
	public void select_a_forty_record() throws InterruptedException 
	{
	    homePage.selectPerpage("40");
	}

	@Then("Verify that the forty records should displayed on the table")
	public void verify_that_the_forty_records_should_displayed_on_the_table() 
	{
	   homePage.totalRecords();
	}
	
	@When("Select a thirty records")
	public void select_a_thirty_records() throws InterruptedException 
	{
		homePage.selectPerpage("30");
	}

	@Then("Verify that the thirty records should displayed on the table")
	public void verify_that_the_thirty_records_should_displayed_on_the_table() 
	{
		homePage.totalRecords();
	}
	
	@When("Select a twenty records")
	public void select_a_twenty_records() throws InterruptedException 
	{
		homePage.selectPerpage("20");
	}

	@Then("Verify that the twenty records should displayed on the table")
	public void verify_that_the_twenty_records_should_displayed_on_the_table() 
	{
		homePage.totalRecords();
	}
	
	
	/*-------------------------------Sorting functionalities------------------------------------------------------*/
	String headerName="Id";
	
	@When("Click on descending icon")
	public void click_on_descending_icon() throws InterruptedException 
	{
	    homePage.setSortingByDescendingOrder(headerName);
	}

	@Then("Verify that all the records should displayed on descending order")
	public void verify_that_all_the_records_should_displayed_on_descending_order() throws InterruptedException 
	{
	    homePage.VerifyRecordsAreDescendingOrder(headerName);
	}

	@When("Click on ascending icon")
	public void click_on_ascending_icon() throws InterruptedException 
	{
	    homePage.setSortingByAscendingOrder(headerName);
	}

	@Then("Verify that all the records should displayed on ascending order")
	public void verify_that_all_the_records_should_displayed_on_ascending_order() throws InterruptedException 
	{
	    homePage.VerifyRecordsAreAscendingOrder(headerName);
	}
	
}