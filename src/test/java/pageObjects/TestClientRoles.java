package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TestClientRoles extends Basepage 
{
      
	public TestClientRoles(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Permission Title']")WebElement permission_title;
	@FindBy(xpath = "//table//tr")List<WebElement> permission_rows;
	@FindBy(xpath = "//table//tr/th")List<WebElement> permission_TableHeader_cells;
	@FindBy(xpath = "//table//tr/td")List<WebElement> permission_TableData_cells;
	@FindBy(xpath = "//table//tr/td[1]")List<WebElement> module_datas;
	@FindBy(xpath = "(//span[@class='btn-sm-gray3 edit']/img)[5]")WebElement fifth_editicon;
	
	
	public void clicksOnFifthEditIcon()
	{
		fifth_editicon.click();
	}
	
	
	public void setPermissionTitle(String permissionTitle)
	{
		permission_title.clear();
		permission_title.sendKeys(permissionTitle);
	}
	
	public int totalPermissionTableRows()
	{
		return permission_rows.size()-1;
	}
	
	public int totalPermissionTableHeadercheckbox()
	{
		return permission_TableHeader_cells.size();
	}
	
	public int totalPermissionTabledataCheckbox()
	{
		return permission_TableData_cells.size();
	}

	
	
//	public void clickOnPermissionHeaderCheckBox(String headerName)
//	{
//		
//		for(int h=1;h<=totalPermissionTableHeadercheckbox();h++)
//		{
//			WebElement headers=driver.findElement(By.xpath("//table//tr/th"));
//			String getHeaderData=headers.getText();
//			try 
//			{
//			  if(getHeaderData.equalsIgnoreCase(headerName))
//			   {
//			     headers.click();
//			     break;
//			   }
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
//	}
	
	public void clickOnPermissionCheckBoxColumnWise(String headerName)
	{
		for (int h = 0; h < totalPermissionTableHeadercheckbox(); h++) 
	     {
//	    	    List<WebElement> headers = driver.findElements(By.xpath("//table//tr/th"));
	    	    WebElement headerData = permission_TableHeader_cells.get(h);
	    	    String getHeaderData = headerData.getText();
	    	    
	    	    if (getHeaderData.equalsIgnoreCase(headerName)) 
	    	    {
	    	        int columnIndex = h + 1;
	    	        List<WebElement> checkboxes = driver.findElements(By.xpath("//table//tr/td[" + columnIndex + "]/input[@type='checkbox']"));

	    	        for (WebElement checkbox : checkboxes) 
	    	        {
	    	            if (!checkbox.isSelected()) 
	    	            {
	    	                checkbox.click(); 
	    	            }
	    	        }
	    	        break;
	    	    }
	    	}

	}
	
	
	
	
	public void selectAllPermissionsOnTableHeaderCheckboxes() 
	{
		for (int h = 0; h <totalPermissionTableHeadercheckbox()-1; h++) 
 		{
 			try {
 				List<WebElement> headerCheckbox = driver.findElements(By.xpath("//table//tr/th/input[@type='checkbox']"));
 				WebElement headerChechbox = headerCheckbox.get(h);
 				headerChechbox.click();
 				Thread.sleep(1000);
 			    } 
 			catch (Exception e) 
 			{
 				e.printStackTrace();
 				System.out.println("The exception occurred is : " + e);
 			}
 	
 	     }
	}
	
	
	public void clickOnPermissionCheckboxRowWise(String moduleName) throws InterruptedException
	{
		int len = totalPermissionTableRows();
	     for (int r = 0; r < len; r++) 
	     {
	         List<WebElement> moduledata = driver.findElements(By.xpath("//table//tr/td[1]"));
	         WebElement moduledatas = moduledata.get(r);

	         String getModuleListText = moduledatas.getText();

	         if (getModuleListText.equals(moduleName)) 
	         {
	             List<WebElement> rowCheckboxes = driver.findElements(By.xpath("//table//tr[" + (r + 1) + "]//td/input[@type='checkbox']"));
	             for (WebElement checkbox : rowCheckboxes) 
	             {
	                 TestAddAdminUsers adminuser=new TestAddAdminUsers(driver);
	                 adminuser.scrollIntoView(driver, moduledatas);
	                 Thread.sleep(1000);
	                 checkbox.click();
	                 
	             }
	         }
	     }

	}
	
	
	
}

	

