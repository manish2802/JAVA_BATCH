import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asthvinayak.business.EmployeeRecoredBO;

public class Test {

	public static void main(String... k) {

		// IOC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeRecoredBO erb = (EmployeeRecoredBO) ac.getBean("employeeRecoredBO");

		erb.getRecordBO();
	}
}
