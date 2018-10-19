import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.entity.CustomerDTO;
import com.asthvinayak.entity.ItemDTO;

public class OTMBIAnnotationInsert {

	public static void main(String[] args) {

		// Parent-1
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setCustomerId("103");
		customer1.setCustomerName("smith");

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

		// many-to-one
		item1.setCustomer(customer1);
		item2.setCustomer(customer1);

		// one-to-many
		// step-1
		Set<ItemDTO> setItem = new HashSet<ItemDTO>();
		setItem.add(item1);
		setItem.add(item2);
		customer1.setItem(setItem);

		Serializable ser = OTMDaoFactory.getInstance().saveOneToManyBi(customer1);
		System.out.println(ser + " Sucessfully saved");
		System.out.println("Object state: " + customer1.toString());

	}

}
