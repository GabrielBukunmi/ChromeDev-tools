import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingcalendarUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
		
		/**
		 * To select a day in a calendar, grab the common attribute e.g ui-state-default,
		 * put it in a list and iterate 
		 */
		List<WebElement> dates = driver.findElements(By.className("ui-state-default"));
		
		int count = driver.findElements(By.className("ui-state-default")).size();
		//This is to get the count of all the date element on the page as at the time 
		//the calendar is opened
		//System.out.println(count);
		
		
		//while loop will keep iterating until the condition is false
		System.out.println(driver.findElement(By.cssSelector("[class='ui-datepicker-month']")).getText()); 
			for( int i=0;i<count;i++) {
				
				String dateNumber = driver.findElements(By.className("ui-state-default"))
						.get(i).getText();
				if(dateNumber.equalsIgnoreCase("26")) {
					
					driver.findElements(By.className("ui-state-default")).get(i).click();
					break;
					
				}
			}
			
		
		



	}

}
