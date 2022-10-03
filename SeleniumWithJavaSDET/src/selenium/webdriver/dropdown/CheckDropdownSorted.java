package selenium.webdriver.dropdown;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// verify whether drop down option are sorted
public class CheckDropdownSorted {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement element = driver.findElement(By.xpath("//select[@id='animals']"));
		
		Select opt = new Select(element);
		List<WebElement> all_options=opt.getOptions();
		
		ArrayList<String> original_list = new ArrayList<String>();
		ArrayList<String> temp_list = new ArrayList<String>();
		
		for(WebElement e : all_options) {
			original_list.add(e.getText());
			temp_list.add(e.getText());
		}
		
		System.out.println("Original List="+original_list);
		Collections.sort(temp_list);
		System.out.println("Sorted list="+ temp_list);
		
		if(original_list.equals(temp_list)) {
			System.out.println("Dropdown List is sorted");
		}
		else {
			System.out.println("Dropdown List is NOT sorted");

		}
	}

}
