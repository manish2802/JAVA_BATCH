package com.asthvinayak.test;

import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.entity.CustomerDTO;

public class OTMSelectParentLazyHQL {

	public static void main(String[] args) throws InterruptedException {
		CustomerDTO cust = (CustomerDTO) OTMDaoFactory.getInstance().getParentLazyHQL();

	}

}
