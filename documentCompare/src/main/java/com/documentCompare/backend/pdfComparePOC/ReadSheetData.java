package com.documentCompare.backend.pdfComparePOC;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class ReadSheetData {
	
	// ************************ IT is inprogress*****************************
	// ********************************************************************
	
	String Filepath = "D:\\JavaWorkSpaceV1\\POC\\src\\test\\java\\testResource\\Driver_Test.xlsx";
	String savedFile = "D:\\JavaWorkSpaceV1\\POC\\src\\test\\java\\testResource\\Driver_Test1.xlsx";
	FileInputStream file; 
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
//	ArrayList<String> arrayLitFilepath = new ArrayList<>(Arrays.asList("FilePath 1" , "FilePath 2", "FilePath 3"));
	String[] filePatharray= {"FilePath 1" , "FilePath 2", "FilePath 3","FilePath 4", "FilePath 5"};
	
	@Test
	public void writeData() throws IOException {
		try {
			file = new FileInputStream(new File(Filepath));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			int rownub = sheet.getLastRowNum();
			Cell cell= null;
//			int arraySize = arrayLitFilepath.size();
//			int arraryLength = filePatharray.length;
			System.out.println("Lasr Row number " + rownub);
			for(int i=1; i<=rownub; i++)
			{
				for(int j=i; j<=sheet.getRow(i).getLastCellNum(); j++ ) {
					cell = sheet.getRow(i).getCell(j);
					cell.setCellValue(setingValue(i));
				}
			}		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
         e.printStackTrace();
     }
		
	file.close();
	
	FileOutputStream output = new FileOutputStream (new File(savedFile));
	}
	
	public String setingValue(int arr ) {
		String value = filePatharray[arr-1];
		return value;
	}
	
}
