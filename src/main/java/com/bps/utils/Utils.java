package com.bps.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date getDate(String dateStr) {
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static String getString(Date date) {
		String dateStr = "";
		try {
			dateStr = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dateStr;
	}
	
	public static int getDays(Date date1, Date date2) {
		return (int)((date1.getTime() - date2.getTime())/ 1000 / 60 / 60 / 24);
	}
}