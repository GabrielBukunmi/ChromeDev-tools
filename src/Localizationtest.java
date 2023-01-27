import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Localizationtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();

		Map<String, Object> device = new HashMap<String, Object>();
		// mock geolocation with chromedev tool
		device.put("latitude", 40);
		device.put("longitude", 3);
		device.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", device);

		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

	}

}
