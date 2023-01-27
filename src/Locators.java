import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Downloads\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//defining implicit wait 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		
		driver.findElement(By.className("submit")).click();
		
		//using cssSelector by adding tagname with class --> Tagname.class e.g button.error
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//driver.findElement(By.linkText("Forgot your password?")).click();
		//using Xpath selector --- //Tagname[@attribute.class]
		
		//driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
		
		//.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahulshettyacademy");
		
		//driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("938373873932");
		
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("rahul");
		
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.className("submit")).click();
		//Successful login now
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		

	}

}
