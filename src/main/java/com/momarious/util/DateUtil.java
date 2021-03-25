package com.momarious.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Date Utility Class Conversion de date en string
 *  
 */
public class DateUtil {

	public static final String datePattern = "dd/MM/yyyy";
	
	public static final String DATE_FORMAT_US = "MM/dd/yyyy";
	
	public static final String DATE_FORMAT_ISO = "yyyy-MM-dd";
	
	private static final String timePattern = "HH:mm";

	
	private static long CONST_DURATION_OF_DAY = 1000l * 60 * 60 * 24;

	//private static DataSource ds = null;

	//  Months NBR
	public static final int[] MONTHS_NBR = { 31, 28, 31, 30, 31, 30, 31, 31,
			30, 31, 30, 31 };

	/**
	 * Return default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	public static String convertDateToZosFormat(String aMask, String strDate ){
		Date df = DateUtil.convertStringToDate(aMask,strDate);
		return DateUtil.getDateTime(DateUtil.DATE_FORMAT_ISO,df);
		
	}
	public static String convertDateUS2ISO(String strDate ){
		Date df = DateUtil.convertStringToDate(DateUtil.DATE_FORMAT_US,strDate);
		return DateUtil.getDateTime(DateUtil.DATE_FORMAT_ISO,df);
		
	}
	public static String convertDateFR2ISO(String strDate ){
		Date df = DateUtil.convertStringToDate(DateUtil.datePattern,strDate);
		return  DateUtil.getDateTime(DateUtil.DATE_FORMAT_ISO,df);
		
	}
	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(java.sql.Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(new Date(aDate.getTime()));
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate) {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);


		if ("".compareTo(strDate) == 0) {
			return date;
		}

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			
		}

		return (date);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static final String formatDate(String aMask, Date date) {
		SimpleDateFormat df = null;
		df = new SimpleDateFormat(aMask);

		return df.format(date);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateHeure(Date date) {
		if (date != null) {
			return (getDateTime(datePattern, date) + " : " + getDateTime(
					timePattern, date));
		} else {
			return "";
		}

	}

	/**
	 * 
	 * @param mois_code
	 * @return
	 */
	public static String getMoisLibelle(int moisCode) {
		String[] tab = { "Janvier", "F�vrier", "Mars", "Avril", "Mai", "Juin",
				"Juillet", "Ao�t", "Septembre", "Octobre", "Novembre",
				"D�cembre" };

		if (moisCode > 0) {
			return tab[moisCode - 1];
		} else {
			return "mois vide";
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getYearFromDate(Date date) {
		if (date != null) {
			return DateUtil.formatDate("dd/MM/yyyy", date).substring(6, 10);
		}

		return "";
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getMoisAnneeFromDate(Date date) {
		if (date != null) {
			return DateUtil.formatDate("dd/MM/yyyy", date).substring(3, 10);
		}

		return "";
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static int getMoisFromDate(Date date) {
		int mois;
		Integer moisInteger = Integer.valueOf(DateUtil.formatDate("dd/MM/yyyy",
				date).substring(3, 5));
		mois = moisInteger.intValue();

		return mois;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayFromDate(Date date) {
		int day;
		Integer dayInteger = Integer.valueOf(DateUtil
				.formatDate("dd/MM/yyyy", date).substring(0, 2));
		day = dayInteger.intValue();

		return day;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getAnnee(Date date) {
		if (date != null) {
			return (getDateTime("dd/MM/yyyy", date).substring(6, 10));
		} else {
			return "";
		}

	}

	/**
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public static int getNbreDaysofMonth(int month, int year) {
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month == 1) {
			if ((year % 4) == 0) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return months[month];
		}

	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		java.util.Date today = new java.util.Date();
		SimpleDateFormat df = new SimpleDateFormat(datePattern);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(datePattern, aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format dd/MM/yyyy)
	 * @return a date object
	 * 
	 * @throws ParseException
	 */
	public static java.util.Date convertStringToDate(String strDate) {
		Date aDate = null;

//		if (log.isDebugEnabled()) {
//			log.debug("converting date with pattern: " + datePattern);
//		}

		aDate = convertStringToDate(datePattern, strDate);

		return aDate;
	}

	/**
	 * isDate
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isDate(String strDate) {
		SimpleDateFormat df = null;
		df = new SimpleDateFormat(datePattern);

		if ("".compareTo(strDate) == 0) {
			return false;
		}

		try {
			df.parse(strDate);

			return true;
		} catch (ParseException pe) {
			return false;
		}
	}

	/**
	 * getPreviousDate
	 * 
	 * @param date
	 * @param nbDays
	 * @return
	 */
	public static java.util.Date getPreviousDate(java.util.Date date, int nbDays) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);

		int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int month = gc.get(GregorianCalendar.MONTH);
		int year = gc.get(GregorianCalendar.YEAR);

		GregorianCalendar previousDate = (GregorianCalendar) gc.clone();
		day = day - nbDays;

		while (day < 1) {
			if (month == 1) {
				month = 11;
				year--;
			} else {
				month--;
			}

			previousDate.setTime(DateUtil.convertStringToDate("1/"
					+ (month + 1) + "/" + year));

			day = getNbrDay(previousDate) + day;
		}

		previousDate.setTime(DateUtil.convertStringToDate(day + "/"
				+ (month + 1) + "/" + year));

		return previousDate.getTime();
	}

	/**
	 * getNextDate
	 * 
	 * @param date
	 * @param nbDays
	 * @return
	 */
	public static java.util.Date getNextDate(java.util.Date date, int nbDays) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);

		int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int month = gc.get(GregorianCalendar.MONTH);
		int year = gc.get(GregorianCalendar.YEAR);

		GregorianCalendar nextDate = (GregorianCalendar) gc.clone();
		day = day + nbDays;

		while (day > getNbrDay(nextDate)) {
			day = day - getNbrDay(nextDate);

			if (month == 11) {
				month = 0;
				year++;
			} else {
				month++;
			}

			nextDate.setTime(DateUtil.convertStringToDate("1/" + (month + 1)
					+ "/" + year));
		}

		nextDate.setTime(DateUtil.convertStringToDate(day + "/" + (month + 1)
				+ "/" + year));

		return nextDate.getTime();
	}

	public static boolean isBetweenTwoDate(Date dateDebut, Date dateFin,
			Date date) {
		if ((getDifferenceBetwen2DateInDay(dateDebut, date) <= 0)
				&& (getDifferenceBetwen2DateInDay(dateFin, date) >= 0)) {
			return true;
		}

		return false;
	}

	public static String getDateAfter(int nbJours) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);

		month += 1;
		int day = c.get(Calendar.DAY_OF_MONTH);

		day += nbJours;
		String date = year + "-" + month + "-" + day;

		return convertDateToString(java.sql.Date.valueOf(date));
	}

