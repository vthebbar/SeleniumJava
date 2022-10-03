package selenium.webdriver.basics;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadLessHtmlUnitDriver {

	public static void main(String[] args) {

		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("https://google.com");
		System.out.println("Page Title="+ driver.getTitle());
		System.out.println("Current URL="+ driver.getCurrentUrl());
		
		//driver.close(); - Required in head less mode ?
	}

}
