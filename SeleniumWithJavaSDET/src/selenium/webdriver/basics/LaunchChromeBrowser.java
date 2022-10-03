package selenium.webdriver.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // invoke the browser
		driver.get("https://google.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
				
		String expected_title = "selenium - Google Search";
		String act_title = driver.getTitle();
		
		if(expected_title.equals(act_title)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		driver.close();
	}

}
