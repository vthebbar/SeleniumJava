package selenium.webdriver.HandleFileUploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownloadInFirefox {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "../SeleniumWithJavaSDET/geckodriver-v0.31.0-win64/geckodriver.exe");
		
		// Firefox profile setup
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk", "text/plain");   // set MIME type - type of file you are downloading
		profile.setPreference("browser.download.manager.showWhenStarting", false);

		// pass profile to firefox options
		FirefoxOptions opt = new FirefoxOptions();
		opt.setProfile(profile);
		
		WebDriver driver = new FirefoxDriver(opt);
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("not_empty.txt")).click();
		
		
	}

}
