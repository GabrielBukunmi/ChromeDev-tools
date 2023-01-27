package chromeDevLearning;



import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Createcdpcommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools dev = driver.getDevTools();
		dev.createSession();
		//mock device with using Emulation.setDeviceMetricsOverride
Map deviceMetrics = new HashMap();
deviceMetrics.put("width", 600);
deviceMetrics.put("height", 1000);
deviceMetrics.put("deviceScaleFactor", 50);
deviceMetrics.put("mobile", true);

driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
driver.get("https://google.com");

		
	}

}
