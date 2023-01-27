package chromeDevLearning;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class ChromeDev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");

		// use chromedriver instead of webdriver if you want to access the chromedev
		// tools
		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		dev.createSession();
		// send commands to cdp method that will now send command to the chrome dev
		// tools

		dev.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty()));
		driver.get("https://gmail.com");
		
		
	}

}
