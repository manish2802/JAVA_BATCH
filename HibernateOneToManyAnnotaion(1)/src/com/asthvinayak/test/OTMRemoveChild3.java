package com.asthvinayak.test;
import com.asthvinayak.dao.OTMDaoFactory;

public class OTMRemoveChild3 {
	public static void main(String[] args) {
		OTMDaoFactory.getInstance().removeChild("103","200");
	}
}
