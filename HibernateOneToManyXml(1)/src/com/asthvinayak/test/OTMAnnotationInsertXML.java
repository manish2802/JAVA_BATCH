package com.asthvinayak.test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.model.CustomerDTO;
import com.asthvinayak.model.ItemDTO;

public class OTMAnnotationInsertXML {

	public static void main(String[] args) {
		// Child-1
		ItemDTO item1 = new ItemDTO();
		item1.setItemId("501");
		item1.setItemName("sunsilk");
		item1.setPrice(500.00);

		// Child-2
		ItemDTO item2 = new ItemDTO();
		item2.setItemId("502");
		item2.setItemName("patanjali");
		item2.setPrice(300.00);

		Set<ItemDTO> setItem = new HashSet<ItemDTO>();
		setItem.add(item1);
		setItem.add(item2);

		// Parent-1
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setCustomerId("106");
		customer1.setCustomerName("manish");
		customer1.setItems(setItem);

		Serializable ser = OTMDaoFactory.getInstance().saveOneToMany(customer1);
		System.out.println(ser + " Sucessfully saved");
		System.out.println("Object state: " + customer1.toString());

	}

}
