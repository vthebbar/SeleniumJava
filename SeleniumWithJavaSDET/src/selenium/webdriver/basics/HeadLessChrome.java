package selenium.webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChrome {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		
		// To run in head less mode use ChromeOptions class
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);                  // approach 1
		// options.addArguments("--headless");      // approach 2
		
		WebDriver driver = new ChromeDriver(options);  // For headless -> Need to pass options as parameter 
		
		driver.get("https://google.com");
		System.out.println("Page Title="+ driver.getTitle());
		
		driver.close();
	}

}
