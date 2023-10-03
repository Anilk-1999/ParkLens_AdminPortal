package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TestHomePage extends Basepage 
{
 
   public TestHomePage(WebDriver driver)
   {
	   super(driver);
   }
   
	 /*----------****admin user home page	***--------------*/
     By status_options       = By.xpath("//span[.='All Status']/../..//li");
 	 By status_filter        = By.xpath("//span[.='Status']");
	 By status_search_field  = By.xpath("(//div/input)[1]");
	 By reset_btn            = By.xpath("//button[.=' Reset']");
	 By search_textfield     = By.xpath("//input[@placeholder='Search By Name']");
	 By id_sorting           = By.xpath("(//div/img)[2]");
	 By name_sorting         = By.xpath("(//div/img)[4]");
	 By email_sorting        = By.xpath("(//div/img)[6]");
	 By role_sorting         = By.xpath("(//div/img)[8]");
	 By status_sorting       = By.xpath("(//div/img)[10]");
	 By per_page             = By.xpath("//select[@class='form-select form-select ms-2 me-2']");
	 By first_pagination     = By.xpath("//ul/li/a[@aria-label='First']");
	 By previous_pagination  = By.xpath("//ul/li/a[@aria-label='Previous']");
	 By next_pagination      = By.xpath("//ul/li/a[@aria-label='Next']");
	 By last_pagination      = By.xpath("//ul/li/a[@aria-label='Last']");
	 By attribute_tab        = By.xpath("//a[.='Attributes']");
	 By attribute_values_tab = By.xpath("//a[.='Attribute Values']");
	 By client_roles_tab     = By.xpath("//a[.='Client Roles']");
	 By admin_roles_tab      = By.xpath("//a[.='Admin Roles']");
	 By pagination           = By.xpath("//ul[@class='pagination']/li/a");
	 
	 By kebab_menu           = By.xpath("(//*[@id=\"menu\"]/img)[1]");
	 By kebabmenu_options    = By.xpath("//div[@class='dropdown-menu show']/ul/li");
	  
	 By get_table_row        = By.xpath("//table[@class='table']//tbody/tr");
	 By get_table_column     = By.xpath("//table[@class='table']//tbody/tr/td");
	 By table_header         = By.xpath("//table/thead/tr/th");
	 By table_firstrow_data  = By.xpath("//table[@class='table']//tbody/tr[1]/td");
	 By table_secondrow_data = By.xpath("//table[@class='table']//tbody/tr[2]/td");
	 @FindBy(xpath = "//table[@class='table']")WebElement table;
	 
	
	 /*----------****Searching a admin user using name	***--------------*/
	 
	 public String getnewAddedUserName(WebDriver driver) throws InterruptedException
	 {
		 this.driver=driver;
		 Thread.sleep(2000);
		 return driver.findElement(By.xpath("(//table[@class='table']/tbody/tr/td[2])[1]")).getText();
	 }
	 
	 public void EnterdataIntoSearchField(String name)
	 {
		 driver.findElement(search_textfield).clear();
		 driver.findElement(search_textfield).sendKeys(name);
	 }
	 
	 public void clickOnEnter() throws AWTException
	 {
		 Robot rob=new Robot();
		 rob.keyPress(KeyEvent.VK_ENTER);
	  	 rob.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 public int getNoOfRows()
	 {

	    List<WebElement> tableRows=driver.findElements(get_table_row);
	    return tableRows.size();
	 }
	 
	 public int getNoOfColumn()
	 {
		 List<WebElement> tableColumns=driver.findElements(get_table_column);
		 return tableColumns.size();
	 }
	 
	 public boolean searchAdminUserByName(String name)
	 {
		 boolean flag=false;
		 for(int i=1; i<=getNoOfRows(); i++)
		 {
			 String getName = table.findElement(By.xpath("//table[@class='table']/tbody/tr/td[2]")).getText();
			 if(getName.equals(name))
			 {
				 flag=true;
			 }
		 }
		 return flag;
		 
	 }
	 
/*----------****Searching a admin user using id	***--------------*/
	
	 public String getnewAddedUserId(WebDriver driver)
	 {
		 this.driver=driver;
		return driver.findElement(By.xpath("(//table[@class='table']/tbody/tr/td[1])[1]")).getText();
	 }
	 
	 public boolean searchAdminUserByID(String id) throws InterruptedException
	 {
		 boolean flag=false;
		 for(int i=0; i<=getNoOfRows();i++)
		 {
			Thread.sleep(2000);
			String getid=table.findElement(By.xpath("//table[@class='table']/tbody/tr/td[1]")).getText();
			if(getid.equals(id))
			{
				flag=true;
			}
		 }
		return flag;
		
	 }
	 
	 public void clickOnStatusFilter() throws InterruptedException
	 {
		 Thread.sleep(1000);
		 driver.findElement(status_filter).click();
	 }
	 
	 
	 public void setStatusFilter(String status) throws InterruptedException
	 {
		 
		 List<WebElement> statusOptions=driver.findElements(status_options);
		 int getsize=statusOptions.size();
		 System.out.println(getsize);
		  
		 for(int s=0;s<getsize;s++)
		 {
			 WebElement options=statusOptions.get(s);
			 Thread.sleep(500);
			 String getstatus=options.getText();
			 System.out.println("status : "+getstatus);
			 
			 if(getstatus.equalsIgnoreCase(status))
			 {
				Thread.sleep(1000);
				options.click();
				break;
			 }
		 }
		   
	 }
	 
	 public void clickOnResetButton() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 driver.findElement(reset_btn).click();
	 }
	 
	 public void verifyStatusOnTable(String status) throws InterruptedException
	 {
		      Thread.sleep(1000);
			  List<WebElement> paginations = driver.findElements(pagination);
			  int paginationSize=paginations.size();
			  System.out.println("The record pages : "+paginationSize);
			  
			  for(int i=2;i<paginationSize-2;i++)
			  {
				  WebElement countOptions = paginations.get(i);
				  String getcolor = countOptions.getCssValue("background-color");
				  System.out.println(getcolor);
				  
				  
				  if(getcolor.equalsIgnoreCase("rgba(255, 255, 255, 1)"))
				  {
					  JavascriptExecutor js = (JavascriptExecutor) driver;
					  js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", driver.findElement(previous_pagination));
					     Thread.sleep(2000);
//					     countOptions.click();
					     driver.findElement(next_pagination).click();
					     
				  }
				  else
				  {
					  System.out.println("check next one");
					  
				  }
				
				  Thread.sleep(2000);
				  JavascriptExecutor js = (JavascriptExecutor) driver;
				  js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", driver.findElement(reset_btn));
				  
				  List<WebElement> statusintable = driver.findElements(By.xpath("//table[@class='table']//tbody/tr/td//div[@class='d-flex justify-content-center']"));
				  int statussize=statusintable.size();
				  
				  for(int s=0;s<statussize;s++)
				  {
					  WebElement options = statusintable.get(s);
					  String getstatus=options.getText();
					  
					  if(getstatus.equalsIgnoreCase(status))
					  {
						  System.out.println("this is : "+getstatus);
					  }
					  else
					  {
						  System.out.println("incorrect status...");
					  }
			  }
		  }
			  
	 }
	 
	 public void VerifyAllRecordsPresentInTable() throws InterruptedException
	 {
		  Thread.sleep(1000);
		  int paginationSize = driver.findElements(pagination).size();
		  System.out.println("The total record pages : "+paginationSize);
	 }
	 
	 public void selectPerpage(String pageNumber) throws InterruptedException
	 {
		 Thread.sleep(1000);
		 WebElement perpageDropdown = driver.findElement(per_page);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", perpageDropdown);
		
		 Select select=new Select(perpageDropdown);
		 Thread.sleep(1000);
		 select.selectByVisibleText(pageNumber);
		 Thread.sleep(1000);
	 }
	 
	 public void totalRecords()
	 {
		 List<WebElement> statusintable = driver.findElements(By.xpath("//table[@class='table']//tbody/tr/td//div[@class='d-flex justify-content-center']"));
		 int statussize=statusintable.size();
		  System.out.println("Total recoreds : "+statussize);
	 }
	 
	 public void setSortingByDescendingOrder(String header) throws InterruptedException
	 {
		 List<WebElement> tableHeader = driver.findElements(table_header);
		 
		 int getHeader=tableHeader.size();
		 for(int h=0;h<getHeader-1;h++)
		 {
			 WebElement countHeader=tableHeader.get(h);
			 String getHeaderText=countHeader.getText();
			 System.out.println("--------------"+getHeaderText);
			 if(getHeaderText.contains(header))
			 {
				 try 
				 {
					 Thread.sleep(2000);
					 driver.findElement(id_sorting).click();
					 break; 
				 }
				 catch(Exception e)
				 {
					 System.out.println(e);
				 }
			 }
		 }
	 }
	
	 public void VerifyRecordsAreDescendingOrder(String header) throws InterruptedException 
	 {
		    List<WebElement> tableHeader = driver.findElements(table_header);

		    for (int h = 0; h < tableHeader.size(); h++) 
		    {
		        WebElement countHeader = tableHeader.get(h);
		        String getHeaderText = countHeader.getText();
		        System.out.println("--------"+getHeaderText);

		        if (getHeaderText.contains(header)) 
		        {
		            Thread.sleep(2000);
		            List<WebElement> firstrowDatas = driver.findElements(table_firstrow_data);
		            List<WebElement> secondrowDatas = driver.findElements(table_secondrow_data);

		            for (int r = 0; r < firstrowDatas.size(); r++) 
		            {
		                WebElement getfirestrowoptions = firstrowDatas.get(r);
		                WebElement getsecondrowoptions = secondrowDatas.get(r);
		               
		                Thread.sleep(2000);
		                String getfirstrowtext = getfirestrowoptions.getText();

		                int intValue1 = Integer.parseInt(getfirstrowtext);
		                System.out.println(intValue1);
		                
		                String getsecondrowtext = getsecondrowoptions.getText();
		                int intValue2 = Integer.parseInt(getsecondrowtext);
		                System.out.println(intValue2);
		                
		                if (intValue1 > intValue2)
		                {
		                    System.out.println("Sorting by descending order was successful.....");
		                    break;
		                } 
		                else 
		                {
		                    System.out.println("Sorting by descending order was not successful.....");
		                }
		            }
		          
		        }
		    }
		}

	 public void setSortingByAscendingOrder(String header) throws InterruptedException
	 {
		 List<WebElement> tableHeader = driver.findElements(table_header);
		 
		 int getHeader=tableHeader.size();
		 for(int h=0;h<getHeader;h++)
		 {
			 WebElement countHeader=tableHeader.get(h);
			 String getHeaderText=countHeader.getText();
			 
			 if(getHeaderText.contains(header))
			 {
				 try 
				 {
					 Thread.sleep(2000);
					 driver.findElement(id_sorting).click();
					 Thread.sleep(1000);
					 driver.findElement(id_sorting).click();
					 break; 
				 }
				 catch(Exception e)
				 {
					 System.out.println(e);
				 }
			 }
		 }
	 }
	
	 public void VerifyRecordsAreAscendingOrder(String header) throws InterruptedException 
	 {
		    List<WebElement> tableHeader = driver.findElements(table_header);

		    for (int h = 0; h < tableHeader.size(); h++) 
		    {
		        WebElement countHeader = tableHeader.get(h);
		        String getHeaderText = countHeader.getText();

		        if (getHeaderText.contains(header)) 
		        {
		            Thread.sleep(2000);
		            List<WebElement> firstrowDatas = driver.findElements(table_firstrow_data);
		            List<WebElement> secondrowDatas = driver.findElements(table_secondrow_data);

		            for (int r = 0; r < firstrowDatas.size(); r++) 
		            {
		                WebElement getfirestrowoptions = firstrowDatas.get(r);
		                WebElement getsecondrowoptions = secondrowDatas.get(r);

		                String getfirstrowtext = getfirestrowoptions.getText();
		                int intValue1 = Integer.parseInt(getfirstrowtext);
		                System.out.println(intValue1);

		                String getsecondrowtext = getsecondrowoptions.getText();
		                int intValue2 = Integer.parseInt(getsecondrowtext);
		                System.out.println(intValue2);
		                
		                if (intValue1 < intValue2) 
		                {
		                    System.out.println("Sorting by ascending order was successful.....");
		                    break;
		                } 
		                else 
		                {
		                    System.out.println("Sorting by ascending order was not successful.....");
		                }
		            }
		        }
		    }
		}
	 
	 public void clickOnKebabMenuIcon() throws InterruptedException
	 {
		 Thread.sleep(1000);
		 driver.findElement(kebab_menu).click();
		 Thread.sleep(1000);
	 }
	 
	 
	 public void selectKebabMenuOption(String menuOptionName) throws InterruptedException
	 {
		 List<WebElement> kebabmenuOptions = driver.findElements(kebabmenu_options);

		 for(int k=0;k<kebabmenuOptions.size();k++)
		 {
			 WebElement countoptions=kebabmenuOptions.get(k);
			 Thread.sleep(1000);
			 String getOptionstext=countoptions.getText();
			 System.out.println(getOptionstext);
			 Thread.sleep(1000);
			 if(getOptionstext.equalsIgnoreCase(menuOptionName))
			 {
				 System.out.println("-------anil----");
				 countoptions.click();
				 break;
			 }
			 else
			 {
				 System.out.println("please select valid option.....");
			 }
		 }
		 
	 }
	 
}
