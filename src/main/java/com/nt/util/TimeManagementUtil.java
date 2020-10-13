package com.nt.util;

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

}
