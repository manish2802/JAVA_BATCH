import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asthvinayak.business.CustomerBO;
import com.asthvinayak.business.EmployeeBO;

public class Test {

	public static void main(String[] args) {

		// IOC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		EmployeeBO employee = (EmployeeBO) ac.getBean("employeeBO");
		employee.getEmployeeDetail();

		CustomerBO customer = (CustomerBO) ac.getBean("customerBO");
		customer.getCustomerDetail();

	}
}
