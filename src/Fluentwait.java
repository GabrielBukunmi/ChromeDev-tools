import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class Fluentwait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();
	
		//Fluent wait declaration
		//function generics in java
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		//click on the start button
		
		WebElement helloText = driver.findElement(By.cssSelector("[id='finish'] h4"));
		WebElement fluent = w.until(new Function<WebDriver, WebElement>() {
			
			/**
			 * The new Function<WebDriver, WebElement> is a functional interface and
			 * this is its declaration
			 */
			
			public WebElement apply(WebDriver driver) {
				if(helloText.isDisplayed()){
					return helloText;
				}
				else {
					return null;
				}
			}
		});
		
System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
		
		
	}
	
	
}
