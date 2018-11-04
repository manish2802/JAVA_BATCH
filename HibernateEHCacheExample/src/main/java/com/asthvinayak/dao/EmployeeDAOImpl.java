package com.asthvinayak.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.asthvinayak.model.Employee;
import com.asthvinayak.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class);
	private static String CLASS_NAME = EmployeeDAOImpl.class.getName();

	public void secondLevelCache() {
		String METHOD_NAME = "secondLevelCache";
		LOGGER.debug("Enter Into " + METHOD_NAME + " in " + CLASS_NAME);

		System.out.println("Temp Dir:" + System.getProperty("java.io.tmpdir"));

		// Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Statistics stats = sessionFactory.getStatistics();

		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());

		Session session = sessionFactory.openSession();
		Session otherSession = sessionFactory.openSession();

		Transaction transaction = null;
		Transaction otherTransaction = null;

		try {
			transaction = session.beginTransaction();
			otherTransaction = otherSession.beginTransaction();

			HibernateUtil.printStats(stats, 0);

			// Thread.sleep(5000);

			Employee emp = (Employee) session.load(Employee.class, 1L);
			System.out.println(emp);
			HibernateUtil.printData(emp, stats, 1);

			// Thread.sleep(5000);
			emp = (Employee) session.load(Employee.class, 1L);
			HibernateUtil.printData(emp, stats, 2);

			// Thread.sleep(5000);
			// clear first level cache, so that second level cache is used
			session.evict(emp);
			System.out.println("clear session cache..!");
			emp = (Employee) session.load(Employee.class, 1L);
			HibernateUtil.printData(emp, stats, 3);

			// Thread.sleep(10000);
			emp = (Employee) session.load(Employee.class, 3L);
			HibernateUtil.printData(emp, stats, 4);

			// Thread.sleep(5000);
			emp = (Employee) otherSession.load(Employee.class, 1L);
			HibernateUtil.printData(emp, stats, 5);

			emp = (Employee) session.load(Employee.class, 4L);
			HibernateUtil.printData(emp, stats, 4);
			transaction.commit();
			otherTransaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			if (otherTransaction != null) {
				otherTransaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			sessionFactory.close();
		}

		LOGGER.debug("Exit from " + METHOD_NAME + " in " + CLASS_NAME);
	}

}
