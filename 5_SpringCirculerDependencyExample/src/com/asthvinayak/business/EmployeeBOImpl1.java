/**FileName:EmployeeImpl.java
 *  
 */
package com.asthvinayak.business;

public class EmployeeBOImpl1 implements EmployeeBO1 {

	private EmployeeBO2 employeeBO2;

	// dependency injection through constructor

	/*
	 * public EmployeeBOImpl1(EmployeeBO2 employeeBO2) { this.employeeBO2 =
	 * employeeBO2;
	 * 
	 * }
	 */

	public void setEmployeeBO2(EmployeeBOImpl2 employeeBO2) {
		this.employeeBO2 = employeeBO2;
		System.out.println("i am in setter");
	}

	@Override
	public void getEmployeeDetail() {
		// employeeBO2.getEmployeeDetail();
	}

}
