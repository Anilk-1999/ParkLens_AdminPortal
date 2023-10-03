package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestStatusFilterAndPagination extends Basepage
{
	TestHomePage   searchAdminUser;
  public TestStatusFilterAndPagination(WebDriver driver) 
  {
        super(driver);
        searchAdminUser=new TestHomePage(driver);
  }
  
  public void clickOnStatusFilterDropdown()
  {
	  driver.findElement(searchAdminUser.status_filter).click();
  }
  public void searchStatusOnStatusDropdown(String status)
  {
	  driver.findElement(searchAdminUser.status_search_field).clear();
	  driver.findElement(searchAdminUser.status_search_field).sendKeys(status);
  }
  
  public void clickOnResetButton()
  {
	  driver.findElement(searchAdminUser.reset_btn).click();
  }	
  
  public void sortByid()
  {
	  driver.findElement(searchAdminUser.id_sorting).click();
  }
  public void sortByName()
  {
	  driver.findElement(searchAdminUser.name_sorting).click();
  }
  public void sortByRole()
  {
	  driver.findElement(searchAdminUser.role_sorting).click();
  }
  public void sortByStatus()
  {
	  driver.findElement(searchAdminUser.status_sorting).click();
  }
  public int getPerPageOptions()
  {
	  List<WebElement> perpageOptions = driver.findElements(By.xpath("(//select)/option"));
	  return perpageOptions.size();
	  
  }
  public void selectPerPage(String perPage) throws InterruptedException
  {
	  WebElement perpageDropdown = driver.findElement(By.xpath("//select[@class='form-select form-select ms-2 me-2']"));
	  Select select=new Select(perpageDropdown);
	  
	  for(int i=1;i<getPerPageOptions();i++)
	  {		
		  String gettext=select.getOptions().get(i).getText();
		  if(gettext.equals(perPage))
		  {
			 select.selectByIndex(3);
		  }
	  }
  }
  
  public void setPagination(String selectPage)
  {
	  int size = driver.findElements(By.xpath("//ngb-pagination/ul/li")).size();
	  for(int i=1;i<=size;i++)
	  {
		  String getpaginationText=driver.findElement(By.xpath("//ngb-pagination/ul/li")).getText();
		  if(getpaginationText.equals(selectPage))
		  {
			  driver.findElement(searchAdminUser.first_pagination).click();
		  }
		  else if(getpaginationText.equals(selectPage))
		  {
			driver.findElement(searchAdminUser.next_pagination).click();  
		  }
		  else if(getpaginationText.equals(selectPage))
		  {
			  driver.findElement(searchAdminUser.previous_pagination).click();
		  }
		  else if(getpaginationText.equals(selectPage))
		  {
			  driver.findElement(searchAdminUser.last_pagination).click();
		  }
		  else
		  {
			  System.out.println("please select the valid pagination!.....");
		  }
	  }
  }
  
}
