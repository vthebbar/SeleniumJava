package selenium.webdriver.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// Xpath
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[starts-with(text(),'Forgott')]")).click();
		driver.navigate().back();
		
		
		driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("contains-xpath");
		
		Thread.sleep(2000);
		// Use of parent, preceding-sibiling in xpath
		//input[@id='pass']//parent::div//parent::div/preceding-sibling::div/input[@id='email']
		
		driver.findElement(By.xpath("//input[@id='pass']//parent::div//parent::div/preceding-sibling::div/input[@id='email']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='pass']//parent::div//parent::div/preceding-sibling::div/input[@id='email']")).sendKeys("Parent-sibiling");
		Thread.sleep(2000);
		
		// Use of child::  in xpath
		//div[@class='_6lux']//child::input[@id='email']
		
		driver.findElement(By.xpath("//div[@class='_6lux']//child::input[@id='email']")).clear();
		driver.findElement(By.xpath("//div[@class='_6lux']//child::input[@id='email']")).sendKeys("Child-in-xpath");
		Thread.sleep(2000);
		driver.close();
	}

}
