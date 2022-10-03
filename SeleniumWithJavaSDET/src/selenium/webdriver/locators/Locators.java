package selenium.webdriver.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
			/*   1. ID
			 * 	 2. Name
			 * 	 3. Tag Name
			 *   4. Class Name
			 *   5. Link Text
			 *   6. Partial link text
			 *   7. xpath
			 *   8. CSS selector
			 *   	 a. Tag & ID
			 *   	 b. Tag & Class
			 *   	 c. Tag & attribute
			 *   	 d. Tag, class & attribute
			 *   	 e. Inner Text 
			 * 
			 */
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("ID");
		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("Name");
		
		driver.findElement(By.className("inputtext")).clear();
		driver.findElement(By.className("inputtext")).sendKeys("Classname");
		
		
		List<WebElement> e = driver.findElements(By.tagName("input"));
		System.out.println(e.size());
		
		for(int i=0; i<e.size();i++) {
			System.out.println(e.get(i).getText());   // no text present, so blank will be displayed
		}
		
		
		driver.findElement(By.linkText("Forgotten password?")).click();
		driver.navigate().back();
		
		driver.findElement(By.partialLinkText("password?")).click();
		driver.navigate().back();
		
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("XPATH");
		
		
		driver.findElement(By.cssSelector("input#email")).clear();
		driver.findElement(By.cssSelector("input#email")).sendKeys("cssSelector-id");
		
		driver.findElement(By.cssSelector("input.inputtext")).clear();
		driver.findElement(By.cssSelector("input.inputtext")).sendKeys("cssSelector-class");
		
		driver.findElement(By.cssSelector("input[name=email]")).clear();
		driver.findElement(By.cssSelector("input[name=email]")).sendKeys("cssSelector-Attribute");
		
		//driver.findElement(By.cssSelector("a:contains('password?')")).click();
		
		driver.close();
	}

}
