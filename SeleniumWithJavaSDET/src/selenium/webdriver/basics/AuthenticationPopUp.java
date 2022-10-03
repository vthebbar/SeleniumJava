package selenium.webdriver.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Handling authentication pop up
public class AuthenticationPopUp {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// syntax - https://userid:password@weburl.com
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");	
		
		String text= driver.findElement(By.xpath("//p")).getText();
		System.out.println(text);
		
	}

}
