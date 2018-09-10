/**FileName:EmployeeImpl.java
 *  
 */
package com.asthvinayak.business;

import com.asthvinayak.dao.EmployeeDAO;

public class EmployeeBOImpl implements EmployeeBO {

	private String empName;
	private String salary;
	private String address;
	private EmployeeDAO employeeDAO;

	// dependency injection through constructor
	public EmployeeBOImpl(String empName, String salary, String address, EmployeeDAO employeeDAO) {
		this.empName = empName;
		this.salary = salary;
		this.address = address;
		this.employeeDAO = employeeDAO;

	}

	@Override
	public void getEmployeeDetail() {
		// TODO Auto-generated method stub
		System.out.println("Employee Details: " + empName + "||" + salary + "||" + address);
		employeeDAO.getEmployeeDetail();

	}

}
