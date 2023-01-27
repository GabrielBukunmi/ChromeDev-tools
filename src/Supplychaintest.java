import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Supplychaintest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://10.111.30.70:448");
		driver.findElement(By.cssSelector("button[id='details-button']")).click();
		driver.findElement(By.id("proceed-link")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("input#UserName")).sendKeys("odunlamib");
		driver.findElement(By.name("Password")).sendKeys("ooooooo");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println(driver.findElement(By.id("msg")).getText());
	}

}
