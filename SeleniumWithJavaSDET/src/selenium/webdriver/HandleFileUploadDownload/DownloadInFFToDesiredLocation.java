package selenium.webdriver.HandleFileUploadDownload;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadInFFToDesiredLocation {

	public static void main(String[] args) throws InterruptedException {

		// Firefox Browser-> to download file to required location - Need to set browser profile level preference
		
		// Firefox profile setup
		FirefoxProfile profile = new FirefoxProfile();
		
		// There is MIME type for every type of extension of the file
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");   // set MIME type - type of file you are downloading
		
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		
		// download file to desired location
		profile.setPreference("browser.download.dir", "C:\\Users\\user\\eclipse-workspace\\SeleniumWithJavaSDET\\FileDownLoadPath");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("pdfjs.disabled", true);  // only for PDF files
		
		// pass profile to firefox options
		FirefoxOptions opt = new FirefoxOptions();
		opt.setProfile(profile);
		
		// browser setting end 
		
		
		System.setProperty("webdriver.gecko.driver", "../SeleniumWithJavaSDET/geckodriver-v0.31.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver(opt);  // pass  opt here
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("1.txt")).click();
		
		boolean res =isFileExist("C:/Users/user/eclipse-workspace/SeleniumWithJavaSDET/FileDownLoadPath/1.txt");
		if(res) {
			System.out.println("File Exists");
		}
		else {
			System.out.println("File not exists");
		}
		
	}
	
	// method to check whether file is present or not
	static boolean isFileExist(String filePath) {
		
		File f = new File(filePath);
		
		if(f.exists()) {
			return true;
		}
		else {
			return false;
		}
	}

	}

