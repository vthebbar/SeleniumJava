package selenium.webdriver.JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilityMethods {
	
	// Method Flash a web element
	
	public static void  flash_an_elemet(WebDriver driver, WebElement element) {
		
		String original_bg_color= element.getCssValue("backgroundColor");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for(int i=0;i<500;i++) {
		js.executeScript("arguments[0].style.backgroundColor='#0000FF'", element);
		js.executeScript("arguments[0].style.backgroundColor='"+original_bg_color+"'", element);

		}
	}
	
	// Method to draw border around an element
	
	public static void draw_border(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '4px solid red'", element);
	}
	
	
	// method to capture page title using JS
	
	public static String get_page_title_by_js(WebDriver driver) {
		
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title", "").toString();
		return title;
	}
	
	// Method to generate alert using Js
	
	public static void generate_alert(WebDriver driver, String message) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')", "");
		
	}
	
	// method to refresh the page
	
	public static void page_referesh_by_js(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)", "");
	}
	
	// method scroll page till an element
		
	public static void scroll_till_an_element(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		
	}
	
	// method to scroll an element till end of page
	
	public static void scroll_to_end_of_page(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}
}
