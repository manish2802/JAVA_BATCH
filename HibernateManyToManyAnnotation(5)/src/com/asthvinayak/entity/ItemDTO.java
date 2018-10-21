package com.asthvinayak.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author manish
 *
 */
@Entity
@Table(name = "item_mtm")
public class ItemDTO {

	@Id
	@Column(name = "item_id")
	private String itemId;

	@Column(name = "item_name", length = 10)
	private String itemName;

	@Column(name = "price")
	private double price;

	@ManyToMany(targetEntity = CustomerDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "cust_item_mtm", joinColumns = {
			@JoinColumn(name = "item_fk", referencedColumnName = "item_id") }, inverseJoinColumns = {
					@JoinColumn(name = "cust_fk", referencedColumnName = "cust_id") })
	private Set<CustomerDTO> customers;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<CustomerDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<CustomerDTO> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", Customers=" + customers
				+ "]";
	}

}
