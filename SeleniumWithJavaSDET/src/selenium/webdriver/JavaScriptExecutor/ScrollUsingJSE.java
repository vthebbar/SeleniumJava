package selenium.webdriver.JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Scroll page using java script executor
/* 1. scroll by pixel
 *  2. Scroll till particular element
 *  3. Scroll till end of page
 */
public class ScrollUsingJSE {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nationsonline.org/oneworld/countries_of_the_world.htm");
		
		// type cast driver to JS
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//1. scroll by pixel value
		js.executeScript("window.scrollBy(0, 2500)", "");
		
		Thread.sleep(4000);
		
		WebElement element=driver.findElement(By.linkText("India"));
		
		// 2. scroll till element
		js.executeScript("arguments[0].scrollIntoView()", element);
		Thread.sleep(4000);
		
		// 3. scroll till bottom of page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(4000);
		
	}

}
