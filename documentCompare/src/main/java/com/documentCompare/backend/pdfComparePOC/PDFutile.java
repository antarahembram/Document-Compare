package com.documentCompare.backend.pdfComparePOC;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;
import org.testng.annotations.Test;

import java.io.IOException;

public class PDFutile {
	
	PDFUtil pdfutil=new PDFUtil();
	
	String path1 = "D:/PDFsCompareResults/Source_Letter.pdf";
	String path2 = "D:/PDFsCompareResults/Target_Letter.pdf";
	
	
	@Test
	public void comp() throws IOException {
		pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
		boolean value = pdfutil.compare(path1, path2);
		pdfutil.highlightPdfDifference(value);
		pdfutil.setImageDestinationPath("D:/PDFsCompareResults");
		System.out.println("Test pdfutil  "+ pdfutil);
		if(value) {
			System.out.println("No Differance");
		}else {
			System.out.println("It has Differance");
		}
	}
}
