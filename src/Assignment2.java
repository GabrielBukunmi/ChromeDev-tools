import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\eclipse-workspace\\Learning\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://rahulshettyacademy.com/angularpractice");
		driver.findElement(By.name("name")).sendKeys("Bukunmi");
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("testing");
		driver.findElement(By.id("exampleCheck1")).click();
		Thread.sleep(2000);
		//check if checkbox is clicked
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		WebElement genderdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Thread.sleep(1000);
		
		Select dropdown = new Select(genderdropdown);
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		//Check if female is selected in the gender dropdown
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Female");
		driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("bday")).sendKeys("09/04/2022");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println(driver.findElement(By.className("alert-dismissible")).getText());
		
	}

}
