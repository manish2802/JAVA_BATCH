package com.asthvinayak.test;
import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.model.Customer;

public class OTMSelectEarlyLoading {

	public static void main(String[] args) {
		//Eager Required in entity.
		Customer cust = (Customer) OTMDaoFactory.getInstance().getParentLazy("103");
		System.out.println(cust.toString());
	}
}
