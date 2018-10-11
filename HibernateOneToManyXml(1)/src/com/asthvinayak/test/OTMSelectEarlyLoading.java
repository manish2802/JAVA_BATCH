package com.asthvinayak.test;
import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.model.CustomerDTO;

public class OTMSelectEarlyLoading {

	public static void main(String[] args) {
		//Eager Required in entity.
		CustomerDTO cust = (CustomerDTO) OTMDaoFactory.getInstance().getParentLazy("103");
		System.out.println(cust.toString());
	}
}
