import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.asthvinayak.dao.MTMDaoFactory;
import com.asthvinayak.entity.CustomerDTO;
import com.asthvinayak.entity.ItemDTO;

public class MTMAnnotationInsert {

	public static void main(String[] args) {
		// Parent-1
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setCustomerId("103");
		customer1.setCustomerName("smith");
		customer1.setDate(new Date());

		// Parent-2
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId("104");
		customer2.setCustomerName("david");
		customer2.setDate(new Date());

		// Child-1
		ItemDTO item1 = new ItemDTO();
		item1.setItemId("200");
		item1.setItemName("sunsilk");
		item1.setPrice(500);

		// Child-2
		ItemDTO item2 = new ItemDTO();
		item2.setItemId("300");
		item2.setItemName("patanjali");
		item2.setPrice(300);

		Set<CustomerDTO> setCustomer = new HashSet<CustomerDTO>();
		setCustomer.add(customer1);
		setCustomer.add(customer2);

		item1.setCustomers(setCustomer);
		item2.setCustomers(setCustomer);

		Set<ItemDTO> items = new HashSet<ItemDTO>();
		items.add(item1);
		items.add(item2);
		MTMDaoFactory.getInstance().saveManyToMany(items);

	}
}
