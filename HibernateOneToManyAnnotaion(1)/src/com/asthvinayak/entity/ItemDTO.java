package com.asthvinayak.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ITEM_OTM__ANNOTATION")
public class ItemDTO {

	@Id
	@Column(name = "ITEM_ID")
	private String itemId;

	@Temporal(TemporalType.DATE) // java.util.Date
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "ITEM_NAME", length = 10)
	private String itemName;
	
	
	@Column(name = "PRICE")
	private double price;

	
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

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

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + "]";
	}

}
