package com.asthvinayak.test;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.entity.CustomerDTO;
import com.asthvinayak.entity.ItemDTO;

public class OTMAnnotationInsert1 {

	public static void main(String[] args) {
		// Child-1
		ItemDTO item1 = new ItemDTO();
		item1.setItemId("101");
		item1.setItemName("sunsilk");
		item1.setPrice(500);
		item1.setCreatedDate(new Date());

		// Child-2
		ItemDTO item2 = new ItemDTO();
		item2.setItemId("102");
		item2.setItemName("patanjali");
		item2.setPrice(300);
		item2.setCreatedDate(new Date());

		Set<ItemDTO> setItem = new HashSet<ItemDTO>();
		setItem.add(item1);
		setItem.add(item2);

		// Parent-1
		CustomerDTO customer1 = new CustomerDTO();
		customer1.setCustomerId("103");
		customer1.setCustomerName("smtch");
		customer1.setCreatedDate(new Date());
		customer1.setItem(setItem);
		

		Serializable ser = OTMDaoFactory.getInstance().saveOneToMany(customer1);
		System.out.println(ser + " Sucessfully saved");
		System.out.println("Object state: " + customer1.toString());

	}

}
