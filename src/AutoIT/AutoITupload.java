package AutoIT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoITupload {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String downloadPath= System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\eclipse-workspace\\Learning\\chromedriver.exe");
		//configure download option with chrome path
		HashMap<String, Object> chromePrefs = new HashMap<String,Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://freepdfconvert.com");
		
		
		driver.findElement(By.cssSelector(".btn-wrapper.upload-btn")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector(".btn-wrapper.upload-btn")).sendKeys("C:\\Users\\odunlamib\\Videos\\Personalized\\Passport_Photograph.jpeg");

		
		
		//invoke autoIT file (exe)
		Runtime.getRuntime().exec("C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\fileupload.exe");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-wrapper.download-btn")));
		driver.findElement(By.cssSelector(".btn-wrapper.download-btn")).click();
		
		Thread.sleep(5000);
		File f = new File(downloadPath+"/azure.pdf");
		//use .exists to check if file exist in the downloaded path
		if(f.exists()) {
			Assert.assertTrue(f.exists());
			
			if(f.delete())
				System.out.println("file deleted");
		}
		
		
		
	}

}
