package selenium.webdriver.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// jquery slider bar
public class SliderBar {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/slider/");
		Thread.sleep(4000);
		driver.switchTo().frame(0);
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//span[@tabindex='0']"));
		
		// .build().perform() is important
		act.dragAndDropBy(src, 50, 0).build().perform();
	}

}
