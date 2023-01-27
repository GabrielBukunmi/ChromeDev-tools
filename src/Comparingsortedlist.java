import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Comparingsortedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on the veg icon to sort list
		driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit']")).click();
		//tr/td[1]
		//capture all webelements into a list
		List<WebElement> listOfItems= driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelement into a new list
		List<String> originalList = listOfItems.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort the orginal List and compare if the newly sorted list is the same as the original list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		
		//print the price of any of the item
		
		//e.g if item is beans, print the price
		
//		List<String> price =listOfItems.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
//		price.forEach(s->System.out.println(s));
		
		/**
		 * what if the items to search for e.g rice, is not on the first page
		 * Then the next button needs to be clicked
		 */
		List<String> itemPrice;
		do{
		//capture all webelements into a list
		List<WebElement> items= driver.findElements(By.xpath("//tr/td[1]"));
		itemPrice =items.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
		itemPrice.forEach(System.out::println);
		System.out.println(itemPrice.size());
		if(itemPrice.size()<1) {
			//if the size of the item price is less 1, click on the next button
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			
		}
		
		}while(itemPrice.size()<1);
		
		
		
	
		
		
		
	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		//from the current element [Beans], transverse to the corresponding price
		String priceValue= s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
