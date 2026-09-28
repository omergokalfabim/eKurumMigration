package com.uniyaz.dashboard.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyUtil {

	public static String toString(String pattern, String timestm) {

		return LocalDateTime.parse(timestm, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"))
				.format(DateTimeFormatter.ofPattern(pattern));

	}
	
	public static String toString(String pattern, Date timestm) {
		if (isNull(timestm) || isNull(pattern)) {
			return "";
		}
		return (new SimpleDateFormat(pattern)).format(timestm);
	}
	
	public static final boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return "".equals(obj.toString());
	}
	
	public static String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}
	
	 
	
	public static Date toDate(String pattern, String value) throws Exception { 
		if (value == null || value.trim().isEmpty()) {
			return null; } 
		if (pattern == null || pattern.trim().isEmpty()) { 
			throw new IllegalArgumentException("Tarih formatı boş olamaz."); 
			} SimpleDateFormat df = new SimpleDateFormat(pattern); 
			df.setLenient(false); 
			return df.parse(value); 
		}
	
}
