package com.asthvinayak.spring.hibernate;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.asthvinayak.dto.Employee;

public class SpringTransactionUsingHibernateApiExample {
    private SessionFactory sessionFactory;
    public static void main(String[] args) throws MappingException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringTransactionUsingHibernateApiExample springHibernateTemplateExample = (SpringTransactionUsingHibernateApiExample) context.getBean("springHibernateSessionExample");
        springHibernateTemplateExample.execute();
    }
    
    @Transactional(readOnly=true)
    public List<?> findEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Employee where name in (?, ?)");
        query.setParameter(0, "Joe");
        query.setParameter(1, "Sam");
        List<?> empList = query.list();
        System.out.println("Employees found: " + empList.size());
        return empList;
    }
    
    @Transactional(readOnly=false)
    public void deleteEmployees(List<?> empList) {
        if (!empList.isEmpty()) {
            Session session = sessionFactory.getCurrentSession();
            for (Object emp : empList) {
                session.delete(emp);
            }
            System.out.println("Employees deleted");
        }
    }
     
    @Transactional(readOnly=false)
    public void createEmployee(String name){
        System.out.println("Create new employee " + name);
        Session session = sessionFactory.getCurrentSession();
        Employee emp = new Employee();
        emp.setName(name);
        session.saveOrUpdate(emp);
        System.out.println("Employee created " + emp);
    }
    
    @Transactional(readOnly=false)
    public void saveEmployee(Employee emp){
        System.out.println("Create new employee " + emp);
        Session session = sessionFactory.getCurrentSession();
        session.save(emp);
        System.out.println("Employee created " + emp);        
    }
    
    @Transactional(readOnly=false)
    public void execute() {
        List<?> empList = findEmployees();
        deleteEmployees(empList);
        createEmployee("Joe");
        Employee empSam = new Employee();
        empSam.setName("Sam");
        saveEmployee(empSam);
        System.out.println("List of employees: " + findEmployees());
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }    
}
