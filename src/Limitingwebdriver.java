import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Limitingwebdriver {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:qaclickacademy.com/practice.php");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		//get count of link in the footer session by limiting the webdriver scope to only footer section
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		//going inside the footer now to get a column
		WebElement columndriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		/**
		 * This is to get the number of links in the column
		 */
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//click on each link in the first column 
		
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size();i++){
			//click on control and enter on a link to open it in new tab
			//chord is used for multiple key actions like shift + control
			
			String clickOnTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
			Thread.sleep(5000);	
			} //For loop opens all the tap
		
		    Set<String> windowhandles = driver.getWindowHandles();
		    Iterator<String> it = windowhandles.iterator();
		    /**
		     * the getWindowHandles method returns an object which is best stored in a set
		     */
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}// the while loop is to print all the titles
		/**
		 * This while loop  is to say if there is a next object in the iterator of the set
		 * the driver should switch to the next window
		 */
			//Take Screenshot
		TakesScreenshot screenshotTaker= (TakesScreenshot)driver;
		File src= screenshotTaker.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\odunlamib\\Desktop\\Selenium Data\\Seleniumscreenshot\\page1.png"));
		
	}

}
