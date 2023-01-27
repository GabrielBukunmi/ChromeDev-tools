import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Addingitems {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		// expected product name
		
		String[] productName = { "Cucumber", "Brocolli", "Beetroot" };

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
	
		addItems(driver,productName);
		
		
	}
	
	
	public static void addItems(WebDriver driver,String[] productName) throws InterruptedException {
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for (int i = 0; i < products.size(); i++) {
			int j=0;

			String[] items = products.get(i).getText().split("-");
			String itemNames = items[0].trim();

			// convert array to array list for easy search

			List itemsNeeded = Arrays.asList(productName);

			// check whether item names extracted is present in array list or not
			if (itemsNeeded.contains(itemNames)) {
				j++;
				// click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==productName.length) {
					break;
				}

			}
		}
		String promocode = "rahulshettyacademy";
		driver.findElement(By.className("cart-icon")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.className("promoCode")).sendKeys(promocode);
		driver.findElement(By.className("promoBtn")).click();
		//explicit wait
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

	}

}
