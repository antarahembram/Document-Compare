package com.documentCompare.backend.pdfComparePOC;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@Test
public class ReadingSheetData { // *************** IT id Not Using *************** 
	
	
	DataFormatter formate=new DataFormatter();
	DateAndTime timeStamp=new DateAndTime();
	Compare2PDFs comp=new Compare2PDFs();
	String rePath="C:\\Users\\RUSHI\\Desktop\\Selinum Learing\\PDF compare\\Set1PDFs\\results\\";
	
	LinkedHashMap<Integer, List<String>> sheetData= new LinkedHashMap<Integer, List<String>>();
	
	static String file = "C:\\Users\\RUSHI\\Desktop\\Selinum Learing\\PDF compare\\Set1PDFs\\Driver.xlsx"; 
	FileInputStream f;	
	XSSFWorkbook wb ;
	XSSFSheet sh;
//	XSSFRow r;
//	XSSFCell c;
		
	public void captureSheetDataToLinkedHasMap() throws IOException {
		
		
		f=new FileInputStream(ReadingSheetData.file);
		wb = new XSSFWorkbook(f);
		sh=wb.getSheet("App_Location");
		
		Iterator<Row> itrRow=sh.iterator();
		while(itrRow.hasNext()) {
			Row sheetRow=itrRow.next();
			int rowNum=sheetRow.getRowNum();
//			Capturing each cell data of the current row
			Iterator<Cell> itrCell=sheetRow.iterator();
			LinkedList<String> rowData = new LinkedList<String>();
			while(itrCell.hasNext()) {
				Cell colCell=itrCell.next();
				rowData.add(formate.formatCellValue(colCell)); 
			}
			sheetData.put(rowNum, rowData);
			System.out.println("Map data: "+ sheetData);
//			To capturing the expected and actual file path
			if(rowNum !=0 ) {
				
				String ts=timeStamp.capturingCurrentDateTime();
				String resultPath=rePath+ts;
				
				Boolean st=comp.ComparePDF(rowData.get(1), rowData.get(2), resultPath);
				
//				System.out.println("Status: "+st);
//				System.out.println("Time Stam is :::"+resultPath);
			}	
			
		}
	}
	
	
	
	
	/*
	public void readlinkedHasMapData() {
		
		for(Entry<Integer, List<String>> ent:sheetData.entrySet()) {
			
			System.out.println(ent.getKey()+" --"+ent.getValue());
			
			
		}
	} */



}
