package selenium.webdriver.RobotAPI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Keyboard even handling using Robot API
public class RobotAPIDemo {

	public static void main(String[] args) throws AWTException {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/key_presses?");
		
		driver.findElement(By.id("target")).click();
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_LEFT);
		
		String res = driver.findElement(By.id("result")).getText();
		System.out.println(res);
		
		robot.keyPress(KeyEvent.VK_RIGHT);
		res=driver.findElement(By.id("result")).getText();
		System.out.println(res);
		
		
		robot.keyPress(KeyEvent.VK_DOWN);
		res=driver.findElement(By.id("result")).getText();
		System.out.println(res);
		
		robot.keyPress(KeyEvent.VK_UP);
		res=driver.findElement(By.id("result")).getText();
		System.out.println(res);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		res=driver.findElement(By.id("result")).getText();
		System.out.println(res);
		
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		res=driver.findElement(By.id("result")).getText();
		System.out.println(res);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		res=driver.findElement(By.id("result")).getText();
		System.out.println(res);
		
		}

}
