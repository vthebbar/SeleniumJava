package selenium.webdriver.AshotAPI;

import java.awt.image.BufferedImage;
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
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

// compare screenshots using Ashot API
public class CompareScreenShots {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://vthebbar.blogspot.com/about");
		
		File f = new File("../SeleniumWithJavaSDET/Screenshots/orangeHrmlogo.png");  // file
		BufferedImage expected_image = ImageIO.read(f);  // read the file
		
				
		AShot Aobj = new AShot();  // AShot object
		Screenshot logimage_screenshot= Aobj.takeScreenshot(driver);  // capture snapshot
		
		BufferedImage actual_image=logimage_screenshot.getImage(); // get image from snapshot
		
		// class, object for image comparison
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expected_image, actual_image);
		
		if(diff.hasDiff()==true) {
			System.out.println("Images are different");
		}
		else {
			System.out.println("Images are same");
		}
	}

}
