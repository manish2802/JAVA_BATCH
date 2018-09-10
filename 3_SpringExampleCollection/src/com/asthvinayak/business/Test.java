package com.asthvinayak.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// IOC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		EmployRecord er = (EmployRecord) ac.getBean("employRecord");

		System.out.println("List: " + er.getAddressList());

		System.out.println("Set: " + er.getAddressSet());

		System.out.println("Map: " + er.getAddressMap());

		System.out.println("Properties: " + er.getAddressProp());

	}

}
