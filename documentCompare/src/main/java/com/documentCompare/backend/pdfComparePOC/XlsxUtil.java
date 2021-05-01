package com.documentCompare.backend.pdfComparePOC;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XlsxUtil {
	
	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	static DataFormatter format = new DataFormatter();

	public static Object[][] getTestData(String testDataFilePath, String sheetname) throws IOException{
    		
		file = new FileInputStream(testDataFilePath);			
		workbook=new XSSFWorkbook(file);
		
		sheet =workbook.getSheet(sheetname);
		
		Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
	
//		 	System.out.println(sheet.getLastRowNum() + "........."+ sheet.getRow(0).getLastCellNum());
	 
		for(int i=0; i < sheet.getLastRowNum(); i++){
			for(int k=0; k < sheet.getRow(0).getLastCellNum(); k++){
				
				Cell cell = sheet.getRow(i+1).getCell(k);
				data[i][k]=format.formatCellValue(cell);
//				data[i][k]= sheet.getRow(i +1).getCell(k).toString();
				 System.out.println("loop data"+data[i][k]);
		   }
		}
	return data;
  }
}
