package AutoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingpopup2 {

	//HANDLING WINDOW AUTHENTICATION POP UP
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//use this url format to pass the username and password with the website url
		//http:Username:Password@SiteURL
		driver.get("http:admin:admin@the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Basic Auth")).click();
		Thread.sleep(2000);
		
		
		
	}
	
	
}
