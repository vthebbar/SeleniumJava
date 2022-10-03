package selenium.webdriver.basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Find broken links on a web page
public class FindBrokenLinks {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		int total_links = links.size();
		System.out.println("Totl links="+total_links);
		
		for(WebElement e: links) {
			
			String link = e.getAttribute("href");
			
			// create object of URL by passing link/href
			URL url = new URL(link);
			
			// create connection object
			HttpURLConnection httpConn =(HttpURLConnection) url.openConnection();
			
			// Establish connection
			httpConn.connect();
			
			// Get response code
			int response_code = httpConn.getResponseCode();
			
			//validate response code
			if(response_code>=400) {
				System.out.println("Resposne code="+response_code+"  Link is broken => "+ link);
			}
			
			else {
				System.out.println("Resposne code="+response_code+"  Link is NOT broken => "+ link);
			}
		}
		
		driver.close();
	}

}
