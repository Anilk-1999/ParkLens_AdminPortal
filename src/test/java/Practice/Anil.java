package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Anil 
{
   public WebDriver driver;
   
   @Test
   public void FirstPicker() throws InterruptedException
   {
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[@id='second_date_picker']")).click();
	   Thread.sleep(2000);
	   WebElement getmontht=driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span)[1]"));
	   String getmonthtext=getmontht.getText();
	   Thread.sleep(2000);
	   String getyeartext=driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span)[2]")).getText();
	   System.out.println();
	   
	   //String getmonthtext1=getmonthtext.getText();
	   
       if(getmonthtext!="August" &&  getyeartext!="2023")
       {
    	   driver.findElement(By.xpath("//span[.='Prev']")).click();
    	   Thread.sleep(2000);
    	   System.out.println("hello boss");
    	   System.out.println("month"+getmonthtext);
    	   System.out.println("year"+getyeartext);
    	   WebElement getmonthts=driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span)[1]"));
    	   String text= getmonthts.getText();
    	   System.out.println("nagraj"+text);
    	   if(text.equalsIgnoreCase("August") &&  getyeartext.equalsIgnoreCase("2023"))
    	   {
               System.out.println("hello anil");
    		   Thread.sleep(2000);
    		   
    		   List<WebElement> days=driver.findElements(By.xpath("//tbody/tr/td/a"));
			   int getdaysize=days.size();
			   
    		   for(int d=0;d<getdaysize-1;d++)
    		   {
    			   
    			   System.out.println("hello naga");
    			   WebElement countdays=days.get(d);
    			   String getdaytext=countdays.getText();
    			   if(getdaytext.equalsIgnoreCase("15"))
    			   {
    				   System.out.println("hello arun");
    				   Thread.sleep(2000);
    				   countdays.click();
    			   }
    		   }
    	   }
       }
   
   }
}
