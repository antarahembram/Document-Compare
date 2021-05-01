package com.documentCompare.backend.pdfComparePOC;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateAndTime {
	
//	Capturing the Current Date & Time 
	public String capturingCurrentDateTime()	{
		
		DateTimeFormatter dfr = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		LocalDateTime now =LocalDateTime.now();
		String dateAndTime=dfr.format(now);
		String[] dateTime=dateAndTime.split(" ");
					
		String currentDate=spliting(dateTime[0], "/");
		String CurrentTime=spliting(dateTime[1], ":");
		
		String dt= currentDate+CurrentTime;
		
//		System.out.println("Current data and time: "+dt);
		
		return dt;
	}
	
	public static String spliting(String data, String c) {
		
		String val = null;
		String temp = "";
		String[] splitData =data.split(c);
		for(int i=0; i<splitData.length; i++) {
			temp=temp+splitData[i];	
		}
		val=temp;
		
		return val;
		
	}

}
