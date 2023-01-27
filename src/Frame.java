import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://jqueryui.com/droppable");
			WebElement iframe = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
			driver.switchTo().frame(iframe);
			WebElement draggable = driver.findElement(By.id("draggable"));
			WebElement droppable = driver.findElement(By.id("droppable"));
			Actions action= new Actions(driver);
			action.dragAndDrop(draggable, droppable).build().perform();	
			//this is to switch back to the entire html page and not just the iframe
			//so that other activities can now be performed on the page
			driver.switchTo().defaultContent();
			
			}

}
