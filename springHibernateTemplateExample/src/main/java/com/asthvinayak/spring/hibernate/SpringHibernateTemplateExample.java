package com.asthvinayak.spring.hibernate;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.asthvinayak.dto.Employee;

public class SpringHibernateTemplateExample {
    private HibernateTemplate hibernateTemplate;
    public static void main(String[] args) throws MappingException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringHibernateTemplateExample springHibernateTemplateExample = (SpringHibernateTemplateExample) context.getBean("springHibernateTemplateExample");
        springHibernateTemplateExample.execute();
    }
    
    @Transactional(readOnly=true)
    public List<?> findEmployees() {
        List<?> empList = hibernateTemplate.find("from Employee where name in (?, ?)", "Joe", "Sam");
        System.out.println("Employees found: " + empList.size());
        return empList;
    }
    
    @Transactional(readOnly=false)
    public void deleteEmployees(List<?> empList) {        
        if (!empList.isEmpty()) {
            hibernateTemplate.deleteAll(empList);
            System.out.println("Employees deleted");
        }
    }
     
    @Transactional(readOnly=false)
    public void createEmployee(final String Name){
        System.out.println("Create new employee " + Name);
        Employee emp = hibernateTemplate.execute(new HibernateCallback<Employee>() {

            public Employee doInHibernate(Session session) throws HibernateException {
                Employee emp = new Employee();
                emp.setName(Name);
                session.saveOrUpdate(emp);
                return emp;
            }
        });
        System.out.println("Employee created " + emp);
    }
    
    @Transactional(readOnly=false)
    public void saveEmployee(Employee emp){
        System.out.println("Create new employee " + emp);
        hibernateTemplate.save(emp);
        System.out.println("Employee created " + emp);        
    }
    
    @Transactional(readOnly=false)
    public void execute() {
        List<?> empList = findEmployees();
        deleteEmployees(empList);
        Employee empJoe = new Employee();
        createEmployee("Joe");
        Employee empSam = new Employee();
        empSam.setName("Sam");
        saveEmployee(empSam);
        System.out.println("List of employees: " + findEmployees());
    }
    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }    
}
