package chromeDevLearning;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CloudBasedSauceLabs {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("100");
		Map<String, Object> sauceOptions = new HashMap<>();//hashmap takes in two parameter. key value pair
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://oauth-odunlamibukunmi-9d5bd:be358755-7e37-4960-b1ad-1452f302ca38@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//dropdown with select tag
		WebElement staticDropdown= driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		
		Select dropdown =new Select(staticDropdown);
		dropdown.selectByIndex(3);
		//System.out.println(dropdown.getFirstSelectedOption().getText());
		String selectedoption = dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedoption, "USD");
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	
		
	}
		
	}

