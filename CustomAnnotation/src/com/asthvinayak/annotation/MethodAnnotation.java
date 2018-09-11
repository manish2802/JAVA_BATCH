package com.asthvinayak.annotation;

import com.asthvinayak.annotation.ManishInfo;

public class MethodAnnotation {

	
	@ManishInfo(createdBy = "verma", tags = "{a,b,c}")
	public void method1() {
		System.out.println("method with annotation ManishInfo");
	}

}
