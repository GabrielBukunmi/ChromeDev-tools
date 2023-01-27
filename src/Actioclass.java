import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actioclass {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		//Action class allows the driver to behave like a mouse
		Actions action = new Actions(driver);
		//move to the webElement without clicking on it
		action.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click()
		.keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		/**
		 * The action class requires that .build() and .perform() are stated after the action for it to
		 * work
		 */
		action.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		// contextClick() is used to right click by the action class
		//clickandHold() can also be used in place of keydown
		
		action.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build().perform();
		
		

		
		
		
		
	}

}
