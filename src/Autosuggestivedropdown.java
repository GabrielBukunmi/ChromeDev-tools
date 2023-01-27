import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestivedropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		//Open URL link
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//dropdown with select tag
		//using regular expression with xpath
		driver.findElement(By.xpath("//input[contains(@class,'inputs')]")).sendKeys("ind");
		List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		Thread.sleep(2000);
		
		//using enhanced for loop to iterate through the suggested options
		for(WebElement i:options) {
			if(i.getText().equalsIgnoreCase("India")) {
				i.click();
				break;
			}
		}
		
		
		

	}

}
