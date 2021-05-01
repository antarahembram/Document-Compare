package com.documentCompare.backend.pdfComparePOC;

import java.io.File;


public class CaptureListOfFileNames {
	
	public static void main(String[] args) {
		
		File file= new File("F:\\Rushi Pesonal Data\\Finance\\Investments_2019-2020");
		String[] listOFFiles=file.list(); // Capturing the list of filenames in the array
		
		//display file name
		for(String name :listOFFiles){
			
			System.out.println(name);
		}
		int arraylength=listOFFiles.length;
		
		// display array length 
		System.out.println(arraylength);
		
	}

}
