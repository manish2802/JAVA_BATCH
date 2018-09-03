package com.asthvinayak.business;

import java.util.List;

public class DemoBO1 {

	int a; // primitive data type
	DemoBO2 demo; // Reference data type
	List<String> list; // Reference data type

	public void setA(int a1) {
		// System.out.println(a);
		this.a = a1;
	}

	public DemoBO1() {
		System.out.println("DemoBO1 created");
		System.out.println("value " + a);
	}

	public void show() {

		System.out.println("Injected value By Setter:" + a);
	}
}
