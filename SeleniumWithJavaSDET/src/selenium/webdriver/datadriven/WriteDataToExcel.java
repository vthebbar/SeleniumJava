package selenium.webdriver.datadriven;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

//Write Data to Excel
public class WriteDataToExcel {

	public static void main(String[] args) throws IOException {
		
		
		FileOutputStream file = new FileOutputStream("../SeleniumWithJavaSDET/TestData/WriteFile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("WriteSheet");
		
		for(int i=0;i<5;i++) {
			
			XSSFRow row = sheet.createRow(i);
			
			for(int j=0; j<=5;j++) {
				
				row.createCell(j).setCellValue(i+","+j);
			}
		}
		
		workbook.write(file);
		file.close();
		System.out.println("Write to excel completed");
	}	

}
