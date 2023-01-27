package chromeDevLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

import java.util.Optional;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				DevTools devtools=driver.getDevTools();
				devtools.createSession();
				//emulating network speed to make it slow
				
				devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
				
				devtools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
				
				//setting boolean to true in the emulateNetworkConditions will put of the network
				
				//you can also add a listener to know when a network request fail
				devtools.addListener(Network.loadingFailed(), loadingFailed->{
					System.out.println(loadingFailed.getErrorText());
				});
				
				long startTime = System.currentTimeMillis();
				driver.get("https://rahulshettyacademy.com/angularAppdemo");
				
				driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	    long endTime =System.currentTimeMillis();
	    System.out.println(endTime - startTime);
	    driver.close();
	}
	
	

}
