/**FileName:EmployeeImpl.java
 *  
 */
package com.asthvinayak.business;

import com.asthvinayak.dao.EmployeeDAO;

public class EmployeeBOImpl implements EmployeeBO {

	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO1) {
		this.employeeDAO = employeeDAO1;
	}

	@Override
	public void getEmployeeDetail() {
		System.out.println(employeeDAO.hashCode());
		// TODO Auto-generated method stub
		employeeDAO.getEmployeeDetail();
	}

}
