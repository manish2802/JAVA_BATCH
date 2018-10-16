import java.util.ArrayList;
import java.util.List;

import com.asthvinayak.dao.MTODaoFactory;
import com.asthvinayak.entity.CustomerDTO;
import com.asthvinayak.entity.ItemDTO;

public class MTOAnnotationInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDTO customer1 = new CustomerDTO();
		customer1.setCustomerId("100");
		customer1.setCustomerName("manish");

		ItemDTO item1 = new ItemDTO();
		item1.setItemId("200");
		item1.setItemName("BMW");
		item1.setPrice(40000.00);
		item1.setCustomer(customer1);

		ItemDTO item2 = new ItemDTO();
		item2.setItemId("201");
		item2.setItemName("HONDA");
		item2.setPrice(5000.00);
		item2.setCustomer(customer1);

		List<ItemDTO> listItems = new ArrayList<ItemDTO>();
		listItems.add(item1);
		listItems.add(item2);
		
		MTODaoFactory.getInstance().saveManyToOne(listItems);
		

	}

}
