package com.asthvinayak.test;
import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.model.CustomerDTO;

public class OTMSelectParentLazy {

	public static void main(String[] args) {
		CustomerDTO cust = (CustomerDTO) OTMDaoFactory.getInstance().getParentLazy("105");

		System.out.println(cust.getCustomerName());

	}

}
