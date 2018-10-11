package com.asthvinayak.model;

import java.util.Set;

/**
 * 
 * @author manish
 *
 */

public class CustomerDTO {

	private String customerId;
	private String customerName;
	
	private Set<ItemDTO> items;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<ItemDTO> getItems() {
		return items;
	}

	public void setItems(Set<ItemDTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", Item=" + items + "]";
	}

}
