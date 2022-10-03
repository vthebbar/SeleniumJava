package selenium.webdriver.calendars;

import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "../SeleniumWithJavaSDET/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,120)");
		
		driver.findElement(By.id("first_date_picker")).click();
		
		String expected_date="31-December-2022";
		
		String[] al =  expected_date.split("-");
		
		String expected_day=al[0];
		String expected_month=al[1];
		String expected_year=al[2];
		
		if(Integer.valueOf(expected_day)>31) {
			System.out.println("Invalid date");
			
			return;
		}
		
		if(expected_month.equals("Feburary") && Integer.valueOf(expected_year)%4 !=0) {
			if(Integer.valueOf(expected_day)>28) {
				System.out.println("Invalid date");
				return;
			}
		}
		
		if(expected_month.equals("Feburary") && Integer.valueOf(expected_year)%4 ==0) {
			if(Integer.valueOf(expected_day)>29) {
				System.out.println("Invalid date");
				return;
			}
		}
		
		if(expected_month.equals("January")||expected_month.equals("March")||expected_month.equals("May")
			||expected_month.equals("July")||expected_month.equals("August")||expected_month.equals("October")||
			expected_month.equals("December"))
		{
			if(Integer.valueOf(expected_day)>31) {
				System.out.println("Invalid date");
				return;
			}
		}
		
		if(expected_month.equals("April")||expected_month.equals("June")||expected_month.equals("September")||
				expected_month.equals("November")) {
			if(Integer.valueOf(expected_day)>30) {
				System.out.println("Invalid date");
				return;
			}
		}
		
		String actual_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		String actual_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		
		
		
		int expected_year_val = Integer.valueOf(expected_year);
		int actual_year_val = Integer.valueOf(actual_year);
		
		int expected_month_val = get_month_val(expected_month);
		int actual_month_val = get_month_val(actual_month);
		
		
		
		while(expected_year_val != actual_year_val) {
			
			if(expected_year_val>actual_year_val)
			 {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				actual_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				actual_year_val = Integer.valueOf(actual_year);
			 }
			
			 if(expected_year_val<actual_year_val) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				actual_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				actual_year_val = Integer.valueOf(actual_year);
			   }
		}
		
		while(expected_year_val == actual_year_val && expected_month_val != actual_month_val) {
			if(get_month_val(expected_month)>get_month_val(actual_month)) {
				
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				actual_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				 actual_month_val = get_month_val(actual_month);
			}
			
		
			if(get_month_val(expected_month)<get_month_val(actual_month)) {
				
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				actual_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				 actual_month_val = get_month_val(actual_month);
			}
			
		}
		
		if(expected_month.equals(actual_month) && expected_year.equals(actual_year)) {
		
			// Number of rows in calendar table
		int number_of_rows=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr")).size();
		
		// Number of columns in calendar table
		int number_of_columns=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[1]/td")).size();
		
		String before_xpath="//table[@class='ui-datepicker-calendar']/tbody/tr[";
		String after_xpath="]/td[";
		boolean date_flag=false;
		for(int i=1;i<=number_of_rows;i++) {
			for(int j=1;j<=number_of_columns;j++)
			{
				String actual_day=driver.findElement(By.xpath(before_xpath+i+after_xpath+j+"]")).getText().toString();
				try {
				if(actual_day.equals(expected_day)) {
					date_flag=true;
					driver.findElement(By.xpath(before_xpath+i+after_xpath+j+"]")).click();
					break;
				}
				}
				catch(Exception e){
					System.out.println("Invalid date");
					e.printStackTrace();
				}
			}
			
			if(date_flag) {
				break;
			}
		}	
		
		
		}
	}
	
	public static int get_month_val(String month_name) {
		String upper_month_name = month_name.toUpperCase();
		int flag=0;
		switch(upper_month_name)
		{
		case "JANUARY":
			flag = 1;
			break;
		
		case "FEBRUARY":
			flag = 2;
			break;
		
		case "MARCH":
			flag = 3;
			break;
		
		case "APRIL":
			flag = 4;
			break;
		case "MAY":
			flag = 5;
			break;
		case "JUNE":
			flag = 6;
			break;
		case "JULY":
			flag = 7;
			break;
		case "AUGUST":
			flag = 8;
			break;
		case "SEPTEMBER":
			flag = 9;
			break;
		case "OCTOBER":
			flag = 10;
			break;
		case "NOVEMBER":
			flag = 11;
			break;
		case "DECEMBER":
			flag = 12;
			break;
		default:
			System.out.println("....");
		}
		
		return flag;
	}
}
