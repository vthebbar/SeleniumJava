package selenium.webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessFireFox {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "../SeleniumWithJavaSDET/geckodriver-v0.31.0-win64/geckodriver.exe");
		
		// For head less
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);  // approach 1
		//options.addArguments("--headless");  // approach 2
		WebDriver driver = new FirefoxDriver(options); // for head less mode - pass options as parameter
		
		driver.get("https://google.com");
		System.out.println("Page Title="+ driver.getTitle());
	}

}
