package selenium.webdriver.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// mouse over (hover)
public class MouseOver_Hover {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/hovers");
		
		// Actions class is used for mouse over
		Actions act = new Actions(driver);
		
		WebElement user1 = driver.findElement(By.xpath("//h5[text()='name: user1']//parent::div//parent::div/img"));
		WebElement user1_profile = driver.findElement(By.xpath("//h5[text()='name: user1']//following-sibling::a"));
		
		act.moveToElement(user1).moveToElement(user1_profile).click().build().perform();
		
		driver.navigate().back();
		
		WebElement user2= driver.findElement(By.xpath("//h5[text()='name: user2']//parent::div//parent::div/img"));
		WebElement user2_profile=driver.findElement(By.xpath("//h5[text()='name: user2']//following-sibling::a"));
		
		act.moveToElement(user2).moveToElement(user2_profile).click().build().perform();
		
		driver.navigate().back();
		
		
		WebElement user3= driver.findElement(By.xpath("//h5[text()='name: user3']//parent::div//parent::div//img"));
		WebElement user3_profile = driver.findElement(By.xpath("//h5[text()='name: user3']//following-sibling::a"));
		
		act.moveToElement(user3).moveToElement(user3_profile).click().build().perform();
		
		driver.close();
	}

}