	public static long getDifferenceBetwen2DateInDay(Date date1, Date date2) {
		long journee = 86400000;
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long diff = time1 - time2;
		diff /= journee;

		return diff;
	}

	/**
	 * V�rifie si reste une journ�e � partir du date Syst�me
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isOneDayRemain(Date date) {
		boolean reste;
		long journee = 86400000;
		long time1 = 0;
		if (date != null){
			time1 = date.getTime();
		}
		long time2 = new java.sql.Date(System.currentTimeMillis()).getTime();
		long diff = time2 - time1;
		diff /= journee;
		reste = diff == 1 ? true : false;
		return reste;
	}

	/**
	 * 
	 * @param dateDebutMois
	 * @return
	 */
	public static java.util.Date getDateFinMois(Date dateDebutMois) {
		String input = DateUtil.getDate(dateDebutMois);
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateDebutMois);

		int lastDay = getNbrDay(calendar);

		return ConvertUtil.convertStringToDate(Integer.valueOf(lastDay).toString()
				+ "/" + input.substring(3, 10));
	}

	public static java.util.Date getDateDebutMoisMoins1(Date date) {
		String dateString = DateUtil.getDate(date);
		int tempmois = ConvertUtil.convertToInteger(dateString.substring(3, 5))
				.intValue();
		int tempannee = ConvertUtil.convertToInteger(
				dateString.substring(6, 10)).intValue();
		int moisMoins1 = (tempmois == 1) ? 12 : tempmois - 1;
		int anneeMoisMoins1 = (tempmois == 1) ? tempannee - 1 : tempannee;

		String mois = ConvertUtil.converToString(Integer.valueOf(moisMoins1));
		String annee = ConvertUtil.converToString(Integer.valueOf(anneeMoisMoins1));

		return ConvertUtil.convertStringToDate("01/" + mois + "/" + annee);
	}

	public static String getCurrentYear() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		int year = c.get(Calendar.YEAR);
		return "" + year;
	}

	public static java.sql.Date getDateTomorrow() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		month += 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		day += 1;
		String date = year + "-" + month + "-" + day;
		return java.sql.Date.valueOf(date);
	}
	
	public static java.sql.Date getCurrentDay() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		month += 1;
		int day = c.get(Calendar.DAY_OF_MONTH);

		String monthDeuxChiffre=""+month;
		if (monthDeuxChiffre.length()==1)
			monthDeuxChiffre="0"+month;
		String dayDeuxChiffre = ""+day; 
		if(dayDeuxChiffre.length()==1){
			dayDeuxChiffre="0"+day;
		}
		String date = year + "-" + monthDeuxChiffre + "-" + dayDeuxChiffre;
		return java.sql.Date.valueOf(date);
	}

	public static int DifferenceTwoDates(Date date1,Date date2) {
		
		
	long diff = date1.getTime() - date2.getTime();
	
	long numberOfDay = (long)diff/CONST_DURATION_OF_DAY;
	return (int) numberOfDay;
	
	}
	
	/**
	 * getOnlyDate
	 * 
	 * @param date
	 * @return
	 */
	public static final Date getOnlyDate(Date date) {
		return getOnlyDate(datePattern, date);
	}

	/**
	 * getOnlyDate
	 * 
	 * @param aMask
	 * @param date
	 * @return
	 */
	public static final Date getOnlyDate(String aMask, Date date) {
		return convertStringToDate(aMask, getDateTime(aMask, date));
	}

	/**
	 * Methode getNbrDay
	 * 
	 * @param date
	 * @return
	 */
	public static int getNbrDay(GregorianCalendar date) {
		int month = date.get(GregorianCalendar.MONTH);
		int year = date.get(GregorianCalendar.YEAR);

		if (month == 1) {
			if (date.isLeapYear(year)) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return MONTHS_NBR[month - 1];
		}
	}

}