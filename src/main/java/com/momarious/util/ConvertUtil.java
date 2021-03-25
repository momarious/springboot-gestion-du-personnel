package com.momarious.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;


/**
 * Utility class to convert one object to another.
 * 
 * <p>
 * <a href="ConvertUtil.java.html"> <i>View Source </i> </a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible </a>
 */
public final class ConvertUtil {
	
	//private static Log log = LogFactory.getLog(ConvertUtil.class);

	/**
	 * Method to convert a ResourceBundle to a Map object.
	 * 
	 * @param rb
	 *            a given resource bundle
	 * @return Map a populated map
	 */
	public static Map convertBundleToMap(ResourceBundle rb) {
		Map map = new HashMap();

		for (Enumeration keys = rb.getKeys(); keys.hasMoreElements();) {
			String key = (String) keys.nextElement();
			map.put(key, rb.getString(key));
		}

		return map;
	}

	/**
	 * Method to convert a ResourceBundle to a Properties object.
	 * 
	 * @param rb
	 *            a given resource bundle
	 * @return Properties a populated properties object
	 */
	public static Properties convertBundleToProperties(ResourceBundle rb) {
		Properties props = new Properties();

		for (Enumeration keys = rb.getKeys(); keys.hasMoreElements();) {
			String key = (String) keys.nextElement();
			props.put(key, rb.getString(key));
		}

		return props;
	}


	/**
	 * Methode converToString
	 * 
	 * @param val
	 * @return
	 */
	public static String converToString(Double val) {
		if (val == null) {
			return "";
		} else {
			return String.valueOf(val);
		}
	}

	/**
	 * Methode converToString
	 * 
	 * @param val
	 * @return
	 */
	public static String converToString(Integer val) {
		if (val == null) {
			return "";
		} else {
			return String.valueOf(val);
		}
	}

	/**
	 * Methode converToString
	 * 
	 * @param val
	 * @return
	 */
	public static String converToString(BigDecimal val) {
		if (val == null) {
			return "";
		} else {
			return String.valueOf(val);
		}
	}

	/**
	 * Methode converToString
	 * 
	 * @param val
	 * @return
	 */
	public static String converToString(Object val) {
		if (val == null) {
			return "";
		} else {
			return String.valueOf(val);
		}
	}

	/**
	 * Methode convertToInteger
	 * 
	 * @param val
	 * @return
	 */
	public static Double convertToDouble(String val) {
		StringBuffer buffer = new StringBuffer();
		if (val == null) {
			return null;
		} else {
			if (val.compareTo("") == 0) {
				return null;
			} else {
				String t[]=val.split(" ");
				for(int i=0;i<t.length;i++){
					buffer.append(t[i]);
				}
				if(buffer.toString().compareTo("") != 0){
					val=buffer.toString();
				}
				return new Double(val);
			}
		}
	}

	/**
	 * Methode convertToInteger
	 * 
	 * @param val
	 * @return
	 */
	public static Integer convertToInteger(String val) {
		try  {
			if (val == null) {
				return null;
			} else {
				if (val.compareTo("") == 0) {
					return null;
				}
				else if (val.compareTo("NULL") == 0) {
						return null;	
				} else {
					return Integer.valueOf(val);
				}
			}
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * Methode convertToBigDecimal
	 * 
	 * @param val
	 * @return
	 */
	public static BigDecimal convertToBigDecimal(String val) {
		if (val == null) {
			return null;
		} else {
			if (val.compareTo("") == 0) {
				return null;
			}
			else if (val.compareTo("NULL") == 0) {
					return null;	
			} else {
				return new BigDecimal(val);
			}
		}
	}

	/**
	 * Methode convertToLong
	 * 
	 * @param val
	 * @return
	 */
	public static Long convertToLong(String val) {
		if (val == null) {
			return null;
		} else {
			if (val.compareTo("") == 0) {
				return null;
			} else {
				return new Long(val);
			}
		}
	}

	/**
	 * Methode convertDateToString
	 * 
	 * @param date
	 * @return
	 */
	public static String converToString(Date date) {
		try {
			if (date == null) {
				return "";
			}

			return String.valueOf(date);
		} catch (Exception e) {
			return "";
		}
	}

	public static String converToString(java.sql.Date date) {
		try {
			if (date == null) {
				return "";
			}

			return String.valueOf(date);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * Methode convertStringToDate
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertStringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (date == null) {
			return null;
		}

		if (date.compareTo("") == 0) {
			return null;
		}

		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static int getintValue(String value) {
		try {
			return (Integer.valueOf(value).intValue());
		} catch (NumberFormatException e) {
			//log.info("La valeur (" + value + ")n'est de type Integer");

			return 0;
		}
	}

	public static int getintValue(Integer value) {
		try {
			return value.intValue();
		} catch (Exception e) {
			//log.info("La valeur (" + value + ")n'est de type Integer");

			return 0;
		}
	}

	public static double getdoubleValue(String value) {
		try {
			return (Double.valueOf(value).doubleValue());
		} catch (NumberFormatException e) {
			//log.info("La valeur (" + value + ")n'est de type Double");

			return 0;
		}
	}

	public static double getdoubleValue(Double value) {
		try {
			return value.doubleValue();
		} catch (Exception e) {
			//log.info("La valeur (" + value + ")n'est de type Double");

			return 0;
		}
	}

	public static long getlongValue(String value) {
		try {
			return (Long.valueOf(value).longValue());
		} catch (NumberFormatException e) {
			//log.info("La valeur (" + value + ")n'est de type Long");

			return 0;
		}
	}

	public static long getlongValue(Long value) {
		try {
			return value.longValue();
		} catch (Exception e) {
			//log.info("La valeur (" + value + ")n'est de type Long");

			return 0;
		}
	}

	public static String getStringfromIntValue(int value) {
		return ConvertUtil.converToString(Integer.valueOf(value));
	}

}