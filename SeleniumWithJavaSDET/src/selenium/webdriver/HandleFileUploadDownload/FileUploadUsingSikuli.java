package selenium.webdriver.HandleFileUploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

// File upload - handling window based pop up using sikuli
public class FileUploadUsingSikuli {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.guru99.com/test/upload");
		
		WebElement ele = driver.findElement(By.id("uploadfile_0"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		
		Thread.sleep(4000);
		
		
		Screen s = new Screen();
		
		Pattern upload_file_path = new Pattern("../SeleniumWithJavaSDET/Sikuli/Reference Image Files/Upload file path.png");
		Pattern open_button = new Pattern("../SeleniumWithJavaSDET/Sikuli/Reference Image Files/open button.png");
		
		s.wait(upload_file_path,20);
		s.type(upload_file_path, "C:\\Users\\user\\eclipse-workspace\\SeleniumWithJavaSDET\\Sikuli\\Upload File\\Test.txt");
		s.click(open_button);
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		
		System.out.println(driver.getPageSource().contains("has been successfully uploaded"));
	}

}
