package com.nt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeManagementUtil {
	public static String getShiftTime(int time) {
		String shiftTime=null;
		

	        if(time>=6 && time<=14){
	        	shiftTime="Morning";
	        }
	            
	        else if(time>=14 &&  time<=22){
	        	shiftTime="Afternoon";
	        
	        
	        }else if(time>=22 &&  time<=6){
	        	shiftTime="Night";
	        }
	        
	        return shiftTime;
	}
	public static Date stringToDate(String date) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date+"\t"+date1); 
		
		return date1;
	}

}
