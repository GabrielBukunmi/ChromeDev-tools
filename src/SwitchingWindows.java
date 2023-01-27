import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\odunlamib\\Desktop\\Selenium Data\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windowhandles = driver.getWindowHandles();	//[parentId, childId]
		
//		int length = windowhandles.size();
//		Iterator<String> it =  windowhandles.iterator();
//		String childwindow = "";
//		for(int i=0; i<=length; i++) {
//			if(i==1) {
//				childwindow=it.next();
//			};
//		}
//		System.out.println(childwindow);
		
				Iterator<String> it = windowhandles.iterator();
		String parentId =it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String email = driver.findElement(By.cssSelector("p.im-para.red"))
				.getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentId);
		
		driver.findElement(By.cssSelector("#username")).sendKeys(email);
		
		//windows =CDwindow-E68641F381386BC8CC45E46145BB211A

		}

}