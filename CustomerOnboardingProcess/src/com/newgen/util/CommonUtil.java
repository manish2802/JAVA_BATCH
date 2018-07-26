/**
 * 
 */
package com.newgen.util;

public class CommonUtil {

	/**
	 * For Checking Not Null;
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		System.out.println(str.length());
		if (str != null || !str.equals("")) {
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

}
