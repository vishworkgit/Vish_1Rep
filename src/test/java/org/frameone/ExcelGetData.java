package org.frameone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelGetData {

	public static void main(String[] args) throws IOException {
		
		
		File file = new File("D:\\1Selinium\\Java\\DayOneFrameWork\\ExcelFiles\\NewWorkBook.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook work = new XSSFWorkbook(stream);
		
		Sheet sheet = work.getSheet("Login");
		
		//Row row = sheet.getRow(2);
		//Cell cell = row.getCell(0);
		//System.out.println(cell);

		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType type = cell.getCellType();
				
				switch(type) {
				case STRING:
					String sc = cell.getStringCellValue();
					System.out.println(sc);
					System.out.print(" ");
					break;
					
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dc = cell.getDateCellValue();
						SimpleDateFormat sdc = new SimpleDateFormat("dd/MMM/yy");
						String format = sdc.format(dc);
						System.out.println(format);
					}else {
						System.out.println("no data");
					}
				}
				
				
			}
		}
		
		
	}
	
	
}
