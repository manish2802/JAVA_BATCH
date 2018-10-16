package com.asthvinayak.test;
import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.entity.CustomerDTO;

public class OTMSelectParentLazy {

	public static void main(String[] args) {
		CustomerDTO cust = (CustomerDTO) OTMDaoFactory.getInstance().getParentLazy("103");

		System.out.println(cust.getItem());

	}

}
