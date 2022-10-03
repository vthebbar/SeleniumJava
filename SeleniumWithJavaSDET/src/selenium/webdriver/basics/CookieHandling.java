package selenium.webdriver.basics;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		driver.get("https://google.com/");
		
		// Get all cookies
		
		Set<Cookie> cookies=driver.manage().getCookies();
		
		// size
		System.out.println("Number of cookies="+cookies.size());
		
		// print
		for(Cookie c:cookies) {
			System.out.println(c);
		}
		
		System.out.println("=============");
		for(Cookie c:cookies) {
			System.out.println(c.getName() +":"+c.getValue());
		}
		
		// Add cookie
		
		Cookie cobj = new Cookie("Test123","12345678");
		driver.manage().addCookie(cobj);
		
		// get all cookies
		cookies=driver.manage().getCookies();
		
		//size
		System.out.println("Number of cookies="+cookies.size());
		
		System.out.println("=============");
		// print
			for(Cookie c:cookies) {
				System.out.println(c.getName() +":"+c.getValue());
		}
			System.out.println("=============");
			//get cookie by name
			System.out.println(driver.manage().getCookieNamed("1P_JAR"));
			
			// delete cookie
			driver.manage().deleteCookie(cobj);
			System.out.println("=============");
			//size
			System.out.println("Number of cookies="+cookies.size());
			
			// delete all cookies
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
			System.out.println("=============");
			System.out.println("Number of cookies="+cookies.size());
			
			driver.quit();
	}
	
}
