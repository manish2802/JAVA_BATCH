package com.asthvinayak.dao;

public class OTODaoFactory {

	private static OTODao instance = null;

	public static OTODao getInstance() {

		if (instance == null) {
			instance = (OTODao) new OTODaoImpl();
		}
		return instance;
	}
}
