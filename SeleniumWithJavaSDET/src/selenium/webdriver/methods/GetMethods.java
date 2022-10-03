package selenium.webdriver.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) {

		//Methods -> get, getText, getCurrentUrl, getPageSource, getTitle
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		
		//driver.findElement(By.name("q")).sendKeys("Test");
		//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		String res = driver.findElement(By.partialLinkText("Bahasa ")).getText();
		System.out.println(res);
		
		driver.quit();
	}

}
