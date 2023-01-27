import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CalendarUI2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		// Chromeoptions is used to set the behaviour of the chrome browser
		ChromeOptions options = new ChromeOptions();
		// block all pop ups with chromeoptions class for this www.path2usa.com url
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(5000);

		// Scroll the page down
		JavascriptExecutor js = (JavascriptExecutor) driver; // this is to cast the driver to javascript executor
		js.executeScript("window.scroll(0,200)");
		driver.findElement(By.name("travel_date")).click();
		List<WebElement> dates = driver.findElements(By.cssSelector(".day"));

		int count = driver.findElements(By.cssSelector(".day")).size();

		/**
		 * A while loop is need for it to move from April to another month and then
		 * select a date. so while the element say May, click next
		 */
		while (!driver.findElement(By.cssSelector(".datepicker-switch")).getText().contains("June")) {
			driver.findElement(By.className("next")).click();
			// the while loop will stop executing once the condition is false
			// i.e once June shows on the page
		}
		/**
		 * iterate through a loop to select the date
		 */
		//		
	
		
		for (int i = 0; i < count; i++) {

			String dateNumber = driver.findElements(By.cssSelector(".day")).get(i).getText();
			// Get the date number from the day tag

			if (dateNumber.equalsIgnoreCase("29")) {
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
			Thread.sleep(2000);
		}
		/**
		 * Take screen shot of the page using TakesScreenshot method being casted into
		 * the driver
		 */
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\odunlamib\\Desktop\\Selenium Data\\Seleniumscreenshot\\example.png"));
	}
	
	public static void selectDate(WebElement s) {
		s.click();
		
	}

}
