package chromeDevLearning;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v97.fetch.Fetch;
import org.openqa.selenium.devtools.v97.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v97.network.model.ErrorReason;

public class NetworkFailedRequest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		//FETCH IS USED ON RESPONSE CALLS
		//track the http call that has the GetBooks anywhere
		//java.util.Optional<java.lang.String> url pattern
		//this is to deliberately fail the request having GetBook in it's url link
		Optional<List<RequestPattern>> patterns =Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
		devtools.send(Fetch.enable(patterns, Optional.empty()));
		
		devtools.addListener(Fetch.requestPaused(), request-> {
			devtools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
	}

}
