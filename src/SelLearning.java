import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelLearning {

	public static void main(String[] args) {
		// Invoking the browser
		//Chrome - ChromeDriver- Methods close get
		//Firefox - FirefoxDriver - Methods close get
		//WebDriver close get
		//WebDriver methods + class methods
		
		// chromedriver.exe-- chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Downloads\\chromedriver\\chromedriver.exe");
         //System.setProperty("webdriver.edge.driver", "C:\\Users\\odunlamib\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		//this is a key value pair, key-webdriver.chrome.driver and the value is the path
		//firefox uses gecko driver
		//webdriver.chrome.driver-value of path
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		//driver.quit(); it closes all the opened window while driver.close() closes only the originally opened window

	}

}
