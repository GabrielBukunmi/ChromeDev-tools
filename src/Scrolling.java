import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
	    /**
	     * To scroll on a page in selenium , a class called Javascriptexecutor is used. 
	     * Then you can cast driver to become a Javascriptexecutor
	     */
			
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,500)"); //window.scroll(0,500) is to move it in f(x,y) direction y=500 in this case
		
		/**
		 * To scroll on a component, javascript is also used
		 */
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");// this scrolls the table with the classname tableFixHead
		//querySelector works just like css selector.  .Classname can be used to locate the element
		
		List<WebElement> tableData = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		//td:nth-child(4) to locate the element in the fourth column
		int sum=0;
		for(int j=0; j<tableData.size();j++) {
			
			//iterate through the values in the fourth column and sum them
			String values = tableData.get(j).getText();
			//parse the string to int so it is summable
			
			
			sum = sum + Integer.parseInt(values);
		}
		
		System.out.println(sum);
		int sumOnPage = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println(sumOnPage);
		//use an assertion to compare the summed value and the sum on the page
		Assert.assertEquals(sum,sumOnPage);
	}

}
