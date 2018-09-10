/**FileName:EmployeeImpl.java
 *  
 */
package com.asthvinayak.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.asthvinayak.dao.EmployeeDAO;

public class EmployeeBOImpl implements EmployeeBO {

	@Autowired
	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO1) {
		this.employeeDAO = employeeDAO1;
	}

	@Override
	public String getEmployeeDetail() {
		System.out.println(employeeDAO.hashCode());
		// TODO Auto-generated method stub
		 return employeeDAO.getEmployeeDetail();
	}

}
