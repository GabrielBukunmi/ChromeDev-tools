import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;

public class Relativelocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/**
		 * Relative locators only support the TagName locator 
		 * a static package has to be imported as it will not be auto suggested -
		 * - import static org.openqa.selenium.support.locators.RelativeLocator.*;
		 * Syntax is:
		 * driver.findElement(with(By.TagName("e.g label or a")).above(WebElement))
		 * Relative locators do not identify flex element in the html dom
		 */
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		String getLabel =driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(getLabel);
		
		WebElement editBoxText = driver.findElement(By.className("form-check-label"));
		driver.findElement(with(By.tagName("input")).toLeftOf(editBoxText)).click();
	}

}
