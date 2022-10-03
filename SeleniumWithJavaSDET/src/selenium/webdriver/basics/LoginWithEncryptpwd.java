package selenium.webdriver.basics;

import java.time.Duration;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// login to using encrypted passowrd
public class LoginWithEncryptpwd {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys(encode_pwd("YWRtaW4xMjM="));
		driver.findElement(By.xpath("//button")).click();
		
	}
	
	
	public static String encode_pwd(String encoded_pwd) {
		
		byte[] decoded_pwd = Base64.decodeBase64(encoded_pwd);
		//System.out.println(decoded_pwd);
		return new String(decoded_pwd); // decode to string type and return 
	}
}
