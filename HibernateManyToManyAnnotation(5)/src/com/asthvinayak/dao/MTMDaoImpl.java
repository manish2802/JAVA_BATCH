package com.asthvinayak.dao;

import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asthvinayak.entity.ItemDTO;
import com.asthvinayak.util.HibernateUtil;

public class MTMDaoImpl implements MTMDao {
	private static Logger LOGGER = Logger.getLogger(MTMDaoImpl.class);
	private static String CLASS_NAME = MTMDaoImpl.class.getName();

	/**
	 * 
	 */
	public void saveManyToMany(Set<ItemDTO> listItems) {
		String METHOD_NAME = "saveManyToMany";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		Session session = HibernateUtil.currentSession();
		try {
			transaction = session.beginTransaction();
			for (ItemDTO item : listItems) {
				session.save(item);
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
