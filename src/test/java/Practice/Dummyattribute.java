package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import de.erichseifert.vectorgraphics2d.VectorHints.Key;
import pageObjects.TestAddAdminUsers;
import pageObjects.TestAttributeValues;
import pageObjects.TestAttributes;
import pageObjects.TestCameras;
import pageObjects.TestClientRoles;
import pageObjects.TestLots;
import pageObjects.TestSites;
import testBase.Baseclass;
import utilities.WaitHelper;
import utilities.Xlxutility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Dummyattribute
{
	 
	public WebDriver driver;
	@Test
	public void fill_all_the_required_attribute_information() throws IOException, InterruptedException, AWTException 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://parklens-admin.tech-active.com/auth");
        driver.findElement(By.xpath("(//input[@min='undefined'])[1]")).sendKeys("devops@active.agency");
        driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Devops@12345");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[.='Sign In']")).click();
        Thread.sleep(2000);
      //  driver.findElement(By.xpath("//span[text()=' Settings']")).click();
//        driver.findElement(By.xpath("//span[.=' Camera']")).click();
//        Thread.sleep(3000);
	//	driver.findElement(By.xpath("//a[.='Client Roles']")).click();
		//Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[.=' New']")).click();
//        System.out.println("----------------"+driver.getCurrentUrl()+"--------------");
//        adminUser=new TestAddAdminUsers(driver);
//        adminUser.clicksNewButton();
//		attributes=new TestAttributes(driver);
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
//		     System.out.println("-----------"+act+"::::"+exp+"---------------");
//		   
//		     if(exp.equals(act))
//		     {
//		    	 adminUser.clicksNewButton();
//		     }
//			
//			String attributeName=utilitydata.getCellData("Sheet1", r, 0);
//			String attributeDesc=utilitydata.getCellData("Sheet1", r, 1);
//			
//		    attributes.setAttributeName(attributeName);
//	        attributes.setAttributeDescription(attributeDesc);
//	        Thread.sleep(1000);
//	        adminUser.clicksSaveButton();
//	        adminUser.clicksOkButtonInConfirmPopup();
//	        Thread.sleep(1000);
//		}
//      
        
//        String tab="Attribute Values";
//        
//        TestAttributeValues attributevalue=new TestAttributeValues(driver);
//     	Thread.sleep(2000);
//        attributevalue.clickOnHeaderTab(tab);
   	
//        By header_tabs =By.xpath("//div[@class='container-fluid']/ul/li");
//    
//               
//    	     List<WebElement> headertabs = driver.findElements(header_tabs);
//    	     
//    	     int countheaderTabs = headertabs.size();
//    	    
////    	     System.out.println("--------------------"+countheaderTabs+"------------------");
//    	     
//    		for(int t=0;t<countheaderTabs;t++)
//    		{
//    			WebElement tabs = headertabs.get(t);
////    	       WebElement tabs=driver.findElement(header_tabs);
//    	       String gettabText=tabs.getText();
//    	          	       
//               System.out.println("============="+tabs+"==============");
//    	       
//    	       if(gettabText.equals("Attribute Values"))
//    	       {
////    	    	   driver.findElement(header_tabs).click();
//    	    	   tabs.click();
//    	    	   
//    	    	   Thread.sleep(2000);
//    	    	   System.out.println("---------------------------attribute value tab---------------------");
//    	       }
////    		}
//        TestAttributeValues attributevalue=new TestAttributeValues(driver);
//     	Thread.sleep(2000);
//        attributevalue.clickOnHeaderTab("Attribute Values");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[.=' New']")).click();
//        Thread.sleep(2000);
//     	WebElement dropdown=driver.findElement(By.tagName("select"));
//     	dropdown.click();
        
//        driver.findElement(By.xpath("//div[@class='ng-input']")).click();
//        List<WebElement> clientOptions=driver.findElements(By.xpath("(//div[@class='ng-dropdown-panel-items scroll-host']/div)[2]/div"));
//		int countClients=clientOptions.size();
//		
//		System.out.println("1.----------------------"+countClients+"-------------");
//		
//	       for(int c=0;c<countClients;c++)
//	       {
//	    	    WebElement dropdownOptions = clientOptions.get(c);
//	    	    String getclientText=dropdownOptions.getText();
//	    	    System.out.println("2.--------------"+getclientText+"------------");
//	       
//	    	    if(getclientText.equals("parklens"))
//	    	    {
//	    	    	System.out.println("2.--------------"+getclientText+"------------");
//	    	    	dropdownOptions.click();
//	    	    	break;
//	    	    }
//	       
//	       }
		
		
    
		
    // System.out.println("bharath----------"+clientrole.totalPermissionTabledataCheckbox()+"-----------");
     
