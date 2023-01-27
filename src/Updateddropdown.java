import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Updateddropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\odunlamib\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//check if a checkbox is selected, select one and count them and log
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		//Click the adult plus button 4 times
		int i=1;
		while(i<4) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.xpath("//input[@class='buttonN']")).click();
		System.out.println(	driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		driver.findElement(By.cssSelector("a[value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='GOI']")).click();
		// or driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();
		Thread.sleep(4000);
		//select calendar current date
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']")).click();
		
		//Click the radio button 
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//To check if radio button is selected
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		
		//To check if calendar is enabled after selecting radio button
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
			System.out.println("it's enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
		
		
	
		
		
		
		
		

	}

}
