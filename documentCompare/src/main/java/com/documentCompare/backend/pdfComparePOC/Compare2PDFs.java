package com.documentCompare.backend.pdfComparePOC;

import de.redsix.pdfcompare.PdfComparator;

import java.io.IOException;


// Unit test for simple App.


public class Compare2PDFs {
	
	public Boolean ComparePDF(String exp, String act, String resultFile) throws IOException {
		boolean isEquals = false;
		//For convenience, writeTo also returns the equals status:
    	isEquals = new PdfComparator(exp, act).compare().writeTo(resultFile);
    	
    	if (!isEquals) {
    	    System.out.println("Differences found!");
    	}
    	return isEquals;
	}

	


/**  *******************************************************************************************
public class Compare2PDFs {
	
	CompareResultWithPageOverflow obj=new CompareResultWithPageOverflow();
	
	public Boolean ComparePDF(String exp, String act, String resultFile) throws IOException {
		//For convenience, writeTo also returns the equals status:
    	boolean isEquals = new PdfComparator(exp, act).compare().writeTo(resultFile);
    	
    	if (!isEquals) {
    	    System.out.println("Differences found!");
    	}
    	return isEquals;
	}

	protected boolean needToSwap() {
		// TODO Auto-generated method stub
		return false;
	}

*******************************************************************************************
*/  
	
}