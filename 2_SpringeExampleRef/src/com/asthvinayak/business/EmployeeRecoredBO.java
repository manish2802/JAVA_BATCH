package com.asthvinayak.business;

import com.asthvinayak.dao.EmployeeDAO;

public class EmployeeRecoredBO {

	EmployeeDAO employeeDAO;

	public EmployeeRecoredBO() {
		System.out.println("EmployeeRecoredBO created");
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		System.out.println("EmployeeDAO Injected into EmployeeRecoredBO");
		this.employeeDAO = employeeDAO;
	}

	public void getRecordBO() {
		employeeDAO.getRecord();

	}
}
