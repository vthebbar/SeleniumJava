package selenium.webdriver.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {

		// isDisplayed(), isEnabled(), isSelected()  -. returns true or false
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		System.out.println(checkbox1.isDisplayed() +" "+ checkbox1.isEnabled() +" "+ checkbox1.isSelected());
		System.out.println(checkbox2.isDisplayed() +" "+ checkbox2.isEnabled() +" "+ checkbox2.isSelected());
		
		
		
		if(checkbox1.isDisplayed() && !checkbox1.isSelected() && checkbox1.isEnabled())
		{
			checkbox1.click();
		}
		
		if(checkbox2.isDisplayed() && !checkbox2.isSelected())
		{
			checkbox2.click();
		}
		
		driver.quit();
	}

}