//     	int len = clientrole.totalPermissionTableRows();
//		for(int r=0;r<len;r++)
//		{
//			
//			List<WebElement> moduledata=driver.findElements(By.xpath("//table//tr/td[1]"));
//			WebElement moduledatas = moduledata.get(r);
//			
//			String getModuleListText=moduledatas.getText();
//			int rw = clientrole.totalPermissionTabledataCheckbox();
////			System.out.println("----length"+rw);
//			for(int c=1;c<rw;c++)
//			{
//				List<WebElement> allcheckbox =driver.findElements(By.xpath("//table//tr/td"));
//				   
//				
//				WebElement allcheckboxs = allcheckbox.get(c);
//				
//				if(getModuleListText.equals("violations_dashboard"))
//				{
//					System.out.println("data123----------------"+allcheckboxs+"---------------");
//					Thread.sleep(1000);
//					allcheckboxs.click();
//					
////					
//				}
//				
//			}
//		}
		
   
//     for(int h=0;h<clientrole.totalPermissionTableHeadercheckbox();h++)
//		{
//			List<WebElement> headers=driver.findElements(By.xpath("//table//tr/th"));
//			WebElement headerdata=headers.get(h);
//			
//			String getHeaderData=headerdata.getText();
//			
//			System.out.println("anil---------"+getHeaderData+"---------");
//			try 
//			{
//			  if(getHeaderData.equalsIgnoreCase("edit"))
//			   {
//				  System.out.println("anil-----------"+getHeaderData);
//				  Thread.sleep(3000);
//				  headerdata.click();
//			     Thread.sleep(5000);
//			     break;
//			   }
//		}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}

//     for(int h=0;h<clientrole.totalPermissionTableHeadercheckbox();h++)
//		{
//			List<WebElement> headers=driver.findElements(By.xpath("//table//tr/th"));
//			  WebElement HeaderData=headers.get(h);
//			  String getHeaderData=HeaderData.getText();
//			
//			  System.out.println("anil------"+getHeaderData);
//		
//			  if(getHeaderData.equalsIgnoreCase("delete"))
//			   {
//				 System.out.println("anil kumar------"+getHeaderData);
//				 Thread.sleep(2000);
//				 HeaderData.click();
//			     Thread.sleep(2000);
//			   }
//			 
//		}

     

//     for (int h = 0; h <= clientrole.totalPermissionTableHeadercheckbox(); h++) 
//		{
//			try {
//				List<WebElement> headerCheckbox = driver.findElements(By.xpath("//table//tr/th/input[@type='checkbox']"));
//				WebElement headerChechbox = headerCheckbox.get(h);
//				headerChechbox.click();
//				Thread.sleep(2000);
//			    } 
//			catch (Exception e) 
//			{
//				e.printStackTrace();
//				System.out.println("The exception occurred is : " + e);
//			}
//	
//	     }
     
