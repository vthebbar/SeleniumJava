package selenium.webdriver.HandleFileUploadDownload;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


// File download in chrome browser
public class FileDownloadInChrome {

	public static void main(String[] args) throws InterruptedException {
		
		// to download file to required location - Need to set browser profile level preference
		HashMap<String, Object> chromePref = new HashMap<String, Object>();
		chromePref.put("profile.default_content_settings.popups", 0);
		chromePref.put("download.prompt_for_download", "false");
		chromePref.put("download.default_directory", "C:\\Users\\user\\eclipse-workspace\\SeleniumWithJavaSDET\\FileDownLoadPath");
		// note - use backward slash for browser
		
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("prefs", chromePref);
		
		DesiredCapabilities dCap =  new DesiredCapabilities();
		dCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dCap.setCapability(ChromeOptions.CAPABILITY, opt);
		
		// browser setting end 
		
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver(opt);  // pass dCap , opt here
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
