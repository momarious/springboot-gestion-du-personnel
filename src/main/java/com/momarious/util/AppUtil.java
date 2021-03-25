package com.momarious.util;


import java.util.Date;

public class AppUtil {

	public static String getDateTimeFr(Date date) {
		int day = DateUtil.getDayFromDate(date);
		int moisCode = DateUtil.getMoisFromDate(date);
		String month = DateUtil.getMoisLibelle(moisCode);
		String year = DateUtil.getYearFromDate(date);
		String time = DateUtil.getTimeNow(date);
		
		String stringDay = "" + day;
		if (day<10) {
			stringDay = "0" + day;
		}
		
		String stringMonth = "" + moisCode;
		if (moisCode<10) {
			stringMonth = "0" + moisCode;
		}
		
		return stringDay + "/" + stringMonth + "/" + year + " " + time;
	}
	
	public static String getDateFr(Date date) {
		int day = DateUtil.getDayFromDate(date);
		int moisCode = DateUtil.getMoisFromDate(date);
		String month = DateUtil.getMoisLibelle(moisCode);
		String year = DateUtil.getYearFromDate(date);
		String time = DateUtil.getTimeNow(date);
		
		String stringDay = "" + day;
		if (day<10) {
			stringDay = "0" + day;
		}
		
		String stringMonth = "" + moisCode;
		if (moisCode<10) {
			stringMonth = "0" + moisCode;
		}
		
		return stringDay + " " + month + " " + year;
	}
	
	public static String getDateUs(Date date) {
		int day = DateUtil.getDayFromDate(date);
		int moisCode = DateUtil.getMoisFromDate(date);
		String month = DateUtil.getMoisLibelle(moisCode);
		String year = DateUtil.getYearFromDate(date);
		String time = DateUtil.getTimeNow(date);
		
		String stringDay = "" + day;
		if (day<10) {
			stringDay = "0" + day;
		}
		
		String stringMonth = "" + moisCode;
		if (moisCode<10) {
			stringMonth = "0" + moisCode;
		}
		
		return stringMonth + "/" + stringDay + "/" + year;
	}
	
	public static int intOf(String value) {
		return Integer.parseInt(value);
	}
	
}
