package selenium.webdriver.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// DragAndDrop
public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		Actions act = new Actions(driver);
		Thread.sleep(15000);
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.xpath("//h5[text()='High Tatras']"));
		WebElement target = driver.findElement(By.id("trash"));
		
		
		
		// method 1
		act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		// method 2
		
		//act.dragAndDrop(source, target).build().perform();
		
		//act.dragAndDropBy(source, 50, 50);
		
	}

}
