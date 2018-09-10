/**FileName:EmployeeImpl.java
 *  
 */
package com.asthvinayak.business;

import com.asthvinayak.dao.EmployeeDAO;

public class EmployeeBOImpl implements EmployeeBO {

	private EmployeeDAO employeeDAO2;

	EmployeeBOImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO2 = employeeDAO;
	}

	@Override
	public void getEmployeeDetail() {
		System.out.println(employeeDAO2.hashCode());
		// TODO Auto-generated method stub
		employeeDAO2.getEmployeeDetail();
	}

}
