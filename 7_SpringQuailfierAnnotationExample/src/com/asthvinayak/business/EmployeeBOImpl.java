/**FileName:EmployeeImpl.java
 *  
 */
package com.asthvinayak.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.asthvinayak.dao.EmployeeDAO;

public class EmployeeBOImpl implements EmployeeBO {

	@Autowired
	@Qualifier("employeeDAO1")  //ID
	//@Qualifier("employee") //if two class in xml so...!
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
