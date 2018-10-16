package com.asthvinayak.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asthvinayak.model.CustomerDTO;
import com.asthvinayak.model.ItemDTO;
import com.asthvinayak.util.HibernateUtil;

public class OTMDAOImpl {
	private static Logger LOGGER = Logger.getLogger(OTMDAOImpl.class);
	private static String CLASS_NAME = "OTMDAOImpl";

	/**
	 * 
	 * @param customer
	 * @return
	 */
	public Serializable saveOneToMany(CustomerDTO customer) {
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
	 * @throws InterruptedException
	 */
	public CustomerDTO getParentLazy(Serializable id) throws InterruptedException {

		String METHOD_NAME = "getParentLazy";

		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		CustomerDTO customer = null;
		Session session = HibernateUtil.currentSession();
		try {
			transaction = session.beginTransaction();
			// Change in Entity Lazy.
			customer = (CustomerDTO) session.get(CustomerDTO.class, id);

			Thread.sleep(5000);

			System.out.println(customer.getItems());
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
	 * @return
	 */
	public CustomerDTO getParentEarly(Serializable id) {
		String METHOD_NAME = "getParentEarly";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		CustomerDTO customer = null;
		Session session = HibernateUtil.currentSession();

		try {
			transaction = session.beginTransaction();
			customer = (CustomerDTO) session.get(CustomerDTO.class, id);
			System.out.println("*************************************************");
			LOGGER.info("Child Object Loaded..!");
			LOGGER.info("Collection Size:" + customer.getItems().size());
			transaction = session.beginTransaction();
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
	 * @return
	 */
	public CustomerDTO removeChild(Serializable id1, Serializable id2) {
		String METHOD_NAME = "removeChild";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		CustomerDTO customer = null;
		Session session = HibernateUtil.currentSession();

		try {
			transaction = session.beginTransaction();
			customer = (CustomerDTO) session.get(CustomerDTO.class, id1);
			Set<ItemDTO> items = customer.getItems();
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
		CustomerDTO customer = null;
		Session session = HibernateUtil.currentSession();

		try {
			transaction = session.beginTransaction();
			customer = (CustomerDTO) session.get(CustomerDTO.class, id);
			Set<ItemDTO> setItem = customer.getItems();
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
		return customer;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws InterruptedException
	 */
	public CustomerDTO getParentLazyHQL() throws InterruptedException {

		String METHOD_NAME = "getParentLazy";

		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		CustomerDTO customer = null;
		Session session = HibernateUtil.currentSession();
		try {
			transaction = session.beginTransaction();
			// Change in Entity Lazy.
			//Criteria criteria = session.createCriteria(CustomerDTO.class);
			Query criteria= (Query) session.createQuery("from CustomerDTO");
			List<CustomerDTO> list = criteria.getResultList();
			
			for (CustomerDTO ct : list) {
				Thread.sleep(5000);
				System.out.println(ct.getItems());

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
		return customer;
	}
	
	
}