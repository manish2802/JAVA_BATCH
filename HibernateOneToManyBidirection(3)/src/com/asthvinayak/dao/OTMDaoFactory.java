package com.asthvinayak.dao;

public class OTMDaoFactory {
	public static OTMDAOImpl otm = null;

	public static OTMDAOImpl getInstance() {
		if (otm == null) {
			otm = new OTMDAOImpl();
			return otm;
		}
		return otm;
	}

}
