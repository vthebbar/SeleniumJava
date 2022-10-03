package selenium.webdriver.webtables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	// Read data from web table
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		int number_of_rows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		System.out.println("Number of rows="+number_of_rows);
		
		int numbe_of_columns=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th")).size();
		System.out.println("Number of columns="+ numbe_of_columns);
		
		// table Header
		System.out.println("Company       Contact          Country");
		// print data in table
		
		//table[@id='customers']/tbody/tr[2]/td[1]
		
		String before_xpath="//table[@id='customers']/tbody/tr[";
		String after_xpath= "]/td[";
		
		boolean flag=false;
		
		for(int i=2;i<=number_of_rows;i++) {
			
			for(int j=1; j<=numbe_of_columns; j++)
			{
				String data = driver.findElement(By.xpath(before_xpath+i+after_xpath+j+"]")).getText().toString();
				System.out.print(data+"       ");
				
				if(data.equals("UK") && j==3) {  // check if "UK" is present in Country column
					flag=true;
					System.out.println();
					System.out.println("UK is present at row="+i+", column="+j);
					break; // break inner loop
				}
			}
			System.out.println();
			if(flag) {
				break;  // break outer loop
			}
		}
		
		if(flag==false) {
			System.out.println("UK is NOT present");
		}
		driver.close();
	}

}
