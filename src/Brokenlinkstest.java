import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Brokenlinkstest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\msedgedriver.exe");
		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.udacity.com");
		String link =driver.findElement(By.cssSelector("a[href*='business-analytics']")).getAttribute("href");
		System.out.println(link);
		URL url = new URL(link);
		HttpURLConnection theurl = (HttpURLConnection)url.openConnection();
		theurl.setRequestMethod("HEAD"); //HEAD request method is similar to GET but does not return any response body
		theurl.connect();
		int respcode= theurl.getResponseCode();
		System.out.println(respcode);
		
		//now check if there is no broken link in all the links in the entire page
		
		int count = driver.findElements(By.cssSelector("li[class='href text'] a")).size();	
		System.out.println(count);
		 List<WebElement> allLinks= driver.findElements(By.cssSelector("li[class='href text'] a"));
		 Thread.sleep(2000);
		 //iterate over all the links and get their response code to check if any is broken
		 for(WebElement onelink:allLinks) {
			 //get the link as a string from the a tags
			 String conn=onelink.getAttribute("href");
			 //convert the link to a url
			 URL connURL = new URL(conn);
			 //OPEN CONNECTION and specifically cast the URL return type as HttpURLConnection
			 HttpURLConnection httpConnURL =(HttpURLConnection)  connURL.openConnection();
			 //set the requestMethod to HEAD so you can get the response code
			 
			 httpConnURL.setRequestMethod("HEAD");
			 httpConnURL.connect();
			 int responsecode=httpConnURL.getResponseCode();
			 System.out.println(responsecode);
			 if(responsecode>400) {
				 System.out.println("The link with the broken link is "+onelink.getText()+ "with response code "+responsecode);
			 }
			 else {
				 System.out.println("There is no broken link");
			 }
			 
		 }
		
		

	}

}
