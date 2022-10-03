package selenium.webdriver.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("submit")).click();
		
		String expected_title="Login: Mercury Tours";
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		
		
		if(actual_title.equals(expected_title)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		driver.close();
	}

}
