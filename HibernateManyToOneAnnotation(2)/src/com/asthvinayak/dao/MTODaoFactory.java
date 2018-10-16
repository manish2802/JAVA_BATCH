package com.asthvinayak.dao;

public class MTODaoFactory {

	private static MTODao instance = null;

	public static MTODao getInstance() {

		if (instance == null) {
			instance = (MTODao) new MTODaoImpl();
		}
		return instance;
	}
}