//     String desiredDate = "2025/Jan/5";
//     String[] dateParts = desiredDate.split("/");
//     String year = dateParts[0];
//     String month = dateParts[1];
//     String day = dateParts[2];
//     
//   
//     driver.findElement(By.xpath("(//button/i)[1]")).click();
//     Thread.sleep(2000);
//     WebElement yearInput = driver.findElement(By.xpath("//select[@title='Select year']"));
//     yearInput.sendKeys(year);
//     Thread.sleep(2000);
//     WebElement monthInput = driver.findElement(By.xpath("//select[@title='Select month']"));
//     monthInput.sendKeys(month);
//     Thread.sleep(2000);
//     List<WebElement> dayInput = driver.findElements(By.xpath("//div[@role='gridcell']/div"));
//     
//     int daysize=dayInput.size();
//     for(int d=0;d<daysize-1;d++)
//     {
//    	 WebElement days=dayInput.get(d);
//    	 String getdaytext=days.getText();
//    	
//    	 if(getdaytext.equals(day))
//    	 {
//             days.click(); 
//             break;
//    	 }
//     }
//     Thread.sleep(2000);
//     WebElement fileupload=driver.findElement(By.xpath("//span/img"));
//     fileupload.click();
////     Thread.sleep(2000);
////     fileupload.sendKeys("/home/active30/Desktop/Parklens files/96au-plainsman-park.png");
////  
////    Thread.sleep(5000);
// 
//    Robot rob=new Robot();
// 	rob.delay(2000);
// 	String imagePath="/home/active30/Desktop/Parklens files/96au-plainsman-park.png";
// 	
// 	StringSelection copyPath=new StringSelection(imagePath);
// 	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copyPath, null);
// 	
// 	rob.keyPress(KeyEvent.VK_CONTROL);
// 	rob.keyPress(KeyEvent.VK_V);
// 	rob.keyRelease(KeyEvent.VK_CONTROL);
// 	rob.keyRelease(KeyEvent.VK_V);
// 	
// 	rob.keyPress(KeyEvent.VK_ENTER);
// 	rob.keyRelease(KeyEvent.VK_ENTER);
//     
//		Thread.sleep(2000);
//		TestSites site=new TestSites(driver);
//		site.setParticularClientOnDropdown(" Anil-Client ");
//		Thread.sleep(2000);
//		
//		TestLots lot=new TestLots(driver);
//		lot.setParticularSiteOnDropdown(" Anil-Site ");
//		Thread.sleep(2000);
//		
//		TestCameras camera=new TestCameras(driver);
//		camera.setLotRandomlyOnDropdown();
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//span[@class='ng-arrow-wrapper']")).click();
//		
//		List<WebElement> checkboxs=driver.findElements(By.xpath("//input[@type='checkbox']"));
//		List<WebElement> options=driver.findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div"));
//		int countoptions=options.size();
//		for(int i=0; i<countoptions-1;i++)
//		{
//			WebElement allcheckboxs=checkboxs.get(i);
//			WebElement totalOptions=options.get(i);
//			String getoptiontexts=totalOptions.getText();
//			
//			if(getoptiontexts.equalsIgnoreCase("select all"))
//			{
//				allcheckboxs.click();
//				break;
//			}
//			
//		}
        
//        WaitHelper helper=new WaitHelper(driver);
//       
//        
//        driver.findElement(By.xpath("//span[.=' Sites']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[.=' New']")).click();
//        Thread.sleep(2000);
//        WebElement ele=driver.findElement(By.xpath("(//select[@formcontrolname='DropdownControl'])[1]"));
//        helper.waitforElement(ele, 30);
//      Select selectClient=new Select(ele);
//  	  List<WebElement> options=selectClient.getOptions();
//  	  
//  	  int countOptions = options.size();
//  	  int randomIndex = (int) (Math.random() * (countOptions-1))+1;
//  	  System.out.println("Anil : "+randomIndex);
//  	  Thread.sleep(2000);
//  	  selectClient.selectByIndex(randomIndex);
//	   
        
        driver.findElement(By.xpath("//*[@id='sidebar-menu']/li[2]/a")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//table/tbody/tr[1]/td[9]/container-element/div/span/img")).click();
//        Thread.sleep(2000);
////        String gettext=driver.findElement(By.xpath("(//input[@type='text'])[1]")).getText();
////        System.out.println("text "+gettext);
//        driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
//       
//        Robot rob=new Robot();
//        rob.keyPress(KeyEvent.VK_CONTROL);
//        rob.keyPress(KeyEvent.VK_A);
//        
//        Thread.sleep(500);
//        rob.keyPress(KeyEvent.VK_CONTROL);
//        rob.keyPress(KeyEvent.VK_C);
//        rob.keyRelease(KeyEvent.VK_C);
//        rob.keyRelease(KeyEvent.VK_CONTROL);
//        
//        rob.keyRelease(KeyEvent.VK_A);
//        rob.keyRelease(KeyEvent.VK_CONTROL);
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//button[.='Cancel']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//app-table/div/div/div[1]/input")).click();
//       
//        rob.keyPress(KeyEvent.VK_CONTROL);
//        rob.keyPress(KeyEvent.VK_V);
//        rob.keyRelease(KeyEvent.VK_V);
//        rob.keyRelease(KeyEvent.VK_CONTROL);
//        
//        rob.keyPress(KeyEvent.VK_ENTER);
        
        
        WebElement records=driver.findElement(By.xpath("((//tbody/tr)[1]/td)[2]"));
        String gettext=records.getText();
       
        
        driver.findElement(By.xpath("//app-table/div/div/div[1]/input")).sendKeys(gettext);
        Thread.sleep(2000);
        Robot rob=new Robot();
        rob.keyPress(KeyEvent.VK_ENTER);
        rob.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(3000);
        WebElement record = driver.findElement(By.xpath("(//table/tbody/tr/td[2]/container-element/div)[1]"));
        boolean displayed=record.isDisplayed();
        System.out.println(displayed);
        
        if(displayed)
        {
        	System.out.println("this record has not deleted...");
        }
        else
        {
        	System.out.println("this record has deleted...");
        }
	}
	
}
	

