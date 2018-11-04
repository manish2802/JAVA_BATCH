package com.newgen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {

	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/cust_inboard";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";

	/**
	 * For getting the connection
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			
			// Load the driver
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			return con;
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection(Connection con, PreparedStatement pstm) {
		try {
			if (con != null) {
				con.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}
}
