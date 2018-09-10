/**FileName:EmployeeImpl.java
 *  
 */
package com.asthvinayak.business;

public class EmployeeBOImpl2 implements EmployeeBO2 {

	private EmployeeBO1 employeeBO1;

	// dependency injection through constructor
	public EmployeeBOImpl2(EmployeeBO1 employeeBO1) {
		this.employeeBO1 = employeeBO1;
		System.out.println("i am in constructor");

	}

	@Override
	public void getEmployeeDetail() {
		System.out.println("EmployeeBOImpl2");

	}

}
