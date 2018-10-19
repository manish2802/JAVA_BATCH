package com.asthvinayak.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_OTM_BI_ANNOTATION")
public class ItemDTO {

	@Id
	@Column(name = "ITEM_ID")
	private String itemId;
	@Column(name = "ITEM_NAME", length = 10)
	private String itemName;
	@Column(name = "PRICE")
	private double price;

	@ManyToOne(targetEntity = CustomerDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "CID_FK")
	private CustomerDTO customer1;

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

	public CustomerDTO getCustomer() {
		return customer1;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer1 = customer;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + "]";
	}

}
