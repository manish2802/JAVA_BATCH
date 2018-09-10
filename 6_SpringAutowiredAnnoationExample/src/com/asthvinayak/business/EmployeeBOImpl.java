/**FileName:EmployeeImpl.java
 *  
 */
package com.asthvinayak.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.asthvinayak.dao.EmployeeDAO;

public class EmployeeBOImpl implements EmployeeBO {

	@Autowired // Type and Name
	private EmployeeDAO employeeDAO;

	EmployeeBOImpl() {
		System.out.println("EmployeeBOImpl");
		System.out.println("Dependency: " + employeeDAO);
	}

	// no setter use
	// @Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		System.out.println("employeeDAO injected in EmployeeBOImpl");
	}

	@Override
	public void getEmployeeDetail() {
		// TODO Auto-generated method stub
		employeeDAO.getEmployeeDetail();

	}

}
