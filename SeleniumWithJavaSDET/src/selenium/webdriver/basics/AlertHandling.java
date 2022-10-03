package selenium.webdriver.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Handle alerts
public class AlertHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		// 1st alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		String result = driver.findElement(By.id("result")).getText();
		System.out.println("Result="+result);
		
		//2nd alert
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		String result2 = driver.findElement(By.id("result")).getText();
		System.out.println("Result="+result2);
		
		//3rd alert
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert3 = driver.switchTo().alert();
		//System.out.println(alert3.getText());
		alert3.sendKeys("Hello");
		alert3.accept();
		String result3 = driver.findElement(By.id("result")).getText();
		System.out.println("Result"+result3);
		
		
		driver.close();
	}

}
