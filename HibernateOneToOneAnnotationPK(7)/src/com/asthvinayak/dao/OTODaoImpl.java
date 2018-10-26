package com.asthvinayak.dao;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asthvinayak.entity.PassportDTO;
import com.asthvinayak.util.HibernateUtil;

/**
 * 
 * @author manish
 *
 */
public class OTODaoImpl implements OTODao {
	private static Logger LOGGER = Logger.getLogger(OTODaoImpl.class);
	private static String CLASS_NAME = OTODaoImpl.class.getName();

	public Serializable saveOneToOne(PassportDTO passport) {
		String METHOD_NAME = "saveOneToOne";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Serializable id = null;
		Transaction transaction = null;
		Session session = HibernateUtil.currentSession();
		try {
			transaction = session.beginTransaction();
			id = session.save(passport);
			LOGGER.info(id + " inserted");
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
		return id;

	}

}
