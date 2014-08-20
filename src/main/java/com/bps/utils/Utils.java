package com.bps.utils;

import java.text.SimpleDateFormat;
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
}