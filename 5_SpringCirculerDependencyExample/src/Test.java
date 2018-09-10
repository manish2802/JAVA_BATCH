import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asthvinayak.business.EmployeeBO1;

public class Test {

	public static void main(String[] args) {

		// IOC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeBO1 e = (EmployeeBO1) ac.getBean("employeeBO1");
		e.getEmployeeDetail();
	}
}
