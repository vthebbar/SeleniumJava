package selenium.webdriver.AshotAPI;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

// capture screenshot using Ashot API
public class ScreenshotUsingAshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://vthebbar.blogspot.com/about");
		
		//WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		
		AShot Aobj = new AShot();  // AShot object
		Screenshot logimage_screenshot= Aobj.takeScreenshot(driver);  // capture snapshot
		
		// save screenshot to file
		File f = new File("../SeleniumWithJavaSDET/Screenshots/orangeHrmlogo.png");  // create file
		ImageIO.write(logimage_screenshot.getImage(), "png", f);    // write to file
		
		
		if(f.exists()) {
			System.out.println("Snapshot saved");
		}
		else {
			System.out.println("Snapshot NOT saved");
		}
		
	}

}
