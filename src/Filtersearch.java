import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filtersearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//put rice in the search field
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		//capture the result in a list
		List<WebElement> searchedResult= driver.findElements(By.xpath("//tr/td[1]"));
		//make another list from the search result of items that contains rice and compare
		List<WebElement> filteredResult= searchedResult.stream().filter(result->result.getText().contains("Rice")).collect(Collectors.toList());
	
		Assert.assertEquals(searchedResult.size(), filteredResult.size());
		
	}

}
