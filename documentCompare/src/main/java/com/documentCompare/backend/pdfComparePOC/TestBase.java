package com.documentCompare.backend.pdfComparePOC;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestBase {
//	String resultLocation="C:\\Users\\RUSHI\\Desktop\\Selinum Learing\\PDF compare\\Set1PDFs\\results\\";
	String resultLocation="C:\\Users\\Antara Hembram\\Desktop\\document-compare\\src\\assets\\Results\\";
	String resultLocation2="../Results/";
//	String driverFile="D:\\JavaWorkSpaceV1\\POC\\src\\test\\java\\testResource\\Driver.xlsx";
	String driverFile="C:\\Users\\Antara Hembram\\Desktop\\Driver - Copy.xlsx";
	String sheetname= "App_Location";
//	String sheetname="Sheet1";
	DateAndTime timeStamp=new DateAndTime();
	Compare2PDFs compare=new Compare2PDFs();
	XlsxUtil obj=new XlsxUtil();
	
	ExtentHtmlReporter htmlReporter; 
	ExtentReports extent; 
	
	@BeforeSuite
	public void startExtendReports() {
		
		htmlReporter=new ExtentHtmlReporter("../document-compare/src/assets/ExtentReport/extent.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@DataProvider
	public Object[][] getTwoDymansionObjectArrayData() throws IOException{
		Object data[][] = XlsxUtil.getTestData(driverFile, sheetname);
//		Object data[][]=obj.getTestData(sheetname);
//		Object data[][] = XlsxUtil.getTestData(sheetname);
		return data;
	}


	@Test(dataProvider = "getTwoDymansionObjectArrayData")
	public void testPdfCompare(String exp, String act) throws IOException{

		ExtentTest logger=extent.createTest("testPdfCompare");

		System.out.println("Row data: " + exp +" "+ act);

		String dateAndTime=timeStamp.capturingCurrentDateTime();
		String resultFile=resultLocation+dateAndTime;
		String resultFile2=resultLocation2+dateAndTime;//added by Antara
//			comparing the PDFs
			Boolean status=compare.ComparePDF(exp, act, resultFile);

//			System.out.println("Status is "+Status);

			if(status) {
				//enable for comparePDF method
				logger.log(Status.PASS, "No difference in the PDF");
			}else {
//				logger.log(Status.FAIL, "difference found in the PDF");
				 //reporting to failed case and adding difference pdf a link in to extend report
				 final ExtentLink link = new ExtentLink();
				 link.setLinkText("difference found in the PDF");
				 link.setLinkUrl(resultFile2+".pdf");
				 logger.log(Status.FAIL, link);
			}
	}

	@AfterSuite
	public void close() {
        // Flush method will write the test in report
    extent.flush();
	}
	

}
