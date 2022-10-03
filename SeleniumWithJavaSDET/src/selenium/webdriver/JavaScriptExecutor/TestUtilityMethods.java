package selenium.webdriver.JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUtilityMethods {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://vthebbar.blogspot.com/about");
		
		WebElement element = driver.findElement(By.id("ContactForm1_contact-form-name"));
		
		//Flash 
		// JavaScriptUtilityMethods.flash_an_elemet(driver, element);
		
		// draw border
		
		JavaScriptUtilityMethods.draw_border(driver, element);
		
		// Get page title
		String title =JavaScriptUtilityMethods.get_page_title_by_js(driver);
		System.out.println(title);
		
		// alert
		//JavaScriptUtilityMethods.generate_alert(driver, "You are on vthebbar blog");
		
		// refresh the page
		//JavaScriptUtilityMethods.page_referesh_by_js(driver);
		
		// scroll till ele2
		WebElement ele2 = driver.findElement(By.xpath("//span[text()='Email This']"));
		//JavaScriptUtilityMethods.scroll_till_an_element(driver, ele2);
		
		// scroll to end of page
		JavaScriptUtilityMethods.scroll_to_end_of_page(driver);
		
	}

}
