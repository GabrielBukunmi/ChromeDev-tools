import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Httpexception {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		
		/**
		 * The behaviour of a page can be set using Chromeoptions
		 * So when a page shows privacy error , the Chromeoptions method can be used to set
		 * chrome to accept insecure certificate
		 */
		ChromeOptions options= new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		/**
		 * for firefox or edge, the same method is available in selenium
		 * e.g FirefoxOptions or EdgeOptions
		 */
		/**
		 * next is to pass the behaviour of the chromeoption to the driver so the
		 * driver can utilize the behave.
		 * pass option to the method ChromeDriver
		 */
		
		/**
		 * To set Proxy in selenium
		 */
		Proxy proxy = new Proxy();
		//then set http proxy ipaddress
		proxy.setHttpProxy("ipdadress:4444");
		//then pass the proxy into the chrome option object
		options.setCapability("proxy", proxy);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com");
		driver.getTitle();
		//Takescreenshot
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\odunlamib\\Desktop\\Selenium Data\\Seleniumscreenshot\\page.png"));
	}

}
