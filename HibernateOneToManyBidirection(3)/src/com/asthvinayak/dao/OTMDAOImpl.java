package com.asthvinayak.dao;

import java.io.Serializable;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asthvinayak.entity.CustomerDTO;
import com.asthvinayak.entity.ItemDTO;
import com.asthvinayak.util.HibernateUtil;

public class OTMDAOImpl {
	private static Logger LOGGER = Logger.getLogger(OTMDAOImpl.class);
	private static String CLASS_NAME = "OTMDAOImpl";

	/**
	 * 
	 * @param customer
	 * @return
	 */
	public Serializable saveOneToManyBi(CustomerDTO customer) {
		String METHOD_NAME = "saveOneToMany";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Serializable id = null;
		Transaction transaction = null;
		Session session = HibernateUtil.currentSession();
		LOGGER.info("Before perform operation..!");
		try {
			transaction = session.beginTransaction();
			id = session.save(customer);
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

	/**
	 * 
	 * @param id
	 */
	public void removeParent(Serializable id) {
		String METHOD_NAME = "removeParent";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		Session session = HibernateUtil.currentSession();

		try {
			transaction = session.beginTransaction();
			CustomerDTO customer = (CustomerDTO) session.get(CustomerDTO.class, id);
			session.delete(customer);
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

	/**
	 * 
	 * @param id
	 * @return
	 */
	public CustomerDTO removeChild(Serializable id1, Serializable id2) {
		String METHOD_NAME = "removeParent";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		CustomerDTO customer = null;
		Session session = HibernateUtil.currentSession();

		try {
			transaction = session.beginTransaction();
			customer = (CustomerDTO) session.get(CustomerDTO.class, id1);
			Set<ItemDTO> items = customer.getItem();
			ItemDTO item = (ItemDTO) session.get(ItemDTO.class, id2);
			items.remove(item);
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
		return customer;
	}
	/**
	 * 
	 * @param id
	 * @param item
	 * @return
	 */
	public CustomerDTO addNewchild(Serializable id, ItemDTO item) {
		String METHOD_NAME = "addNewchild";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		CustomerDTO CustomerDTO = null;
		Session session = HibernateUtil.currentSession();

		try {
			transaction = session.beginTransaction();
			CustomerDTO = (CustomerDTO) session.get(CustomerDTO.class, id);
			Set<ItemDTO> setItem = CustomerDTO.getItem();
			setItem.add(item);
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
		return CustomerDTO;
	}

}