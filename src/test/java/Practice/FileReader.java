package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileReader 
{
    WebDriver driver;

    public static String convertNumericToWord(String numericMonth) {
        // Define an array of month names
        String[] monthNames = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"
        };

        // Ensure the input is a valid numeric month (between 1 and 12)
        int numericValue = Integer.parseInt(numericMonth);
        if (numericValue < 1 || numericValue > 12) {
            throw new IllegalArgumentException("Invalid numeric month: " + numericMonth);
        }

        // Convert the numeric month to its corresponding word format
        return monthNames[numericValue - 1];
    }

    @Test
    public void loginWithCsvData() throws InterruptedException {
       
    	
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");

        String csvFilePath = "CSVFiles/newAnil.csv";

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(csvFilePath))) {
            String line;
            boolean isFirstLine = true; // Flag to skip the first line (header)

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the first line (header)
                }

                String[] values = line.split(",");
                String from = values[0];
                String to = values[1];
                String date = values[2];
                
                System.out.println(from);
                System.out.println(to);
                System.out.println(date);
                
                driver.findElement(By.xpath("(//input[@class='sc-bxivhb hrsLPT'])[1]")).sendKeys(from);
                driver.findElement(By.xpath("(//input[@class='sc-bxivhb hrsLPT'])[2]")).sendKeys(to);

                String[] monthyears=date.split("/");
                String days = monthyears[0];
      		    String month=monthyears[1];
      		    String year=monthyears[2];
      		    
      		    System.out.println(days);
      		    System.out.println(month);
      		    System.out.println(year);
      	
                String monthInWord = convertNumericToWord(month);
                System.out.println("Month in word: " + monthInWord);
                
                String monthyear=monthInWord+" "+year;
                System.out.println(monthyear);
     	      
                Thread.sleep(2000);
     	        driver.findElement(By.xpath("//div[@class='sc-kAzzGY llxTcS']/../i")).click();
     	        
     	        String day=days;
     		    System.out.println(day);
     	        
     			while (true) 
     			{ 
     			
     				
     				String text=driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[2]")).getText();
     				System.out.println(text);
     			
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
     				Thread.sleep(1000);
     				String getdaystext=dayscount.getText();
     				
     				if(getdaystext.equals(day))
     				{
     					dayscount.click();
     				}
     				
     			}
     			driver.findElement(By.xpath("//button[.='SEARCH BUSES']")).click();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

//    @AfterMethod
//    public void close() {
//        driver.quit();
//    }
}