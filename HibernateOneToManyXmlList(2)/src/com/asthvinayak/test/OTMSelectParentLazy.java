package com.asthvinayak.test;
import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.model.Customer;

public class OTMSelectParentLazy {

	public static void main(String[] args) {
		Customer cust = (Customer) OTMDaoFactory.getInstance().getParentEarly("103");

		System.out.println(cust.toString());

	}

}
