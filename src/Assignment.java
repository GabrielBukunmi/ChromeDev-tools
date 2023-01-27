import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		//Open URL link
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//explicit wait - WebDriverWait is used for explicit wait
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(By.id("checkBoxOption1")));
		
		driver.findElement(By.id("checkBoxOption1")).click();
	 Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
	 Thread.sleep(2000);
	 driver.findElement(By.id("checkBoxOption1")).click();
	}

}
