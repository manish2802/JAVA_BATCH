package com.asthvinayak.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.asthvinayak.dao.OTMDaoFactory;
import com.asthvinayak.model.Customer;
import com.asthvinayak.model.Item;

public class OTMAnnotationInsertXML {

	public static void main(String[] args) {
		// Child-1
		Item item1 = new Item();
		item1.setItemId("200");
		item1.setItemName("sunsilk");
		item1.setPrice(500.00);

		// Child-2
		Item item2 = new Item();
		item2.setItemId("300");
		item2.setItemName("patanjali");
		item2.setPrice(300.00);

		List<Item> setItem = new ArrayList<Item>();
		setItem.add(item1);
		setItem.add(item2);

		// Parent-1
		Customer customer1 = new Customer();
		customer1.setCustomerId("103");
		customer1.setCustomerName("smith");
		customer1.setItems(setItem);

		Serializable ser = OTMDaoFactory.getInstance().saveOneToMany(customer1);
		System.out.println(ser + " Sucessfully saved");
		System.out.println("Object state: " + customer1.toString());

	}

}
