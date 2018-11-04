package com.asthvinayak.dao;

public class EHCacheFactory {
	
	public static EmployeeDAO employeeDAO = null;

	public static EmployeeDAO getInstance() {
		if (employeeDAO == null) {
			employeeDAO = new EmployeeDAOImpl();
			return employeeDAO;
		}
		return employeeDAO;
	}

}
