package com.asthvinayak.dao;

public class OTMDaoFactory {
	public static OTMDao otm = null;

	public static OTMDao getInstance() {
		if (otm == null) {
			otm = new OTMDaoImpl();
			return otm;
		}
		return otm;
	}

}
