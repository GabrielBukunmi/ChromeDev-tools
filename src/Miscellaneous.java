import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//To delete cookies
		driver.manage().deleteAllCookies();
		//if you know the particular cookie name. you can delete by name. e.g
		//driver.manage().deleteCookieNamed(name of cookie goes here);
		
		/**
		 * to take screenshot in java
		 * use the TakesScreenshot method. Cast the method to driver just like the JavascriptExecutor class for scrolling
		 */
		driver.get("https://rahulshettyacademy.com/angularpractice");
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		
		//Then use the TakesScreenshot object to get the output as a file
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		//To copy the screen shot from src to a new path. use the FileUtil class
		FileUtils.copyFile(src,new File("C:\\Users\\odunlamib\\Desktop\\Selenium Data\\Seleniumscreenshot\\screenshot.png"));
		
		
		/**
		 * TAKING PARTIAL SCREENSHOT
		 * You can take partial screenshot of the webElement instead of the entire page
		 * apply the getScreenshotAs directly on a webelement
		 */
		WebElement submitButton = driver.findElement(By.className("btn"));
		File source =submitButton.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("C:\\Users\\odunlamib\\Desktop\\Selenium Data\\Seleniumscreenshot\\webelementscreenshot.png"));
				
		
		/**
		 * you can also get the height and weight of a webElement for UX validation
		 */
		//GEt Height & Width

		System.out.println(submitButton.getRect().getDimension().getHeight());

		System.out.println(submitButton.getRect().getDimension().getWidth());

		
		
		
		
		
		
		
		
	}

}
