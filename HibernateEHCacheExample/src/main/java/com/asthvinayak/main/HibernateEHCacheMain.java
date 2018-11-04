package com.asthvinayak.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.asthvinayak.model.Employee;
import com.asthvinayak.util.HibernateUtil;

public class HibernateEHCacheMain {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Temp Dir:" + System.getProperty("java.io.tmpdir"));

		// Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Statistics stats = sessionFactory.getStatistics();

		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());

		Session session = sessionFactory.openSession();
		Session otherSession = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Transaction otherTransaction = otherSession.beginTransaction();

		printStats(stats, 0);

		//Thread.sleep(5000);

		Employee emp = (Employee) session.load(Employee.class, 1L);
		System.out.println(emp);
		printData(emp, stats, 1);

		//Thread.sleep(5000);
		emp = (Employee) session.load(Employee.class, 1L);
		printData(emp, stats, 2);

		//Thread.sleep(5000);
		// clear first level cache, so that second level cache is used
		session.evict(emp);
		System.out.println("clear session cache..!");
		emp = (Employee) session.load(Employee.class, 1L);
		printData(emp, stats, 3);

		//Thread.sleep(10000);
		emp = (Employee) session.load(Employee.class, 3L);
		printData(emp, stats, 4);

		// Thread.sleep(5000);
		emp = (Employee) otherSession.load(Employee.class, 1L);
		printData(emp, stats, 5);

		emp = (Employee) session.load(Employee.class, 4L);
		printData(emp, stats, 4);

		// Release resources
		transaction.commit();
		otherTransaction.commit();
		sessionFactory.close();
	}

	private static void printStats(Statistics stats, int i) {
		System.out.println("***** " + i + " *****");
		System.out.println("Fetch Count=" + stats.getEntityFetchCount());
		System.out.println("Second Level Hit Count=" + stats.getSecondLevelCacheHitCount());
		System.out.println("Second Level Miss Count=" + stats.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count=" + stats.getSecondLevelCachePutCount());
	}

	private static void printData(Employee emp, Statistics stats, int count) {
		System.out.println(count + ":: Name=" + emp.getName());
		printStats(stats, count);
	}

}
