package com.documentCompare.backend.pdfComparePOC;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadAndWriteExcelFile { // *************** IT is Not Using *************** 
	
	DataFormatter formate=new DataFormatter();
	DateAndTime timeStamp=new DateAndTime();
	Compare2PDFs comp=new Compare2PDFs();
	String rePath="C:\\Users\\RUSHI\\Desktop\\Selinum Learing\\PDF compare\\Set1PDFs\\results\\";
	
//	LinkedHashMap<Integer, List<String>> sheetData= new LinkedHashMap<Integer, List<String>>();
	

	FileInputStream f;	
	XSSFWorkbook wb ;
	XSSFSheet sh;
	XSSFRow r;
	XSSFCell c;
	
	@Test
	public void test() throws IOException {
		f=new FileInputStream(ReadingSheetData.file);
		wb = new XSSFWorkbook(f);
		sh=wb.getSheet("App_Location");
//		capturing the last row from the sheet
		int lastRownum=sh.getLastRowNum();
		
		System.out.println("lastRownum: "+lastRownum);

	}
	
	public Iterator<Row> retriveingHeaders() throws IOException {
	
		f=new FileInputStream(ReadingSheetData.file);
		wb = new XSSFWorkbook(f);
		sh=wb.getSheet("App_Location");
		
		
		Iterator<Row> IterRowData= sh.iterator();
		while(IterRowData.hasNext()) {
			Row row=IterRowData.next();
			
			row.getLastCellNum();
			if(row.getRowNum()==1) {
				
			}
			
		}
				
		
		return IterRowData;
	}

}
