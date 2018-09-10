/**
 * FileName:CustomerImpl.java
 */
package com.asthvinayak.business;

import com.asthvinayak.dao.EmployeeDAO;

public class CustomerBOImpl implements CustomerBO {

	private String custName;
	private String custAddress;
	private EmployeeDAO employeeDAO;
	
	
	

	// setter injection
	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void getCustomerDetail() {
		// TODO Auto-generated method stub
		System.out.println("Customer Record: " + custName + "||" + custAddress);
		employeeDAO.getEmployeeDetail();

	}

}
