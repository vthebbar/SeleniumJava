package selenium.webdriver.basics;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Handling multiple browser windows/tabs
public class SwitchingBrowserWindows {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> handles = driver.getWindowHandles();  // Get all open window handles
		
		for(String hanlde : handles) {
			
			String page_title = driver.switchTo().window(hanlde).getTitle();
			System.out.println(page_title);
			
			String current_url = driver.getCurrentUrl();
			//OR
			/*
			driver.switchTo().window(hanlde);
			System.out.println(driver.getTitle());
			*/
			
			// close particular window based on title
			if(page_title.equals("The Internet")) {
				driver.close();
			}
			
			// close based on current URL
			
			if(current_url.equals("https://the-internet.herokuapp.com/windows/new")){
				driver.close();
			}
			
		}
	}

}
