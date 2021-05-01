package com.documentCompare.backend.pdfComparePOC;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WritingDataInToXLSX {
	
//	*******************************In complete Script**************
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row rowdata;
	Cell cellData;
	
	String file = "D:\\JavaWorkSpaceV1\\POC\\src\\test\\java\\testResource\\Driver.xlsx";
	
	public void addingPDFpath() throws FileNotFoundException {
		
		FileInputStream fl= new FileInputStream(new File(file));
		
	} 
	

}
