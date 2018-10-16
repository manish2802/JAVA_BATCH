package com.asthvinayak.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asthvinayak.entity.ItemDTO;
import com.asthvinayak.util.HibernateUtil;

public class MTODaoImpl implements MTODao {
	private static Logger LOGGER = Logger.getLogger(MTODaoImpl.class);
	private static String CLASS_NAME = MTODaoImpl.class.getName();

	/**
	 * 
	 */
	public void saveManyToOne(List<ItemDTO> listItems) {
		String METHOD_NAME = "saveManyToOne";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		Session session = HibernateUtil.currentSession();
		try {
			transaction = session.beginTransaction();
			for (ItemDTO item : listItems) {
				session.save(item);
				LOGGER.info(" inserted");
			}
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		LOGGER.debug("Exit from " + METHOD_NAME + " in " + CLASS_NAME);

	}
}
