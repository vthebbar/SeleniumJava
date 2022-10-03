package selenium.webdriver.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefoxBrower {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "../SeleniumWithJavaSDET/geckodriver-v0.31.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String expected_title = "selenium";
		String act_title = driver.getTitle();
		
		if(act_title.contains(expected_title)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		driver.close();
	}

}
