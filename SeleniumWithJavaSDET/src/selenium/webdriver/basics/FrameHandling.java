package selenium.webdriver.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Handle iframe
public class FrameHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		
		//switch using frame index
		driver.switchTo().frame(0);
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("Test1");
		
		driver.findElement(By.id("tinymce")).clear();
		
		// switch out of frame
		driver.switchTo().defaultContent();
		
		//switch using frame id
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).sendKeys("Test2");
		
		driver.close();
	}

}
