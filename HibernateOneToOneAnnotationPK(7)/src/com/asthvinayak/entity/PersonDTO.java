package com.asthvinayak.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_oto_Pk")
public class PersonDTO {

	@Id
	@Column(name = "pid")
	private int personId;

	@Column(name = "pname", length = 8)
	private String personName;

	@Column(name = "gender")
	private String gender;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
