package chromeDevLearning;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devtools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		driver.manage().window().maximize();
		long startTime =System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.cssSelector("p")).getText();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
	}

}
