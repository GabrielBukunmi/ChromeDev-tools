import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSwitchWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\eclipse-workspace\\Learning\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it= windows.iterator();
		String parentID= it.next();
		String childID= it.next();
		driver.switchTo().window(childID);
		String email = driver.findElement(By.xpath("//p[@class='im-para red']")).getText()
				.split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(email);
		
	}

}
