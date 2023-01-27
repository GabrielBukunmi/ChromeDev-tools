package chromeDevLearning;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Response;

public class Networklogging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		//Enable some details in the network such as maxtotalbuffersize,
		//maxResourcesbuffersize and maxpostdatasize if available
		devtools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		
		//Event will get fired so a listener is needed to when the network call is triggered
	devtools.addListener(Network.responseReceived(), response->{
		Response res=response.getResponse();
		System.out.println(res.getStatus());
		System.out.println(res.getUrl());
	});
	
	driver.get("https://rahulshettyacademy.com/angularAppdemo");
	
	driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
	}

}
