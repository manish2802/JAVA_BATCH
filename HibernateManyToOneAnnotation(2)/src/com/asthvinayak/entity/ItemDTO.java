package com.asthvinayak.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_MTO_ANNOTATION")
public class ItemDTO {

	@Id
	@Column(name = "ITEM_ID")
	private String itemId;

	@Column(name = "ITEM_NAME", length = 10)
	private String itemName;

	@Column(name = "PRICE")
	private double price;

	@ManyToOne(targetEntity = CustomerDTO.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CID_PK")
	private CustomerDTO customer;

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

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

}
