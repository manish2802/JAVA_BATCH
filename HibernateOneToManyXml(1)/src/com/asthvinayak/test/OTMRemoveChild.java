package com.asthvinayak.test;
import com.asthvinayak.dao.OTMDaoFactory;

public class OTMRemoveChild {
	public static void main(String[] args) {
		OTMDaoFactory.getInstance().removeChild("105","301");
	}
}
