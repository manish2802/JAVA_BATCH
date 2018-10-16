package com.asthvinayak.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author manish
 *
 */
@Entity
@Table(name = "CUSTOMER_OTM_ANNOTATION")
public class CustomerDTO {
	@Id
	@Column(name = "CID")
	private String customerId;

	@Column(name = "CNAME", length = 10)
	private String customerName;

	@Temporal(TemporalType.DATE) // java.util.Date
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@OneToMany(targetEntity = ItemDTO.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true/*
																														 * For
																														 * Child
																														 */)
	@JoinColumn(name = "CID_FK")
	// @Fetch(FetchMode.SELECT)
	// @Fetch(FetchMode.JOIN)
	// @BatchSize(size = 10)
	private Set<ItemDTO> Item;

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

	public Set<ItemDTO> getItem() {
		return Item;
	}

	public void setItem(Set<ItemDTO> item) {
		Item = item;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", Item=" + Item + "]";
	}

}
