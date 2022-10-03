package selenium.webdriver.webtables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// This is not traditional web table with tr, td tags
public class WebTableHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		driver.findElement(By.xpath("//span[text()='User Management ']")).click();
		
		driver.findElement(By.xpath("//a[text()='Users']")).click();
		
		
		// Select particular check box based on the employee name
		
		driver.findElement(By.xpath("//div[text()='Alice.Duval']//parent::div//preceding-sibling::div//i")).click();
		
		// find total enables users
		
		int total_enabled = driver.findElements(By.xpath("//div[text()='Enabled']")).size();
		System.out.println("Total enabled users="+ total_enabled);
		
		driver.close();
	}

}
