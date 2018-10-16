package com.asthvinayak.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asthvinayak.entity.CustomerDTO;
import com.asthvinayak.entity.ItemDTO;
import com.asthvinayak.util.HibernateUtil;

public class OTMDaoImpl implements OTMDao {
	private static Logger LOGGER = Logger.getLogger(OTMDaoImpl.class);
	private static String CLASS_NAME = "OTMDAOImpl";

	/**
	 * 
	 * @param CustomerDTO
	 * @return
	 */
	public Serializable saveOneToMany(CustomerDTO CustomerDTO) {
		String METHOD_NAME = "saveOneToMany";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Serializable id = null;
		Transaction transaction = null;
		Session session = HibernateUtil.currentSession();
		LOGGER.info("Before perform operation..!");
		try {
			transaction = session.beginTransaction();
			id = session.save(CustomerDTO);
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
			CustomerDTO CustomerDTO = (CustomerDTO) session.get(CustomerDTO.class, id);
			session.delete(CustomerDTO);
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
	public CustomerDTO getParentLazy(Serializable id) {
		String METHOD_NAME = "getParentLazy";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		Transaction transaction = null;
		CustomerDTO CustomerDTO = null;
		Session session = HibernateUtil.currentSession();
		try {
			transaction = session.beginTransaction();
			// Change in Entity Lazy
			CustomerDTO = (CustomerDTO) session.get(CustomerDTO.class, id);
			// Child object Loading(observe sql query)
			// child object should be useful anywhere
			for (ItemDTO itemDTO : CustomerDTO.getItem()) {

				System.out.println(itemDTO);
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
		return CustomerDTO;
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
		CustomerDTO CustomerDTO = null;
		Session session = HibernateUtil.currentSession();

		try {
			transaction = session.beginTransaction();
			CustomerDTO = (CustomerDTO) session.get(CustomerDTO.class, id);
			System.out.println("*************************************************");
			LOGGER.info("Child Object Loaded..!");
			LOGGER.info("Collection Size:" + CustomerDTO.getItem().size());
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
		return CustomerDTO;
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
		CustomerDTO CustomerDTO = null;
		Session session = HibernateUtil.currentSession();

		try {
			transaction = session.beginTransaction();
			CustomerDTO = (CustomerDTO) session.get(CustomerDTO.class, id1);
			Set<ItemDTO> items = CustomerDTO.getItem();
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
		return CustomerDTO;
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
			// Criteria criteria = session.createCriteria(CustomerDTO.class);
			Query criteria = session.createQuery("from com.asthvinayak.entity.CustomerDTO");
			List<CustomerDTO> list = criteria.list();
/*
			for (CustomerDTO ct : list) {
				Thread.sleep(5000);
				System.out.println(ct.getItem());

			}*/

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