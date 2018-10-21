package com.asthvinayak.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author manish
 *
 */
@Entity
@Table(name = "customer_mtm")
public class CustomerDTO {
	@Id
	@Column(name = "cust_id")
	private String customerId;

	@Column(name = "cname", length = 10)
	private String customerName;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "buy_date")
	private Date date;

	@ManyToMany(targetEntity = ItemDTO.class, mappedBy = "customers")
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", items=" + items + "]";
	}

}
