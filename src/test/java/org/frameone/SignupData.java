package org.frameone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SignupData {

	public static void main(String[] args) throws IOException {
		
		File file = new File("D:\\1Selinium\\Java\\DayOneFrameWork\\ExcelFiles\\SignupDataa.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook work = new XSSFWorkbook(stream);
		
		Sheet sheet= work.getSheet("Signup");
		for(int i=0; i<sheet.getPhysicalNumberOfRows();i++) {
			
			Row row = sheet.getRow(i);
			
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
    			Cell cell = row.getCell(j);
//				System.out.print(cell);
//				System.out.print("     ");
    			CellType type = cell.getCellType();	
    			
    			switch(type) {
    			
    			case STRING:
    				String stringvalues = cell.getStringCellValue();
    				System.out.print(stringvalues);
    				System.out.print("  ");
    				break;
    				
    			case NUMERIC:
    				if(DateUtil.isCellDateFormatted(cell)) {
    					Date datesValues = cell.getDateCellValue();
    					SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
    					String datestring = dateformat.format(datesValues);
    					System.out.println(datestring);
    					System.out.print("  ");
    					
    					
    				   }else {
    					double doublenum = cell.getNumericCellValue();
    					long check = Math.round(doublenum);
    					
    					if(doublenum == check) {
    						String stringnum = String.valueOf(check);
    						System.out.println(stringnum);
    					}
    					else {
    						String stringnum = String.valueOf(doublenum);
    						System.out.println(stringnum);
    					}
    					System.out.print("  ");
    				}
    				break;
    			default:
    				break;
    			}
			}
			System.out.println();
			System.out.println("*******************************************");
			
		}
		
		
		
	}
	
}
