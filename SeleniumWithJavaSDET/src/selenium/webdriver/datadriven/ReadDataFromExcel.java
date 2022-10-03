package selenium.webdriver.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {

		
		FileInputStream file = new FileInputStream("../SeleniumWithJavaSDET/TestData/DataFile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");   // using sheet name
		
		// OR : XSSFSheet sheet = workbook.getSheetAt(0);  // using index
		
		int row_count = sheet.getLastRowNum();
		int col_count = sheet.getRow(0).getLastCellNum();
		
		for(int i=0; i<=row_count; i++) {
			
			XSSFRow current_row =sheet.getRow(i);
			for(int j=0;j<col_count;j++) {
				
				String cell_value= current_row.getCell(j).toString();  // generic method for all kind of values
				
				/* Based on the value in excel we can use below methods
				current_row.getCell(j).getStringCellValue();
				current_row.getCell(j).getNumericCellValue();
				current_row.getCell(j).getBooleanCellValue();
				*/
				System.out.print(cell_value+"   ");
			}
			System.out.println();
		}
		
		
	}

}
