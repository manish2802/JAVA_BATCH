/**FileName:CommonUtil.java
 * @author
 */
package com.newgen.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	/**
	 * For Checking Not Null;
	 *   
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		System.out.println(str);
		if (!str.trim().equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * For Checking Mobile no;
	 * 
	 * @param str
	 * @return
	 */
	public static boolean getMobileNoLength(String str) {
		if (str.length() == 10) {
			return true;
		}
		return false;
	}

	/**
	 * For converting string to java.util.Date
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate) throws ParseException {
		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date = formatter.parse(strDate);
		return date;
	}

	/**
	 * 
	 * @param javaDate
	 * @return
	 */
	public static java.sql.Date convertFromJAVADateToSQLDate(java.util.Date javaDate) {
		java.sql.Date sqlDate = null;
		if (javaDate != null) {
			sqlDate = new java.sql.Date(javaDate.getTime());
		}
		return sqlDate;
	}
	
	/**
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static java.sql.Date convertStringToSQLDate(String strDate) throws ParseException {
		Date date = convertStringToDate(strDate);
		java.sql.Date sqlDate = convertFromJAVADateToSQLDate(date);
		return sqlDate;
	}
	
	public static void main(String...k) throws ParseException {
		System.out.println(convertStringToSQLDate("7777-12-23"));
	}
	
	

}
