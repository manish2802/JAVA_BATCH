package com.asthvinayak.dao;

public class MTMDaoFactory {

	private static MTMDao instance = null;

	public static MTMDao getInstance() {

		if (instance == null) {
			instance = (MTMDao) new MTMDaoImpl();
		}
		return instance;
	}
}
