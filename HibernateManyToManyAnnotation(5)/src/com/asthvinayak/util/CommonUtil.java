package com.asthvinayak.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author manish
 * 
 */
public class CommonUtil {

	public static String dateConverts(java.util.Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		String strDate = sdf.format(date);

		return strDate;
	}

	public static java.util.Date dateConvert(String date) {
		java.util.Date utilDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			utilDate = sdf.parse(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return utilDate;
	}
}
