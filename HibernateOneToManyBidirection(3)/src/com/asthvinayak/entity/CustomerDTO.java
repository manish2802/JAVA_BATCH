package com.asthvinayak.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author manish
 *
 */
@Entity
@Table(name = "CUSTOMER_OTM_BI_ANNOTATION")
public class CustomerDTO {
	@Id
	@Column(name = "CID")
	private String customerId;

	@Column(name = "CNAME", length = 10)
	private String customerName;

	// @OneToMany(targetEntity = ItemDTO.class, cascade = CascadeType.ALL, fetch =
	// FetchType.LAZY)
	@OneToMany(targetEntity = ItemDTO.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer1")
	//@JoinColumn(name = "CID_FK")
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

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", Item=" + Item + "]";
	}

}
