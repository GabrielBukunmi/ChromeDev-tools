import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Qaacademyassignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		driver.get("https://qaclickacademy.com/practice.php");
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//String clickedOption = driver.findElement(By.id("checkBoxOption1")).getAttribute("id").split("x")[1];
		//a better way below: 
		String clickedOption = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label")).getText();		System.out.println(clickedOption);
		
		Thread.sleep(2000);
		Select staticdropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		staticdropdown.selectByVisibleText(clickedOption);
	
		// stored the selected dropdown option into a variable for later use
		String selectedDropDown = staticdropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedDropDown, clickedOption);

		driver.findElement(By.cssSelector("#name")).sendKeys(clickedOption);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();// this is to click on the alert button

		/**
		 * This is to switch to the alert and then verifies if the clicked option from
		 * the checkbox is contained in the words displayed on the alert
		 */
		String alertMessage =driver.switchTo().alert().getText();
		if(alertMessage.contains(clickedOption)) {
			Assert.assertTrue(true);
			
			System.out.println(alertMessage);
		}

	}

}
