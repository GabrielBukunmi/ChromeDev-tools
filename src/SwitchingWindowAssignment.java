import java.util.Set;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindowAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();

		
	    driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
	    Set<String> windows= driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		//windows.forEach(System.out::println);
		String parentId = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		driver.quit();
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		
	}

}
