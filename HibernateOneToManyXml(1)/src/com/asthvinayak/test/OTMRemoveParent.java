package com.asthvinayak.test;
import com.asthvinayak.dao.OTMDaoFactory;

public class OTMRemoveParent {

	public static void main(String[] args) {
		OTMDaoFactory.getInstance().removeParent("103");
	}

}
