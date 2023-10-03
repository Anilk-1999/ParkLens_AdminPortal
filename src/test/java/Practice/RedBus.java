package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedBus 
{

	WebDriver driver;
	
	   @Test
	   public void setup() throws InterruptedException
	   {
		   String monthyear="Sept 2024";
//		   String[] monthyears=monthyear.split(" ");
//		   String month=monthyears[0];
//		   String year=monthyears[1];
		   
		   String day="15";
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
	       driver.get("https://www.redbus.in/");
	       
	       
	       driver.findElement(By.xpath("//div[@class='labelCalendarContainer']/i")).click();
	   
			while (true) 
			{ 
				Thread.sleep(1000);
				String text=driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[2]")).getText();
				System.out.println(text);
				Thread.sleep(2000);
//				System.out.println(month+" "+year);
//				if (text.contains(month+" "+year))
				if (text.contains(monthyear))
				{
					break;
				}
			    else 
			    {
                   driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[3]")).click();  
				}
			}
			
			List<WebElement> totaldays=driver.findElements(By.xpath("//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']"));
			
			int getsize=totaldays.size();
			
			for(int d=0;d<getsize-1;d++)
			{
				WebElement dayscount=totaldays.get(d);
				String getdaystext=dayscount.getText();
				
				if(getdaystext.equals(day))
				{
					dayscount.click();
				}
			}
	      
	   }
	
}
