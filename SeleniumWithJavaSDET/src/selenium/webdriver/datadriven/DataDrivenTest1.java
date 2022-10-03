package selenium.webdriver.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*  Read data from excel, calculate interest and compare actual maturity value with the expected maturity value.
 * 
 */

public class DataDrivenTest1 {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		driver.manage().window().maximize();
		//WebElement element = driver.findElement(By.xpath("//div[contains(text(),' In India, banks use quarterly compounding to calculate interest in rupees. ')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView()", element);
		js.executeScript("window.scrollBy(0,140)");
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		
		FileInputStream file = new FileInputStream("../SeleniumWithJavaSDET/TestData/DataFile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("InterestCalc");
		
		int row_count = sheet.getLastRowNum();
		int col_count = sheet.getRow(0).getLastCellNum();
		
		ArrayList<String> res = new ArrayList<String>();
		
		for(int i=1;i<=row_count;i++) {
			XSSFRow current_row = sheet.getRow(i);
			
			int principal = (int) current_row.getCell(0).getNumericCellValue();
			int rate_of_interest = (int)current_row.getCell(1).getNumericCellValue();
			int period = (int)current_row.getCell(2).getNumericCellValue();
			String period_unit = current_row.getCell(3).getStringCellValue();
			String frequency = current_row.getCell(4).getStringCellValue();
			double expected_maturity =(double) current_row.getCell(5).getNumericCellValue();
			
			System.out.println("principal="+principal);
			System.out.println("rate_of_interest="+rate_of_interest);
			System.out.println("period="+period);
			System.out.println("period_unit="+period_unit);
			System.out.println("frequency="+frequency);
			System.out.println("frequency="+expected_maturity);
			
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(principal));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(rate_of_interest));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(period));
			
			Select s1 = new Select(driver.findElement(By.id("tenurePeriod")));
			s1.selectByVisibleText(period_unit);
			
			Select s2 = new Select(driver.findElement(By.id("frequency")));
			s2.selectByVisibleText(frequency);
			
			driver.findElement(By.xpath("//a[@onclick='return getfdMatVal(this);']")).click();
			
			//clear
			driver.findElement(By.xpath("//a[@onclick='javascript:reset_fdcalcfrm();']")).click();
			
			String actual_maturity= driver.findElement(By.id("resp_matval")).getText().toString();
			double act_res= Double.parseDouble(actual_maturity);
			System.out.println("Actual vlaue="+act_res);
			
			
			
			if(expected_maturity==act_res) {
				System.out.println("Pass, Data row="+i);
				res.add("Pass");
			}
			else {
				System.out.println("Fail, Data row="+i);
				res.add("Fail");
			}
		}
		
		if(res.contains("Fail")) {
			System.out.println("Test Failed");
		}
		else {
			System.out.println("Test Passed");
		}
		
		driver.quit();
	}
	
	
}
