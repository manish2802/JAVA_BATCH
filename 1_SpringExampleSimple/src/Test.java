
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asthvinayak.business.DemoBO1;
import com.asthvinayak.business.DemoBO2;

public class Test {

	public static void main(String[] args) {

		// IOC container
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		System.out.println("=================");
		DemoBO1 demoBO = (DemoBO1) ac.getBean("demo1");
		demoBO.show();
		System.out.println(demoBO.hashCode());

		DemoBO1 demoBO1 = (DemoBO1) ac.getBean("demo1");
		demoBO.show();
		System.out.println(demoBO1.hashCode());

		// DemoBO2 demoBO2 = (DemoBO2) ac.getBean("demo2");
		// demoBO2.display();

	}

}
