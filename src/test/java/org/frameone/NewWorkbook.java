package org.frameone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewWorkbook {
	
	public static void main(String[] args) throws IOException {
		
		File file =new File("D:\\1Selinium\\Java\\DayOneFrameWork\\ExcelFiles\\creatshet.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("CRTSSheet");
				
//		Row row = sheet.createRow(0);
//		Cell cell= row.createCell(0);
//		Cell cell1 = row.createCell(1);
//		cell.setCellValue("Try1");
//		cell1.setCellValue("Success");
		
		
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		if(value.equals("Try1")) {  // Check cell 
			cell.setCellValue("Try2"); // Insert value
		}

		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

}
