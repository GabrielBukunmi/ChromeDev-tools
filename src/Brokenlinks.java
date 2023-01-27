import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		//GET THE URL
		//regular expression in css selector
		String link =driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		System.out.println(link);
		
		//pass it as a url using Java
//		URL url = new URL(link);
//		//ust the open connection method in the URL class to open the connection
//		//URLConnection conn=url.openConnection();
////		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
////		
////		conn.setRequestMethod("HEAD");
////		conn.connect();
////		int respcode =conn.getResponseCode();
////		System.out.println(respcode);
//		
		//get all the links in the footer page
		int countoflinks= driver.findElements(By.xpath("//li[@class='gf-li']/a")).size();
		//System.out.println(countoflinks);
		//store the link tags into a list
		List<WebElement> allLinks= driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		//iterate over the link to get one
		
		Thread.sleep(5000);
		
		/**
		 * SOFT ASSERT
		 * Soft Assertion can be used to allow a failed test to run while it stores the failed scenario
		 * and then print it in the log with assertAll method
		 * 
		 * Unlike a normal Assert.assert..... that breaks the loop once the condition is false,
		 * the soft assertion allows the iteration to run even with the failed scenario
		 */
		
		SoftAssert softAssert=new SoftAssert();
		
		for(WebElement onelink:allLinks) {
			
			String linkurl =onelink.getAttribute("href");
			
			
			
			URL a_link = new URL(linkurl);
			
			HttpURLConnection theconnectionlink=(HttpURLConnection)a_link.openConnection();
			
			theconnectionlink.setRequestMethod("HEAD");
			//HEAD request method is like a GET method for API but it does not return any response body
			theconnectionlink.connect();
			int responsecode =theconnectionlink.getResponseCode();
			System.out.println(responsecode);
			//put responsecode<400 so that false can be put in assertTrue to break it
			softAssert.assertTrue(responsecode<400,"The link with the text " +onelink.getText()+"is broken with code "+responsecode);
			
//			//if responsecode>400. putting false in the assertTrue will stop the iteration
//			if(responsecode>400) {
//				System.out.println("The link with the text "+onelink.getText()+"is broken with code "+responsecode);
//				Assert.assertTrue(false);
//			}
			
		}
		
		//assertAll is used to print out all the captured assertion gotton from the softAssert
		softAssert.assertAll();
		
		
		
		
		
	}

}
