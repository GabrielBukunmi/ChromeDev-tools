package chromeDevLearning;

import java.time.Duration;
import java.util.HashMap;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.emulation.Emulation;

public class GeolocationOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\chromedriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
//china 35, 104
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		//pass coordinate into a hash map since the values such as latitude, longitude
		//and accuracy is a key value pair
		 HashMap<String,Object> coordinates = new HashMap<String,Object>();
		 coordinates.put("latitude", 40);
		 coordinates.put("longitude", 3);
		 coordinates.put("accuracy", 1);
		 
		 //use executeCdpCommand since a map collection has been created
		 
		 driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		 
		 driver.get("https://google.com");
		 driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		 driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		 String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		 
		 

		 System.out.println(title);
	}		 
		

}
