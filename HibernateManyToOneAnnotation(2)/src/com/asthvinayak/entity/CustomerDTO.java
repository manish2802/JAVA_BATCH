package com.asthvinayak.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author manish
 *
 */
@Entity
@Table(name = "CUSTOMER_MTO_ANNOTATION")
public class CustomerDTO {
	@Id
	@Column(name = "CID")
	private String customerId;

	@Column(name = "CNAME", length = 10)
	private String customerName;

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

}
