package com.asthvinayak.dao;

import java.io.Serializable;

import com.asthvinayak.entity.PassportDTO;

public interface OTODao {

	public Serializable saveOneToOne(PassportDTO passport);

}
